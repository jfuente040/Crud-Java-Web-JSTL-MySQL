<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listar productos</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<h2>Listado de productos</h2>
		<div class="table-responsive small">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Cantidad</th>
						<th scope="col">Precio</th>
						<th scope="col">Fecha creación</th>
						<th scope="col">Fecha actualización</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${productos }">
						<tr>
							<td><c:out value="${producto.id }"></c:out></td>
							<td><c:out value="${producto.nombre }"></c:out></td>
							<td><c:out value="${producto.cantidad }"></c:out></td>
							<td><c:out value="${producto.precio }"></c:out></td>
							<td><c:out value="${producto.fecha_crear }"></c:out></td>
							<td><c:out value="${producto.fecha_actualizar }"></c:out></td>
							<td>
								<a type="button" 
									class="btn btn-outline-success btn-sm"
									href="producto?opcion=editar&id=<c:out value="${producto.id }"></c:out>">
								Editar
								</a>
								<a type="button"
								 	class="btn btn-danger btn-sm"
								 	href="producto?opcion=eliminar&id=<c:out value="${producto.id }"></c:out>">
								Eliminar
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
</body>
</html>