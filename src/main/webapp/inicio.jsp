<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		
		<title>inicio</title>
	</head>
	
	<body>
		<!-- Inicio Navbar -->
		<jsp:include page="menu.jsp"/>
		<!-- Fin Navbar -->
	
		<div class="mt-5 container">
			<h1 class="text-center mt-5 mb-5">Bienvenido ${sessionScope.usuario}</h1>
		
			<div class="row">
				<div class="col-6 offset-3">
					<div class="row">
						<h6 class="mb-1">Integrantes:</h6>
						<ul class="list-group">
							<li class="list-group-item list-group-item-primary">Nicolae Villegas</li>
							<li class="list-group-item list-group-item-primary">Fabiana Vega</li>
							<li class="list-group-item list-group-item-primary">Jesús Torres</li>
							<li class="list-group-item list-group-item-primary">Cristian Díaz</li>
						</ul>
						<p>
							<a class="link-opacity-100" href="https://github.com/cada-github/EjercicioGrupalM5.git">
							GitHub: Ejercicio Grupal M5
							</a>
						</p>
					</div>
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