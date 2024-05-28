<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<form action="UpdateCaballeros" method="get">
	
	  <div class="mb-3">
	  	<input type="hidden" value="${caballero.id}" name="id">
	    <label for="nombre" class="form-label">Nombre</label>
	    <input type="text" class="form-control" id="nombre" aria-describedby="nombre" name="nombre" value="${caballero.nombre }">
	  </div>
	  
	  <div class="mb-3">
	    <label for="fuerza" class="form-label">Fuerza</label>
	    <input type="number" class="form-control" id="fuerza" aria-describedby="nombre" name="fuerza" value="${caballero.fuerza }">
	  </div>
	  
	  <div class="mb-3">
	    <label for="exp" class="form-label">Experiencia</label>
	    <input type="number" class="form-control" id="exp" aria-describedby="nombre" name="exp" value="${caballero.experiencia }">
	  </div>
	  
		
		<div class="mb-3">
			
				<select class="form-select" name="arma">
				<c:forEach items="${armas }" var="arma">
					<c:if test="${arma.id == caballero.arma.id }">
						<option selected value="${arma.id }">${arma.nombre} ${arma.capacidad_danio }</option>
					</c:if>
					<c:if test="${arma.id != caballero.arma.id }">
						<option value="${arma.id }">${arma.nombre} ${arma.capacidad_danio }</option>
					</c:if>
				</c:forEach>
				</select>

		</div>
		
		<div class="mb-3">
			
				<select class="form-select" name="escudo">
				<c:forEach items="${escudos }" var="escudo">
					<c:if test="${escudo.id == caballero.escudo.id }">
						<option selected value="${escudo.id }">${escudo.nombre} ${escudo.capacidad_defensa }</option>
					</c:if>
					<c:if test="${escudo.id != caballero.escudo.id }">
						<option value="${escudo.id }">${escudo.nombre} ${escudo.capacidad_defensa }</option>
					</c:if>
				</c:forEach>
				</select>
			
		
		</div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>