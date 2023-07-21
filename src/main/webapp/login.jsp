<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!-- Bootstrap -->
		<title>Login</title>
		
		<!-- Estilos propios -->
		<link href="css/estilos.css" rel="stylesheet" type="text/css">
		<!-- Estilos propios -->
		
	</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">Inicie Sesión</h1>
		<div class="row mt-5">
			<div class="col-4 offset-4">
			
			<!-- Inicio Formulario -->
			<form id="form-login">
			
				<!-- Nombre del usuario -->
				<div class="mb-3">
					<label for="username" class="form-label">Nombre usuario</label>
					<input 
						type="text" 
						class="form-control" 
						id="username" 
						name="username" 
						required />
				</div>
				
				<!-- Clave del usuario -->
				<div class="mb-3">
					<label for="password" class="form-label">Ingrese contraseña</label>
					<input 
						type="text" 
						class="form-control" 
						id="password" 
						name="password" 
						required />
				</div>
				
				<!-- boton de envio -->
				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-success">Enviar</button>
				</div>
				
			</form>
			<!-- Fin Formulario -->
			</div>
		</div>
	</div>
	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- JQuery -->
	
	<!-- JS propio -->
	<script src="js/app.js"></script>
	<!-- JS propio -->
</body>
</html>