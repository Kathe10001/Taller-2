<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title> Listado de Mudanzas por Fecha </title>
  </head>

  <body bgcolor="#CAE4FF">
  
	<p><a href='Menu.jsp'>Volver al Menú</a></p>
	
	<table border="5" width="50%" bordercolor="#9999FF" height="50" bgcolor="#E4EEF8">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Listado de Mudanzas por Fecha </font></b>
			</td>
		</tr>
	</table>

    <form action='ListadoMudanzasXfecha' method='POST'>
      <p> Fecha: <input type='date' name='fecha'> </p>
      <p> <input type='submit' value='Buscar'> </p>
    </form>
  </body>
</html>