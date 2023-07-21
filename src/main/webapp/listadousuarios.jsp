<%@page import="modelo.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!--Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!--Bootstrap -->	

	    <!-- Font Awesome -->
		  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
		<!-- /Font Awesome -->		
		
		<!-- Estilos propios -->
		<link href="css/estilos.css" rel="stylesheet" type="text/css">
		<!-- Estilos propios -->
			
		<title>Listado de Usuarios</title>
	</head>
	<body>
		<!-- Inicio Navbar -->
		<jsp:include page="menu.jsp"/>
		<!-- Fin Navbar -->
		
		<div class="mt-5 container">
			<h2 class="text-center mb-4">Listado de Usuarios</h2>
			<div class="row">
				<div class="col-10 offset-1">
					<table class="table">
						<thead class="table-primary">
							<tr>
								<th scope="col">Nombre</th>
								<th scope="col">Fecha de Nacimiento</th>
								<th scope="col">Run</th>
								<th scope="col">Tipo Usuario</th>
								<th scope="col">Opciones</th>
							</tr>
						</thead>
	                    <tbody class="table-group-divider">
    	                <!-- el ciclo for de java -->
        	            <% List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios");
                    	if(usuarios != null) {
                    		for(Usuario u: usuarios ) {
                    	%>
                      	<tr>
                        	<td><%= u.getNombreUsuario()%></td>
                        	<td><%= u.getFechaNacimientoUsuario()%></td>
                        	<td><%= u.getRunUsuario() %></td>
                        	<td><%= u.getTipo() %></td>
                        	<td>
                        		<!-- Editar -->
                        		<a 
                        			class="text-success" 
                        			href="ServletCrudUsuarios?option=formUpdateUsuario&run=<%=u.getRunUsuario() %>">
                        			<i class="fa-solid fa-pen-to-square mx-3"></i>
                        		</a>	 
                         		<!-- Eliminar -->
 						 		<a class="text-danger" 
 						 			href="ServletCrudUsuarios?option=deleteUsuario&run=<%=u.getRunUsuario()%>">
 						 			<i class="fa-solid fa-trash"></i>
 						 		</a>
                        	</td>
                      	</tr>
                      	<!-- fin del for de java -->
                    	<%	} 
                    	}
                     	%>
                    	</tbody>
						
					</table>
				</div>
			</div>
		</div>
		<!-- JS BootStrap -->
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
		<!-- JS BootStrap -->
		
		<!-- JQuery -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<!-- JQuery -->
	</body>
</html>