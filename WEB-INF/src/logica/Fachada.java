package logica;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import logica.colecciones.Clientes;
import logica.colecciones.Mudanzas;
import logica.colecciones.Servicios;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.ServicioException;
import negocio.Cliente;
import negocio.Mudanza;
import negocio.Servicio;
import persistencia.Persistencia;
import valueObjects.VOCliente;
import valueObjects.VOMudanzaDetallado;
import valueObjects.VOPersistencia;
import valueObjects.VOServicio;



public class Fachada extends UnicastRemoteObject implements IFachada { 

	public Fachada() throws RemoteException {
		super();
		this.monitor = new Monitor();
		this.clientes = new Clientes();
		this.mudanzas = new Mudanzas();
		this.servicios = new Servicios();
	}

	private static final long serialVersionUID = 1L;

	private Monitor monitor;
	private Clientes clientes;
	private Mudanzas mudanzas;
	private Servicios servicios;
	private Persistencia persistencia;

	/* 
	 * 1 - Alta de nuevo servicio de mudanza: Se registrar�n en el 
	 sistema todos los datos de un nuevo servicio de mudanza que la empresa comienza a ofrecer
	 */ 
	@Override
	public void nuevoServicio(boolean armadoMuebles, boolean embalaje, float costoXhora, float distanciaKm, String codigoServicio) throws RemoteException, ServicioException {
		this.monitor.comienzoEscritura();
		Servicio servicio = this.servicios.find(codigoServicio);
		if(servicio == null) {
			Servicio nuevoServicio = new Servicio(armadoMuebles, embalaje, costoXhora, distanciaKm, codigoServicio);
			this.servicios.insert(nuevoServicio);
		} else {
			throw new ServicioException("Ya existe un servicio con el código: " + codigoServicio);
		}
		this.monitor.terminoEscritura();
	}
	
	/* 
	 * 2 - Alta de nuevo cliente: Se registran en el sistema todos los datos de un nuevo cliente
	*/ 
	@Override
	public void altaNuevoCliente(int cedula, String nombre, String apellido, String telefono) throws ClienteException, RemoteException { 

		this.monitor.comienzoEscritura();
		Cliente nuevoCliente = new Cliente(cedula,nombre,apellido,telefono);
		if(this.clientes.esVacia()){
			this.clientes.insert(nuevoCliente);
		} else {
			Cliente cliente = this.clientes.find(cedula);
			if(cliente == null) {
				this.clientes.insert(nuevoCliente);
			} else {
				throw new ClienteException("Ya existe un cliente con la cédula: " + cedula);
			}
		}
		this.monitor.terminoEscritura();
	}

	/* 3 - Listado de clientes: Obtener un listado conteniendo c�dula, nombre, apellido y 
	 tel�fono de contacto de todos los clientes registrados en el sistema. 
	 Este listado debe realizarse ordenado en forma ascendente por n�mero de c�dula
	 */ 
	@Override
	public ArrayList<VOCliente> listadoClientes() throws RemoteException, ClienteException {
		ArrayList<VOCliente> clientes = null;
		this.monitor.comienzoLectura();
		clientes = this.clientes.listarClientes();
		if(clientes == null) {
			throw new ClienteException("No hay clientes");
		}
		this.monitor.terminoLectura();
		return clientes;
	}
	
