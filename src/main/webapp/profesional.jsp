<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!--Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!--Bootstrap -->
		
		<!-- Estilos propios -->
		<link href="css/estilos.css" rel="stylesheet" type="text/css">
		<!-- Estilos propios -->
		
		<title>Profesional</title>
	</head>
	<body>
		<!-- Inicio Navbar -->
		<jsp:include page="menu.jsp"/>
		<!-- Fin Navbar -->
	
		<div class="mt-5 container">
			
			<h2 class="text-center">Formulario Profesional</h2>
			
			<div class="row mt-5">
				<div class="col-4 offset-4">
				
					<form class="fondo-form" action="ServletCrudProfesional" method="post" id="form-profesional">

						<div class="mb-3">
							<label for="run" class="form-label">Run</label>
							<input 
							type="number" 
							class="form-control" 
							id="run" 
							name="run"
							value="${profesional.run}"
							readonly
							/>
						</div>
	
						<div class="mb-3">
							<label for="titulo" class="form-label">Titulo</label>
							<input 
							type="text" 
							class="form-control" 
							id="titulo" 
							name="titulo"
							value="${profesional.titulo}"
							/>
						</div>
						
						<div class="mb-3">
							<label for="fechaingreso" class="form-label">Fecha de Ingreso</label>
							<input
							type="text"
							class="form-control"
							id="fechaingreso"
							name="fechaingreso"
							value="${profesional.fechaIngreso}"
							/>
						</div>					
						
						<input type="hidden" name="option"
						<% String accion = String.valueOf(request.getAttribute("accion"));
	                    	if(accion.equals("save")) { %>
							 value="saveProfesional"
						<%}%>
						<% if(accion.equals("update")){ %>
							value="updateProfesional"
						<%}%>
						>											
						<div class="d-grid gap-2">
							<button type="submit" class="btn btn-primary">Enviar</button>
						</div>
					</form>
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