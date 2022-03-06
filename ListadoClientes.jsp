<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='mensajes' scope='application' class='java.util.ArrayList' />  

<html>
  <head>
    <title> Clientes </title>
  </head>

  <body bgcolor="#B7FFB7">
	<table border="5" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Resultado de los clientes </font></b>
			</td>
		</tr>
	</table> <br>
    
	 <table border="2" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
			<tr>
				<td><b> Cédula </b></td>
				<td><b> Nombre </b></td>
				<td><b> Apellido </b></td>
				<td><b> Teléfono </b></td>
			</tr>
		
			<c:forEach items="${clientes}" var="i" >
				<tr>
					<td> ${i.cedula} </td>
					<td> ${i.nombre} </td>
					<td> ${i.apellido} </td>
					<td> ${i.telefono} </td>
				</tr>
			</c:forEach>					
	</table>
	
	 <form action='ListadoClientes' method='POST'>
      <p> <input type='submit' value='Cargar datos'> </p>
    </form>
    
	<p><a href='Menu.jsp'>Volver al Menú</a></p>
		
  </body>
</html>