	/* 4 - Contrataci�n de nuevo servicio de mudanza: Dados el c�digo de un servicio de mudanza 
	  y la c�dula de un cliente, registrar la contrataci�n. 
	  El servicio se marcar� autom�ticamente como no finalizado.
	  Se ingresar�n todos sus datos, excepto duraci�n y costo final. 
	  Los n�meros de contrataci�n ser�n secuenciales, la nueva contrataci�n tendr� un n�mero 
       consecutivo al de la �ltima contrataci�n registrada hasta el momento. 
	  Se debe verificar que la fecha sea igual o posterior al de la �ltima contrataci�n  
	  Se debe verificar  que haya al menos dos horas de separaci�n entre la hora de inicio 
	  de la nueva  contrataci�n y de las otras contrataciones registradas en esa fecha.
	*/ 
	@Override
	public void altaMudanza(int horaInicio, Date fechaMudanza, String domicilioOrigen,
			String domicilioDestino, int cedula, String codigoServicio) throws ClienteException, ServicioException, MudanzaException, RemoteException {

		this.monitor.comienzoEscritura();
		
		Cliente cliente = this.clientes.find(cedula);

		if(cliente == null) {
			throw new ClienteException("El cliente no existe");
		}

		Servicio servicio = this.servicios.find(codigoServicio);

		if(servicio == null) {
			throw new ServicioException("El servicio no existe");
		}

		Mudanza ultimaMudanza = this.mudanzas.getUltimo();
		if(ultimaMudanza == null) {
			Mudanza mudanza = new Mudanza(0, horaInicio, fechaMudanza, domicilioOrigen, domicilioDestino, cliente, servicio);
			this.mudanzas.insert(mudanza);
		} else {
			if(fechaMudanza.after(ultimaMudanza.getFechaMudanza()) || fechaMudanza.equals(ultimaMudanza.getFechaMudanza())) {
				ArrayList<VOMudanzaDetallado> mudanzas = this.listadoMudanzasXfecha(fechaMudanza);
				
				List<VOMudanzaDetallado> resultado = mudanzas.stream().filter(mudanza -> (horaInicio - mudanza.getHoraInicio()) >= 2).collect(Collectors.toList());
				
				if(!resultado.isEmpty()) {
					Mudanza mudanza = new Mudanza(ultimaMudanza.getNumContratacion() + 1, horaInicio, fechaMudanza, domicilioOrigen, domicilioDestino, cliente, servicio);
					this.mudanzas.insert(mudanza);
				} else {
					throw new MudanzaException("No hay mudanzas con al menos 2 hs de diferencia en la hora de inicio");
				}
				
			} else {
				throw new MudanzaException("Las fechas de la mudanza no son posteriores o iguales");
			}
		}
		this.monitor.terminoEscritura();
	}
	
	/*5 - Finalizaci�n de nuevo servicio de mudanza: Dado el n�mero que identifica a una
	  contrataci�n de servicio de mudanza, marcarla como finalizada. 
	  En ese momento, se ingresar� la duraci�n total que tuvo (en horas y minutos) 
	  y se calcular� autom�ticamente el costo final de la misma
	 */
	@Override
	public float finalizacionMudanza(int codigoMudanza, float duracion) throws RemoteException, MudanzaException, ServicioException {
		this.monitor.comienzoEscritura();
		float costoFinal = 0f;
		
		Mudanza mudanza = this.mudanzas.get(codigoMudanza);
		if(mudanza == null) {
			throw new MudanzaException("No existe una mudanza para el código" + codigoMudanza);
		} else {
			if(mudanza.isFinalizacion()) {
				throw new MudanzaException("La mudanza ya se encuentra finalizada");
			}
			mudanza.setDuracionTotal(duracion);
			mudanza.setFinalizacion(true);
			Servicio servicio = mudanza.getServicio();
			if(servicio == null) {
				throw new ServicioException("No existe una servicio con el código" + servicio.getCodigo());
			} else {
				costoFinal = mudanza.getDuracionTotal() * servicio.getCostoXhora();
			}
		}
		this.monitor.terminoEscritura();
		return costoFinal;
	}
	
	
	/*6 - Dado el n�mero que identifica a una contrataci�n de servicio 
 	    de mudanza, mostrar en detalle todos sus datos, incluyendo adem�s el c�digo alfanum�rico
 	     del servicio contratado y todos los datos del cliente correspondiente
   */
	@Override
	public Mudanza detalleMudanza(int codigoMudanza) throws RemoteException, MudanzaException {
		this.monitor.comienzoLectura();
		Mudanza mudanza = this.mudanzas.get(codigoMudanza);
		if(mudanza == null) {
			throw new MudanzaException("No hay una mudanza con el código" + codigoMudanza);
		}
		this.monitor.terminoLectura();
		return mudanza;
	}

