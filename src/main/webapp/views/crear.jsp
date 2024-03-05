<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Crear producto</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
  </head>
<body>
	<div class="container mt-4">
		<h2>Crear producto</h2>
		<form action="producto" method="post">
		<input type="hidden" name="opcion" value="guardar">	
		  <div class="mb-3">
		    <label for="inputNombre" class="form-label">Nombre</label>
		    <input type="text" name="nombre" class="form-control" id="inputNombre" aria-describedby="emailHelp">
		  </div>
		  <div class="mb-3">
		    <label for="inputCantidad" class="form-label">Cantidad</label>
		    <input type="text" name="cantidad" class="form-control" id="inputCantidad">
		  </div>
		  <div class="mb-3">
		    <label for="inputPrecio" class="form-label">Precio</label>
		    <input type="text" name="precio" class="form-control" id="inputPrecio">
		  </div>
		  <button type="submit" class="btn btn-primary">Guardar</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script> 
</body>
</html>