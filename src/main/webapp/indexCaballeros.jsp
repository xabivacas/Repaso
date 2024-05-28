<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IndexCaballeros</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row"> 
        <c:if test="${msg == 'insertOk'}">
            <div class="alert alert-success" role="alert">
                Todo bien con la inserción
            </div>
        </c:if>
        <div class="offset-8 col-1">
            <a class="row offset-11 mb-2 btn btn-primary color-white" href="CreateCaballeros" role="button">+</a>
        </div>
    </div>

    <div class="row">
        <div class="col-6">
            <form action="IndexCaballeros" method="post">
                <div class="row g-3">
                    <div class="col-12">
                        
                        <input type="text" class="form-control" id="buscador" name="buscador">
                        <button type="submit" class="btn btn-primary col-auto">Buscar</button>
                    </div>
                </div>
            </form>
        </div>
        
        <div class="col-6">
            <form action="DeleteCaballeros" method="get">
                <div class="row g-3">
                    <div class="col-12">
                        <label for="eliminador">Inserte las ID de los caballeros a eliminar</label>
                        
                        <input type="text" class="form-control" id="eliminador" name="eliminador" placeholder="1,2,3,4">
                        <button type="submit" class="btn btn-primary col-auto">Eliminar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


	</form>
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
					<th scope="col">Nombre
						<a href="IndexCaballeros?orderBy=nAsc">
						Asc
						</a>
						<a href="IndexCaballeros?orderBy=nDesc">
						Desc
						</a>
					</th>
					<th scope="col">Fuerza
						<a href="IndexCaballeros?orderBy=fuerzaAsc">
							Asc
						</a>
						<a href="IndexCaballeros?orderBy=fuerzaDesc">
							Desc
						</a>
					</th>
					<th scope="col">EXP</th>
					<th scope="col">Arma</th>
					<th scope="col">Escudo</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${caballeros }" var="caballero">
					<tr>
						<th scope="col">${caballero.id }</th>
						<th scope="col">${caballero.nombre }</th>
						<th scope="col">${caballero.fuerza }</th>
						<th scope="col">${caballero.experiencia}</th>
						<th scope="col">${caballero.arma.nombre}</th>
						<th scope="col">${caballero.escudo.nombre}</th>
						<th scope="col">
							<a href="EditCaballeros?id=${caballero.id }">Modificar</a>
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="row mb-2 btn btn-primary color-white" href="IndexLucha" role="button">Luchar</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>