	/*7 - Monto recaudado por rango de fechas:
	  Dadas dos fechas, calcular el monto total recaudado por concepto de contrataciones de
	  servicios de mudanza ya finalizadas entre esas dos fechas (incluyendo ambas)
	 ∫*/
	@Override
	public float montoRecaudado(Date fechaInicio, Date fechaFin) throws RemoteException, MudanzaException {
		this.monitor.comienzoLectura();
		float total = 0 ;
		int i = 0;
		Mudanza temp;
		Servicio serv;
		if (fechaInicio.after(fechaFin)) {
			throw new MudanzaException("La fecha de inicio debe ser anterior a la de fin");
		} else {
			for(i=0; i < (this.mudanzas.largo()); i++) {
				temp = this.mudanzas.get(i);
				serv = this.servicios.find(temp.getServicio().getCodigo());
				if (((temp.getFechaMudanza().after(fechaInicio)) || (temp.getFechaMudanza().equals(fechaInicio)))   && ((temp.getFechaMudanza().before(fechaFin) || (temp.getFechaMudanza().equals(fechaFin))))) {
					total = total + (temp.getDuracionTotal () * serv.getCostoXhora());
				}	
			}
		}
		this.monitor.terminoLectura();
		return total;
	}
	
   /*
 	8 - Guardar cambios: Respaldar en disco todos los datos de la aplicaci�n. 
 	Este requerimiento podr� ejecutarse cada vez que un empleado lo desee, especialmente 
 	tras haber ejecutado funcionalidades que produzcan cambios en la informaci�n manejada 
 	por el sistema. Todos los datos se respaldar�n juntos en un �nico archivo binario en disco 
 	(ubicado en el servidor central), para luego poder ser restaurados a memoria en una pr�xima
 	 ejecuci�n
   */
	@Override
	public void guardarCambios() throws PersistenciaException, RemoteException {	
		this.monitor.comienzoEscritura();
		VOPersistencia persistencia = new VOPersistencia(this.clientes, this.mudanzas, this.servicios);
		try {
			this.persistencia.respaldar(persistencia);
		} catch (IOException e) {
			throw new PersistenciaException("No se pudo respaldar");
		}
		this.monitor.terminoEscritura();
		
	}

	/* 9 - Restaurar informaci�n: Restaurar a memoria todos los datos de la aplicaci�n almacenados 
	 en disco. Este requerimiento ser� ejecutado autom�ticamente en el servidor central cada vez
	 que el sistema inicie su ejecuci�n (no ser� disparado por ning�n usuario que expl�citamente
	  solicite su ejecuci�n)
	*/
	@Override
	public void restaurarInformacion() throws PersistenciaException, RemoteException {
		this.monitor.comienzoLectura();
		VOPersistencia restaurar;
		try {
			restaurar = this.persistencia.recuperar();
			this.clientes = restaurar.getClientes();
			this.mudanzas = restaurar.getMudanzas(); 
			this.servicios = restaurar.getServicios();
		} catch (Exception e) {
			throw new PersistenciaException("No se pudo restaurar");
		}
		this.monitor.comienzoLectura();	
	}
	
	/*10 - Listado de servicios de mudanza ofrecidos: Obtener un listado conteniendo c�digo,
	 distancia, costo por hora, disponibilidad de servicio de embalaje y
	 disponibilidad de servicio de armado de muebles de todos los servicios de mudanza ofrecidos
	 por la empresa. Este listado se realizar� ordenado alfanum�ricamente por c�digo de servicio 
	 de mudanza
	 */
	@Override
	public ArrayList<VOServicio> listadoServicios() throws RemoteException, ServicioException {
		this.monitor.comienzoLectura();
		ArrayList<VOServicio> servicios = null;
		
		if(this.servicios == null || this.servicios.esVacio()) {
			throw new ServicioException("No hay servicios");
		} 
		
		servicios = this.servicios.listarServicios();
		this.monitor.terminoLectura();
		return servicios;
	}

	/*
	 11 - Listado de contrataciones realizadas por fecha: Dada una fecha, listar n�mero, 
	 hora de inicio y estado (finalizada o no finalizada) de todas las contrataciones de servicios
	 de mudanza registradas para dicha fecha. Este listado se realizar� ordenado por n�mero de
	 contrataci�n, de menor a mayor
	 */
	@Override
	public ArrayList<VOMudanzaDetallado> listadoMudanzasXfecha(Date fecha) throws RemoteException, MudanzaException {
		
		ArrayList<VOMudanzaDetallado> resultado = null;
		
		this.monitor.comienzoLectura();
		if(this.mudanzas.esVacia()) {
			throw new MudanzaException("No hay datos");
		}
		resultado = (ArrayList<VOMudanzaDetallado>) this.mudanzas.listarMudanzas().stream()
		.filter(mudanza -> mudanza.getFechaMudanza().equals(fecha))
		.collect(Collectors.toList());
		this.monitor.terminoLectura();
		return resultado;	
	}
	
}