package Controladores;

import grafica.VentanaNuevoServicio;
import logica.IFachada;

public class ControladorNuevoServicio
	{
	private IFachada fac;
	private VentanaNuevoServicio ven;
	/* tengo como atributo remoto a la fachada y como atributo local a mi ventana */
	
	
	public ControladorNuevoServicio (VentanaNuevoServicio ven)
	{
	/* aquí me guardo la referencia a mi ventana y además hago el lookup
	para acceder remotamente a la fachada */
	}
	...
	public void altaPersona (String nombre, String apellido)
	{
	try
	{ /* desde aquí accedo a la Fachada y hago los chequeos
	necesarios, luego decido si emito al usuario un mensaje de
	éxito o uno de error */
	}
	catch (Excepciones varias)
	{
	/* aquí atrapo las posibles excepciones que me puede lanzar
	la capa lógica y decido qué mensaje de error mostrar */
	}
	}
	}


