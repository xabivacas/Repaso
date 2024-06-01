<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IndexCaballeros</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">

	<div class="container">
		<table class="table">
			<thead class="table-primary">
				<tr>
					<th scope="col">Id
						<a href="IndexCaballeros?orderBy=idAsc">
						Asc
						</a>
						<a href="IndexCaballeros?orderBy=idDesc">
						Desc
						</a>
					</th>
					<th scope="col">Luchador1
						<a href="IndexCaballeros?orderBy=nAsc">
						Asc
						</a>
						<a href="IndexCaballeros?orderBy=nDesc">
						Desc
						</a>
					</th>
					<th scope="col">Luchador2
						<a href="IndexCaballeros?orderBy=fuerzaAsc">
							Asc
						</a>
						<a href="IndexCaballeros?orderBy=fuerzaDesc">
							Desc
						</a>
					</th>
					<th scope="col">Ganador</th>
					<th scope="col">Fecha</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${luchas}" var="lucha">
				 	
				 	
					<tr>
						<th scope="col">${lucha.id }</th>
						<th scope="col">${lucha.luchador1.nombre }</th>
						<th scope="col">${lucha.luchador2.nombre  }</th>
						<th scope="col">${lucha.ganador.nombre }</th>
						<th scope="col"> ${lucha.fecha}</th>
						<th><fmt:formatDate value="${lucha.fecha}" pattern="yyyy/MM/dd"/></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<a class="row mb-2 btn btn-primary color-white" href="IndexLucha" role="button">Luchar</a>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>