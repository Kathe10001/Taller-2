package controladores;

import grafica.VentanaNuevoServicio;
import logica.IFachada;

public class ControladorNuevoServicio
	{
	private IFachada fac;
	private VentanaNuevoServicio ven;
	/* tengo como atributo remoto a la fachada y como atributo local a mi ventana */
	
	
	public ControladorNuevoServicio (VentanaNuevoServicio ven)
	{
	/* aqu� me guardo la referencia a mi ventana y adem�s hago el lookup
	para acceder remotamente a la fachada */
	}
	...
	public void altaPersona (String nombre, String apellido)
	{
	try
	{ /* desde aqu� accedo a la Fachada y hago los chequeos
	necesarios, luego decido si emito al usuario un mensaje de
	�xito o uno de error */
	}
	catch (Excepciones varias)
	{
	/* aqu� atrapo las posibles excepciones que me puede lanzar
	la capa l�gica y decido qu� mensaje de error mostrar */
	}
	}
	}


