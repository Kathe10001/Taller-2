<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='mensajes' scope='application' class='java.util.ArrayList' />  

<html>
  <head>
    <title> Servicios </title>
  </head>

  <body bgcolor="#B7FFB7">
	<table border="5" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Resultado de servicios </font></b>
			</td>
		</tr>
	</table> <br>
    
	 <table border="2" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
			<tr>
				<td><b> Código de Servicio </b></td>
				<td><b> Distancia </b></td>
				<td><b> Costo por Hora </b></td>
				<td><b> Tiene Embalaje </b></td>
				<td><b> Tiene Armado </b></td>
			</tr>
		
			<c:forEach items="${servicios}" var="i" >
				<tr>
					<td> ${i.codigo} </td>
					<td> ${i.distanciaKm} </td>
					<td> ${i.costoXhora} </td>
					<td> ${i.embalaje ? "Si" : "No"} </td>
					<td> ${i.armadoMuebles ? "Si" : "No"} </td>
				</tr>
			</c:forEach>					
	</table>
	
	 <form action='ListadoServicios' method='POST'>
      <p> <input type='submit' value='Cargar datos'> </p>
    </form>
    
	<p><a href='Menu.jsp'>Volver al Menú</a></p>
		
  </body>
</html>