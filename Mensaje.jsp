<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id='datosPer' scope='session' class='valueObjects.DataPersona' />  

<html>
  <head>
    <title> Escritura de mensaje </title>
  </head>

  <body bgcolor="#DCFBD2">
	<table border="5" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Bienvenido ${datosPer.nombre} de ${datosPer.procedencia} </font></b>
			</td>
		</tr>
	</table>

    <form action='Mensaje' method='POST'>
      <p> Escribe tu mensaje: <input type='text' name='mensaje' size=80> </p>
      <p> <input type='submit' value='ENVIAR'> </p>
    </form>
  </body>
</html>