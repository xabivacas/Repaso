<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Caballero</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div class="row offset-4 col-4">
			<c:if test="${ msg=='insertError'}">
				<div class="alert alert-danger d-flex align-items-center" role="alert">
						Error al insertar los datos
				</div>
			</c:if>
			<form action="StoreCaballero" method="post">
				<div class="mb-3">
				  <label for="nombre" class="form-label">Nombre</label>
				  <input type="text" class="form-control" id="nombre" name="nombre" aria-describedby="emailHelp">
				</div>
				
				<div class="mb-3">
				  <label for="fuerza" class="form-label">Fuerza</label>
				  <input type="number" class="form-control" id="fuerza" name="fuerza">
				</div>
				
				<label for="arma" class="form-label">Arma</label>
				<select class="form-select mb-3" aria-label="Default select example" name="arma">
					<option value=""></option>
					<c:forEach items="${armas}" var="arma">
						<option value="${arma.id}">${arma.nombre}</option>
					</c:forEach>
				</select>
				
				<label for="escudo" class="form-label">Escudo</label>
				<select class="form-select mb-3" aria-label="Default select example" name="escudo">
					<option value=""></option>
					<c:forEach items="${escudos }" var="escudo">
						<option value="${escudo.id }">${escudo.nombre }</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-primary">Enviar</button>
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>