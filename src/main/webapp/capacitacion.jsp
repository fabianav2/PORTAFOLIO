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
		
		<title>Crea nueva capacitacion</title>
	</head>
	<body>
		<!-- Inicio Navbar -->
		<jsp:include page="menu.jsp"/>
		<!-- Fin Navbar -->
	
		<div class="mt-5 container">
			
			<h2 class="text-center">Formulario Capacitación</h2>
			
			<div class="row mt-5">
				<div class="col-4 offset-4">
				
				<form class="fondo-form" action="ServletCrudCapacitaciones" method="post" id="form-create-capacitacion">
				
					<div class="mb-3">
						<label for="identificador" class="form-label">Identificador</label>
						<input type="number"
						 class="form-control"
						 id="identificador"
						 name="identificador"
						 value="${capacitacion.identificador}"
						 required
						 readonly
						 />
					</div>
					
					<div class="mb-3">
						<label for="rut" class="form-label">Rut Cliente</label>
						<input 
						type="text" 
						class="form-control" 
						id="rut" 
						name="rut"
						value="${capacitacion.rut}"
						required
						/>
					</div>
					
					<div class="mb-3">
						<label for="dia" class="form-label">Dia</label>
						<input
						type="text"
						class="form-control"
						id="dia"
						name="dia"
						value="${capacitacion.dia}"
						/>
					</div>
					
					<div class="mb-3">
						<label for="hora" class="form-label">Hora</label>
						<input 
						type="text" 
						class="form-control" 
						id="hora" 
						name="hora"
						value="${capacitacion.hora}"
						/>
					</div>
					
					<div class="mb-3">
						<label for="lugar" class="form-label">Lugar</label>
						<input
						type="text"
						class="form-control"
						id="lugar"
						name="lugar"
						value="${capacitacion.lugar}"
						/>
					</div>
					
					<div class="mb-3">
						<label for="duracion" class="form-label">Duración</label>
						<input 
						type="text" 
						class="form-control" 
						id="duracion" 
						name="duracion"
						value="${capacitacion.duracion}"
						/>
					</div>
					
					<div class="mb-3">
						<label for="cantidadAsistentes" class="form-label">Cantidad de asistentes</label>
						<input 
						type="number" 
						class="form-control" 
						id="cantidadAsistentes" 
						name="cantidadAsistentes"
						value="${capacitacion.cantidadAsistentes}"
						/>
					</div>
					
					<input type="hidden" name="option" value="updateCapacitacion">
					
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