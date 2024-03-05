package com.jfuente040.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jfuente040.conexion.Conexion;
import com.jfuente040.model.Producto;

public class ProductoDAO {
	
	public boolean guardar(Producto p) throws SQLException  {
		boolean estado;
		String query = "insert into productos (id,nombre, cantidad, precio, fecha_crear, fecha_actualizar) values (?,?,?,?,?,?);";
		
		try (Connection connection = Conexion.getConnection()) 
		{
			connection.setAutoCommit(false);
			try(PreparedStatement statement = connection.prepareStatement(query);) {
				statement.setString(1, null);
				statement.setString(2, p.getNombre());
				statement.setDouble(3, p.getCantidad());
				statement.setDouble(4, p.getPrecio());
				statement.setDate(5, p.getFecha_crear());
				statement.setDate(6,p.getFecha_actualizar());
				estado = statement.executeUpdate()>0;
			} catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
				estado = false;
				e.printStackTrace();
			}
			connection.commit();
			connection.setAutoCommit(true);
		} 
		return estado;
	}
	
	public boolean editar(Producto p) throws SQLException {
		boolean estado = false;
		String sql_actualizar = "update productos set nombre=?, cantidad=?, precio=?, fecha_actualizar=? where id=?";
		
		try (Connection connection = Conexion.getConnection())
		{
			connection.setAutoCommit(false);
			try (PreparedStatement statement = connection.prepareStatement(sql_actualizar))
			{
				statement.setString(1, p.getNombre());
				statement.setDouble(2, p.getCantidad());
				statement.setDouble(3, p.getPrecio());
				statement.setDate(4,p.getFecha_actualizar());
				statement.setInt(5,p.getId());
				estado = statement.executeUpdate()>0;
			} catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
				estado = false;
				e.printStackTrace();
			}	
			connection.commit();
			connection.setAutoCommit(true);
		}
		return estado;
	}
	
	public boolean eliminar(int idProducto) throws SQLException {
		boolean estado = false;
		String sql_delete = "delete from productos where id=?";
		
		try (Connection connection = Conexion.getConnection())
		{
			connection.setAutoCommit(false);
			try(PreparedStatement statement = connection.prepareStatement(sql_delete))
			{
				statement.setInt(1, idProducto);
				estado = statement.executeUpdate()>0;
			}
			catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
				estado=false;
				e.printStackTrace();		
			}
			connection.commit();
			connection.setAutoCommit(true);
		}
		return estado;
	}

	
	public List<Producto> obtenerProductos() throws SQLException {
		String sql_listar = "select * from productos";
		List<Producto> productos = new ArrayList<>();

		try (Connection connection = Conexion.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql_listar)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setCantidad(rs.getDouble("cantidad"));
				p.setPrecio(rs.getDouble("precio"));
				p.setFecha_crear(rs.getDate("fecha_crear"));
				p.setFecha_actualizar(rs.getDate("fecha_actualizar"));
				productos.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return productos;		
	}
	
	public Producto obtenerProducto(int id) { 
		String sql_listar = "select * from productos where id=?";
		Producto p = null;
		try (Connection connection = Conexion.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql_listar)){
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				p = new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setCantidad(rs.getDouble("cantidad"));
				p.setPrecio(rs.getDouble("precio"));
				p.setFecha_crear(rs.getDate("fecha_crear"));
				p.setFecha_actualizar(rs.getDate("fecha_actualizar"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return p;
	}
}
