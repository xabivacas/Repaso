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
	<div class="container mt-5">
		<c:if test="${msg=='datos' }">
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">${luchador1.nombre }</h5>
					<p class="card-text">Fuerza: ${luchador1.fuerza } Arma: ${luchador1.arma.nombre } Escudo: ${luchador1.escudo.nombre }</p>
				</div>
			</div>
			
			<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">${luchador2.nombre }</h5>
					<p class="card-text">Fuerza: ${luchador2.fuerza } Arma: ${luchador2.arma.nombre } Escudo: ${luchador2.escudo.nombre }</p>
				</div>
			</div>
			<form action="Luchar" method="post">
				<input value="${idGanador}" type="hidden" name="idGanador"></input>
				<button type="summit" class="btn btn-primary">Luchar luchar luchar</button>
			</form>
		</c:if>
		<c:if test="${msg=='ganador' }">
			<div class="offset-4 col-5">
				<h1>
					Felicidades ${ganador.nombre }
				</h1>
			</div>
		</c:if>
	</div>
	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>