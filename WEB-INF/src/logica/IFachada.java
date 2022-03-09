package logica;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.ServicioException;
import valueObjects.VOCliente;
import valueObjects.VOMudanzaDetallado;
import valueObjects.VOServicio;

public interface IFachada extends Remote{

	/* 1 - Alta de nuevo servicio de mudanza: Se registrar�n en el
	 sistema todos los datos de un nuevo servicio de mudanza que la empresa comienza a ofrecer
	 */
	void nuevoServicio(boolean armadoMuebles, boolean embalaje, float costoXhora, float distanciaKm,
			String codigoServicio) throws RemoteException, ServicioException;

	/* 2 - Alta de nuevo cliente: Se registran en el sistema todos los datos de un nuevo cliente
	*/
	void altaNuevoCliente(String cedula, String nombre, String apellido, String telefono) throws ClienteException, RemoteException;

	/* 3 - Listado de clientes: Obtener un listado conteniendo c�dula, nombre, apellido y
	 tel�fono de contacto de todos los clientes registrados en el sistema.
	 Este listado debe realizarse ordenado en forma ascendente por n�mero de c�dula
	 */
	ArrayList<VOCliente> listadoClientes() throws RemoteException, ClienteException;

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
	void altaMudanza(Date horaInicio, Date fechaMudanza, String domicilioOrigen, String domicilioDestino, String cedula,
			String codigoServicio) throws ClienteException, ServicioException, MudanzaException, RemoteException;

	/*5 - Finalizaci�n de nuevo servicio de mudanza: Dado el n�mero que identifica a una
	  contrataci�n de servicio de mudanza, marcarla como finalizada.
	  En ese momento, se ingresar� la duraci�n total que tuvo (en horas y minutos)
	  y se calcular� autom�ticamente el costo final de la misma
	 */
	float finalizacionMudanza(int codigoMudanza, float duracion) throws RemoteException, MudanzaException, ServicioException;

	/*6 - Listado detallado de contrataci�n: Dado el n�mero que identifica a una contrataci�n de servicio
	 	    de mudanza, listar en detalle todos sus datos, incluyendo adem�s el c�digo alfanum�rico
	 	     del servicio contratado y todos los datos del cliente correspondiente
	   */
	VOMudanzaDetallado detalleMudanza(int codigoMudanza) throws RemoteException, MudanzaException;

	/*7 - Monto recaudado por rango de fechas:
	 	Dadas dos fechas, calcular el monto total recaudado por concepto de contrataciones de
	 	servicios de mudanza ya finalizadas entre esas dos fechas (incluyendo ambas)
	   */
	float montoRecaudado(Date fechaInicio, Date fechaFin) throws RemoteException, MudanzaException;

	/*
	 	8 - Guardar cambios: Respaldar en disco todos los datos de la aplicaci�n.
	 	Este requerimiento podr� ejecutarse cada vez que un empleado lo desee, especialmente
	 	tras haber ejecutado funcionalidades que produzcan cambios en la informaci�n manejada
	 	por el sistema. Todos los datos se respaldar�n juntos en un �nico archivo binario en disco
	 	(ubicado en el servidor central), para luego poder ser restaurados a memoria en una pr�xima
	 	 ejecuci�n
	   */
	void guardarCambios() throws PersistenciaException, RemoteException;

	/* 9 - Restaurar informaci�n: Restaurar a memoria todos los datos de la aplicaci�n almacenados
	 en disco. Este requerimiento ser� ejecutado autom�ticamente en el servidor central cada vez
	 que el sistema inicie su ejecuci�n (no ser� disparado por ning�n usuario que expl�citamente
	  solicite su ejecuci�n)
	*/
	void restaurarInformacion() throws PersistenciaException, RemoteException;

	/*10 - Listado de servicios de mudanza ofrecidos: Obtener un listado conteniendo c�digo,
	 distancia, costo por hora, disponibilidad de servicio de embalaje y
	 disponibilidad de servicio de armado de muebles de todos los servicios de mudanza ofrecidos
	 por la empresa. Este listado se realizar� ordenado alfanum�ricamente por c�digo de servicio
	 de mudanza
	 */
	ArrayList<VOServicio> listadoServicios() throws RemoteException, ServicioException;

	/*11 - Listado de contrataciones realizadas por fecha: Dada una fecha, listar n�mero,
	 hora de inicio y estado (finalizada o no finalizada) de todas las contrataciones de servicios
	 de mudanza registradas para dicha fecha. Este listado se realizar� ordenado por n�mero de
	 contrataci�n, de menor a mayor
	 */
	ArrayList<VOMudanzaDetallado> listadoMudanzasXfecha(Date fecha) throws RemoteException, MudanzaException;

}