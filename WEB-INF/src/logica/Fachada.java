package logica;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	private Monitor monitor;
	private Clientes clientes;
	private Mudanzas mudanzas;
	private Servicios servicios;
	private Persistencia persistencia;
	
	public Fachada() throws RemoteException {
		super();
		this.monitor = new Monitor();
		this.clientes = new Clientes();
		this.mudanzas = new Mudanzas();
		this.servicios = new Servicios();
		this.persistencia = new Persistencia(); 
	}

	private static final long serialVersionUID = 1L;

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
			this.monitor.terminoEscritura();
			throw new ServicioException("Ya existe un servicio con el codigo: " + codigoServicio);
		}
		this.monitor.terminoEscritura();
	}

	/*
	 * 2 - Alta de nuevo cliente: Se registran en el sistema todos los datos de un nuevo cliente
	*/
	@Override
	public void altaNuevoCliente(String cedula, String nombre, String apellido, String telefono) throws ClienteException, RemoteException {

		this.monitor.comienzoEscritura();
		Cliente nuevoCliente = new Cliente(cedula,nombre,apellido,telefono);
		if(this.clientes.esVacia()){
			this.clientes.insert(nuevoCliente);
		} else {
			Cliente cliente = this.clientes.find(cedula);
			if(cliente == null) {
				this.clientes.insert(nuevoCliente);
			} else {
				this.monitor.terminoEscritura();
				throw new ClienteException("Ya existe un cliente con la cedula: " + cedula);
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
		if(clientes == null || this.clientes.esVacia()) {
			this.monitor.terminoLectura();
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
	public void altaMudanza(Date horaInicio, Date fechaMudanza, String domicilioOrigen,
			String domicilioDestino, String cedula, String codigoServicio) throws ClienteException, ServicioException, MudanzaException, RemoteException {

		this.monitor.comienzoEscritura();
	
		Date hoy = new Date();
		if(this.anterior(fechaMudanza, hoy)) {
			this.monitor.terminoEscritura();
			throw new MudanzaException("La fecha de la mudanza no puede ser anterior a la fecha de hoy");
		}
	
				
		if(!this.clientes.member(cedula)) {
			this.monitor.terminoEscritura();
			throw new ClienteException("El cliente no existe");
		}


		if(!this.servicios.member(codigoServicio)) {
			this.monitor.terminoEscritura();
			throw new ServicioException("El servicio no existe");
		}

		Cliente cliente = this.clientes.find(cedula);
		Servicio servicio = this.servicios.find(codigoServicio);

		Mudanza ultimaMudanza = this.mudanzas.getUltimo();
		if(ultimaMudanza == null) {
			Mudanza mudanza = new Mudanza(1, horaInicio, fechaMudanza, domicilioOrigen, domicilioDestino, cliente, servicio);
			this.mudanzas.insert(mudanza);
		} else {
			if(this.posterior(fechaMudanza, ultimaMudanza.getFechaMudanza())) {
				
				Mudanza mudanza = new Mudanza(ultimaMudanza.getNumContratacion() + 1, horaInicio, fechaMudanza, domicilioOrigen, domicilioDestino, cliente, servicio);
				
				ArrayList<VOMudanzaDetallado> mudanzas = this.listadoMudanzas(fechaMudanza);
			
				if(mudanzas.isEmpty()) {
					this.mudanzas.insert(mudanza);
					
				} else {
					List<VOMudanzaDetallado> resultado = mudanzas.stream()
							.filter(m -> {
								
								long diferencia = horaInicio.getTime() - m.getHoraInicio().getTime();
								
								long diferenciaHoras = diferencia / (60 * 60 * 1000) % 24;
								
								return diferenciaHoras < 2;
										})
							.collect(Collectors.toList());
					
					if(resultado.isEmpty()) {				
						this.mudanzas.insert(mudanza);
					} else {
						this.monitor.terminoEscritura();
						throw new MudanzaException("TIene que haber al menos 2 hs de diferencia con respecto las demas mudanzas para la fecha ingresada");
					}
				}

			} else {
				this.monitor.terminoEscritura();
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
			this.monitor.terminoEscritura();
			throw new MudanzaException("No existe una mudanza para el codigo" + codigoMudanza);
		} else {
			if(mudanza.isFinalizacion()) {
				this.monitor.terminoEscritura();
				throw new MudanzaException("La mudanza ya se encuentra finalizada");
			}
			mudanza.setDuracionTotal(duracion);
			mudanza.setFinalizacion(true);
			Servicio servicio = mudanza.getServicio();
			if(servicio == null) {
				this.monitor.terminoEscritura();
				throw new ServicioException("No existe una servicio para la mudanza" + mudanza.getNumContratacion());
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
	public VOMudanzaDetallado detalleMudanza(int codigoMudanza) throws RemoteException, MudanzaException {
		this.monitor.comienzoLectura();
		
		Mudanza mudanza = null; 
		try {
			
			mudanza = this.mudanzas.get(codigoMudanza);
			if(mudanza == null) {
				this.monitor.terminoLectura();
				throw new MudanzaException("No hay una mudanza con el código" + codigoMudanza);
			}
			
		} catch (IndexOutOfBoundsException e) {
			this.monitor.terminoLectura();
			throw new MudanzaException("No hay una mudanza con el codigo" + codigoMudanza);
		}
		
		  
		this.monitor.terminoLectura();
		return mudanza.toVO();
	}

	/*7 - Monto recaudado por rango de fechas:
	  Dadas dos fechas, calcular el monto total recaudado por concepto de contrataciones de
	  servicios de mudanza ya finalizadas entre esas dos fechas (incluyendo ambas)
	 ∫*/
	@Override
	public float montoRecaudado(Date fechaInicio, Date fechaFin) throws RemoteException, MudanzaException {
		this.monitor.comienzoLectura();
		float total = 0f;
		
		if (!this.anteriorIgual(fechaInicio, fechaFin)) {
			this.monitor.terminoLectura();
			throw new MudanzaException("La fecha de inicio debe ser anterior a la de fin");
		} else {
		
			total = (float) this.mudanzas.getMudanzas().stream()
			.filter(mudanza -> this.posteriorIgual(mudanza.getFechaMudanza(), fechaInicio) && this.anteriorIgual(mudanza.getFechaMudanza(), fechaFin) && mudanza.isFinalizacion())
			.mapToDouble(mudanza -> {	
				Servicio servicio = this.servicios.find(mudanza.getServicio().getCodigo());
				return mudanza.getDuracionTotal() * servicio.getCostoXhora();
			}).sum();		
			
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
			this.monitor.terminoEscritura();
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
			this.monitor.terminoLectura();
			throw new PersistenciaException("No se pudo restaurar");
		}
		this.monitor.terminoLectura();
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
		

		if(this.servicios == null || this.servicios.esVacio()) {
			this.monitor.terminoLectura();
			throw new ServicioException("No hay servicios");
		} 
		
		ArrayList<VOServicio> servicios = new ArrayList<>();
		this.servicios.getServicios().values().forEach(servicio -> servicios.add(servicio.toVO()));

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
		resultado = this.listadoMudanzas(fecha);
		this.monitor.terminoLectura();
		return resultado;
	}
	
	private ArrayList<VOMudanzaDetallado> listadoMudanzas(Date fecha) throws RemoteException, MudanzaException {
		if(this.mudanzas.esVacia()) {
			throw new MudanzaException("No hay datos");
		}
		
		return  (ArrayList<VOMudanzaDetallado>) this.mudanzas.listarMudanzas().stream()
		.filter(mudanza -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");			
			return sdf.format(mudanza.getFechaMudanza()).equals(sdf.format(fecha));
		})
		.collect(Collectors.toList());
	}
	
	private boolean anteriorIgual(Date fechaAComparar, Date fecha) {
		return (this.anterior(fechaAComparar, fecha) || this.igual(fechaAComparar, fecha));
		
	}
	
	private boolean posteriorIgual(Date fechaAComparar, Date fecha) {
		return (this.posterior(fechaAComparar, fecha) || this.igual(fechaAComparar, fecha));
	}
	
	private boolean anterior(Date fechaAComparar, Date fecha) {
		return (fechaAComparar.compareTo(fecha) == -1);
		
	}
	
	private boolean posterior(Date fechaAComparar, Date fecha) {
		return (fechaAComparar.compareTo(fecha) == 1);
	}
	
	private boolean igual(Date fechaAComparar, Date fecha) {
		return  (fechaAComparar.compareTo(fecha) == 0);
	}
	
	

}