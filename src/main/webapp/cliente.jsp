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
		
		<title>Cliente</title>
	</head>
	<body>
		<!-- Inicio Navbar -->
		<jsp:include page="menu.jsp"/>
		<!-- Fin Navbar -->
	
		<div class="mt-5 container">
			
			<h2 class="text-center">Formulario Cliente</h2>
			
			<div class="row mt-5">
				<div class="col-4 offset-4">
				
				<form class="fondo-form" action="ServletCrudCliente" method="post" id="form-create-cliente">

					<div class="mb-3">
						<label for="rut" class="form-label">Rut</label>
						<input 
						type="number" 
						class="form-control" 
						id="rut" 
						name="rut"
						value="${cliente.rutCliente}"
						readonly
						/>
					</div>
					
					<div class="mb-3">
						<label for="nombres" class="form-label">Nombres</label>
						<input 
						type="text" 
						class="form-control" 
						id="nombres" 
						name="nombres"
						value="${cliente.nombres}"
						/>
					</div>
					
					<div class="mb-3">
						<label for="apellidos" class="form-label">Apellidos</label>
						<input
						type="text"
						class="form-control"
						id="apellidos"
						name="apellidos"
						value="${cliente.apellidos}"
						/>
					</div>					

					<div class="mb-3">
						<label for="telefonos" class="form-label">Telefonos</label>
						<input
						type="text"
						class="form-control"
						id="telefonos"
						name="telefonos"
						value="${cliente.telefonos}"
						/>
					</div>					

					<div class="mb-3">
						<label for="afp" class="form-label">AFP</label>
						<input
						type="text"
						class="form-control"
						id="afp"
						name="afp"
						value="${cliente.afp}"
						/>
					</div>					

					<div class="mb-3">
						<label for="sistemasalud" class="form-label">Sistema de salud</label>
						<input
						type="text"
						class="form-control"
						id="sistemasalud"
						name="sistemasalud"
						value="${cliente.sistemaSalud}"
						/>
					</div>					

					<div class="mb-3">
						<label for="direccion" class="form-label">Direccion</label>
						<input
						type="text"
						class="form-control"
						id="direccion"
						name="direccion"
						value="${cliente.direccion}"
						/>
					</div>					

					<div class="mb-3">
						<label for="comuna" class="form-label">Comuna</label>
						<input
						type="text"
						class="form-control"
						id="comuna"
						name="comuna"
						value="${cliente.comuna}"
						/>
					</div>					

					<div class="mb-3">
						<label for="edad" class="form-label">Edad</label>
						<input
						type="number"
						class="form-control"
						id="edad"
						name="edad"
						value="${cliente.edad}"
						/>
					</div>
					<input type="hidden" name="option"
					<% String accion = String.valueOf(request.getAttribute("accion"));
                    	if(accion.equals("save")) { %>
						 value="saveCliente"
					<%}%>
					<% if(accion.equals("update")){ %>
						value="updateCliente"
					<%}%>
					>
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-primary">Actualizar</button>
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