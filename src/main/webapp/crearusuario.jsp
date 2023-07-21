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

		<title>crear nuevo usuario</title>
	</head>
		<body>
		<!-- Inicio Navbar -->
		<jsp:include page="menu.jsp"/>
		<!-- Fin Navbar -->

		<div class="mt-5 container">
			<h2 class="text-center mb-5 text-bg-info">Nuevo Usuario</h2>

			<div class="row mt-5">
				<div class="col-4 offset-4">
					<form class="fondo-form" action="ServletCrudUsuarios" method="post" id="form-usuario">

					<div class="mb-3">
						<label for="run" class="form-label">Run</label>
						<input 
						type="number" 
						class="form-control" 
						id="run" 
						name="run"
						required
						/>
						<small id="runHelp" class="form-text text-muted">Digite el RUN</small>
					</div>
					
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label>
						<input
						type="text"
						class="form-control"
						id="nombre"
						name="nombre"
						required
						/>
						<small id="nombreHelp" class="form-text text-muted">Digite el nombre</small>
					</div>
					
					<div class="mb-3">
						<label for="fechanacimiento" class="form-label">Fecha de Nacimiento</label>
						<input 
						type="text" 
						class="form-control" 
						id="fechanacimiento" 
						name="fechanacimiento" 
						required>
						<small id="fechanacimientorutHelp" class="form-text text-muted">Digite la fecha de nacimiento</small>
					</div>
					
					<div class="mb-3">
						<label for="tipo" class="form-label">Tipo de Usuario</label>
						<select class="form-select" id="tipo" name="tipo">
							<option value="cliente">Cliente</option>
							<option value="administrativo">Administrativo</option>
							<option value="profesional">Profesional</option>
						</select>
						<small id="tipoHelp" class="form-text text-muted">Seleccione el tipo de usuario</small>
					</div>
					
					<input type="hidden" name="option" value="saveUsuario">
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-primary">Registrar</button>
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