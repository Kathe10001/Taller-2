<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='mensajes' scope='application' class='java.util.ArrayList' />  

<html>
  <head>
    <title> Mudanzas </title>
  </head>

  <body bgcolor="#B7FFB7">
	<table border="5" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Resultado de mudanzas </font></b>
			</td>
		</tr>
	</table> <br>

	 
	 <table border="2" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
			<tr>
				<td><b> Número de Contratación </b></td>
				<td><b> Hora Inicio </b></td>
				<td><b> Fecha Mudanza </b></td>
				<td><b> Domicilio Origen </b></td>
				<td><b> Domicilio Destino </b></td>
				<td><b> Duración Total </b></td>
				<td><b> Código Servicio </b></td>
			</tr>
		
			<c:forEach items="${mudanzas}" var="i" >
				<tr>
					<td> ${i.numContratacion} </td>
					<td> ${i.horaInicio} </td>
					<td> ${i.fechaMudanza} </td>
					<td> ${i.domicilioOrigen} </td>
					<td> ${i.domicilioDestino} </td>
					<td> ${i.duracionTotal} </td>
					<td> ${i.codigoServicio} </td>
				</tr>
			</c:forEach>					
	</table>

	<p><a href='Menu.jsp'>Volver al Menú</a></p>
		
  </body>
</html>