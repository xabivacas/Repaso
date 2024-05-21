<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="StoreCaballero" method="post">
			<div class="mb-3">
			  <label for="nombre" class="form-label">Nombre</label>
			  <input type="text" class="form-control" id="nombre" name="nombre" aria-describedby="emailHelp">
			</div>
			
			<div class="mb-3">
			  <label for="fuerza" class="form-label">Fuerza</label>
			  <input type="number" class="form-control" id="fuerza" name="fuerza">
			</div>
			
			<select class="form-select" aria-label="Default select example" name="arma">
				<c:forEach items="${armas}" var="arma">
					<option value="${arma.id}">${arma.nombre}</option>
				</c:forEach>
			</select>
			
			<select class="form-select" aria-label="Default select example" name="escudo">
				<c:forEach items="${escudos }" var="escudo">
					<option value="${escudo.id }">${escudo.nombre }</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</div>
</body>
</html>