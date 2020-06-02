<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="menu.jsp"></jsp:include>
	<form action="alumnos" method="post">
		<label> Matricula
			<input type="text" name="matricula"/>
		</label>
		
		<br/>
		<label> Nombre
			<input type="text" name="nombre"/>
		</label>
		
		<br/>
		<label> Apellido Paterno
			<input type="text" name="apellidoPaterno"/>
		</label>
		
		<br/>
		<label> Apellido Materno
			<input type="text" name="apellidoMaterno"/>
		</label>
		
		<br/>
		<label> Grado
			<input type="text" name="grado"/>
		</label>
		
		<br/>
		<label> Grupo
			<input type="text" name="grupo"/>
		</label>
		
		<br/>
		<label> Carrera
			<input type="text" name="carrera"/>
		</label>
		
		<br/>
		<input type="submit" value="enviar">
	</form>
	
	
	
	
	
</body>
</html>