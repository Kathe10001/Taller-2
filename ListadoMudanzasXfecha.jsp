<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id='mensajes' scope='application' class='java.util.ArrayList' /> 

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
	</table><br>

    <form action='ListadoMudanzasXfecha' method='POST'>
      <p> Fecha: <input type='date' name='fecha'> </p>
      <p> <input type='submit' value='Buscar'> </p>
    </form>
    
   	 <table border="5" width="50%" bordercolor="#9999FF" height="50" bgcolor="#E4EEF8">
		<tr>
			<td><b> Número de Contratación </b></td>
			<td><b> Hora Inicio </b></td>
			<td><b> Fecha Mudanza </b></td>
			<td><b> Domicilio Origen </b></td>
			<td><b> Domicilio Destino </b></td>
			<td><b> Duración Total </b></td>
			<td><b> Código Servicio </b></td>
			<td><b> Estado </b></td>
		</tr>
	
		<c:forEach items="${mudanzas}" var="i" >
			<tr>
				<td> ${i.numContratacion} </td>
				<td><fmt:formatDate pattern = "HH:mm" value = "${i.horaInicio}" /></td>
				<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${i.fechaMudanza}" /></td>
				<td> ${i.domicilioOrigen} </td>
				<td> ${i.domicilioDestino} </td>
				<td> ${i.duracionTotal} </td>
				<td> ${i.codigoServicio} </td>
				<td> ${i.finalizacion ? "Finalizada" : "No finalizada"} </td>
			</tr>
		</c:forEach>					
	</table>
    
  </body>
</html>