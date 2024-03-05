<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Menú de opciones</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
  </head>
  <body>
  	<div class="container mt-4">
    	<h2>Menu de opciones de producto</h2>
    	<table class="table mt-4">
		  <tbody>
		    <tr>
		      <th>1</th>
		      <td><a class="btn btn-info" href="producto?opcion=crear">Crear un producto</a></td>
		    </tr>
		    <tr>
		      <th>2</th>
		      <td><a class="btn btn-info" href="producto?opcion=listar">Listar productos</a></td>
		    </tr>		    
		  </tbody>
		</table>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script> 
  </body>
</html>