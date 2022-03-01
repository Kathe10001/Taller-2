<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title> Cartelera web de mensajes </title>
  </head>

  <body bgcolor="#CAE4FF">

	<table border="5" width="50%" bordercolor="#9999FF" height="50" bgcolor="#E4EEF8">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Cartelera web de mensajes </font></b>
			</td>
		</tr>
	</table>

    <form action='Ingreso' method='POST'>
      <p> Nombre: <input type='text' name='nombre' size=30> </p>
	  <p> Procedencia: 	<select name='procedencia'>
							<option value='Montevideo'> Montevideo
							<option value='Interior'> Interior
							<option value='Extranjero'> Extranjero
						</select> </p>
      <p> <input type='submit' value='INGRESAR'> </p>
    </form>
  </body>
</html>