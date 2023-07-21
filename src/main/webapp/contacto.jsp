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
		
		<title>contacto</title>
	</head>
	<body>
	
	<!-- Inicio Navbar -->
	<jsp:include page="menu.jsp"/>
	<!-- Fin Navbar -->
	
	<div class="mt-5 container">
		<div class="row">
			<div class="col-6 offset-3">
				
				<h2 class="text-center mb-5 text-bg-info">Contacto</h2>
				
				<form action="ServletContacto" method="post">
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label>
						<input type="text" class="form-control" id="nombre" name="nombre" required>
					</div>
					<div class="mb-3">
						<label for="telefono" class="form-label">Telefono</label>
						<input type="text" class="form-control" id="telefono" name="telefono" required>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label>
						<input type="text" class="form-control" id="email" name="email">
					</div>
					<div class="form-floating mb-3">
					  <textarea class="form-control" placeholder="Escribe tu comentario aqui..." id="comentario" name="comentario"></textarea>
					  <label for="comentario">Comentarios</label>
					</div>
					
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-primary">Enviar</button>
					</div>
				</form>				
			</div>
			<a class="text-center mt-5" href="Inicio">Volver</a>
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