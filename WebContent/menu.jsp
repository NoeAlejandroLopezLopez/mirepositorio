<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<link rel="stylesheet"  href="css/menu.css" />  

<ul class="menu">

	<li> 
		<a href= "<%=request.getContextPath()%>">
			Home
		</a>
	</li>
	
	<li>
		<a href="<%=request.getContextPath() %>/alta.jsp">
			Agragar Alumno
		</a>
	 </li>
	 
	 <li> 
		<a href= "<%=request.getContextPath()%>/alumnos">
			Ver Alumnos
		</a>
	</li>
	 
	 
</ul>