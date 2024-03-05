package com.jfuente040.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfuente040.dao.ProductoDAO;
import com.jfuente040.model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/producto" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch (opcion) {
		case "crear": {
			request.getRequestDispatcher("/views/crear.jsp").forward(request, response);
			break;
		}
		case "listar": {
			ProductoDAO productoDAO = new ProductoDAO();
			List<Producto> productos = new ArrayList<>();
			try {
				productos = productoDAO.obtenerProductos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("/views/listar.jsp").forward(request, response);
			break;
		}
		case "editar": {
			int idProducto = Integer.parseInt(request.getParameter("id"));
			Producto producto;
			ProductoDAO productoDAO = new ProductoDAO();
			producto = productoDAO.obtenerProducto(idProducto);
			request.setAttribute("producto", producto);
			request.getRequestDispatcher("/views/editar.jsp").forward(request, response);
			break;
		}
		case "eliminar": {
			int idProducto = Integer.parseInt(request.getParameter("id"));
			ProductoDAO productoDAO = new ProductoDAO();
			try {
				if (productoDAO.eliminar(idProducto)) {
					System.out.println("El producto se ha eliminado con exito");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
		default:
			
			break;
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		switch (opcion) {
		case "guardar": {
			Date fechaActual = new Date();
			ProductoDAO productoDAO = new ProductoDAO();
			Producto producto = new Producto();
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
			producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
			producto.setFecha_crear(new java.sql.Date(fechaActual.getTime()));
			try {
				if (productoDAO.guardar(producto)) {
						System.out.println("El producto se ha guardado con exito");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("El producto NO se ha guardado con exito");
				e.printStackTrace();
			}
			break;
		}
		case "editar": {
			ProductoDAO productoDAO = new ProductoDAO();
			Producto producto = new Producto();
			producto.setId(Integer.parseInt(request.getParameter("id")));
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
			producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
			producto.setFecha_actualizar(new java.sql.Date(new Date().getTime()));
			try {
				if (productoDAO.editar(producto)) {
					System.out.println("El producto se ha editado con exito");
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
		
	}

}
