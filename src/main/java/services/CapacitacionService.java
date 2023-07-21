package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.DBConnection;
import modelo.entity.Capacitacion;

public class CapacitacionService {
	
	DBConnection conexion = DBConnection.getInstance();
	
	public List<Capacitacion> findAllCapacitaciones(){
		
		List<Capacitacion> capacitaciones = new ArrayList<>();
		DBConnection conexion = DBConnection.getInstance();
	
		String sql = "SELECT * FROM capacitaciones";
		
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
			
				int identificador = rs.getInt("identificador");
				int rut = rs.getInt("rut");
				String dia = rs.getString("dia");
				String hora = rs.getString("hora");
				String lugar = rs.getString("lugar");
				String duracion = rs.getString("duracion");
				int cantidadAsistentes = rs.getInt("cantidadasistentes");
			
				Capacitacion capacitacion = new Capacitacion(
						identificador,rut,dia,hora,lugar,duracion,cantidadAsistentes);
				capacitaciones.add(capacitacion);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return capacitaciones;
	}

	public boolean deleteCapacitacionByIdentificador(int identificador) {
		
		DBConnection conexion = DBConnection.getInstance();
	    String sql = "DELETE FROM capacitaciones WHERE identificador = ?" ;
	    
	    try {
	    	
	    	PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
	    	statement.setInt(1, identificador);
	    	int rowsAffected = statement.executeUpdate();
	      
	    	return rowsAffected > 0;
	      
	    } catch (Exception e) {
	    	
	      System.out.println(e.getMessage());
	      return false;
	      
	    }
	     
	  }
	  
	  public Capacitacion findByIdentificadorCapacitacion(int identificador) {
	    
	    Capacitacion capacitacion = null;
	    String sql = "SELECT * FROM capacitaciones WHERE identificador = ?";
	    
	    try {
	    	
	    	PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
	    	statement.setInt(1, identificador);
	    	ResultSet rs = statement.executeQuery();
	    	
	    	if(rs.next()) {

				int rut = rs.getInt("rut");
				String dia = rs.getString("dia");
				String hora = rs.getString("hora");
				String lugar = rs.getString("lugar");
				String duracion = rs.getString("duracion");
				int cantidadAsistentes = rs.getInt("cantidadasistentes");

				capacitacion = new Capacitacion(identificador,rut,dia,hora,lugar,duracion,cantidadAsistentes);
	        
	    	}
	    } catch (Exception e) {
	    	
	      System.out.println(e.getMessage());
	      
	    }
	    return capacitacion;
	  }
	  
	  public Capacitacion updateCapacitacion(Capacitacion capacitacion) {
	    
	    String sql = "UPDATE capacitaciones SET rut = ?, dia = ?, hora = ?, lugar = ?, duracion = ?, cantidadasistentes = ? WHERE identificador = ?";
	    
	    try {
	    	
	    	PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
	    	statement.setInt(1, capacitacion.getRut());
	    	statement.setString(2, capacitacion.getDia());
	    	statement.setString(3, capacitacion.getHora());
	    	statement.setString(4, capacitacion.getLugar());
	    	statement.setString(5, capacitacion.getDuracion());
	    	statement.setInt(6, capacitacion.getCantidadAsistentes());
	    	statement.setInt(7, capacitacion.getIdentificador());
	    	
	    	statement.executeUpdate();
	      
	    } catch (Exception e) {
	    	
	    	System.out.println(e.getMessage());
	    	
	    }
	    return capacitacion;
	  }
	  
	  public Capacitacion saveCapacitacion(Capacitacion capacitacion) {
		    
		    DBConnection conexion = DBConnection.getInstance();
		    String sql = "INSERT INTO capacitaciones (rut, dia, hora, lugar, duracion, cantidadasistentes) "
		    		+ "VALUES ( ? , ?, ?, ?, ?, ?)";
		    
		    try {
		    	
		    	PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);
		    	preparedStatement.setInt(1, capacitacion.getRut());
		    	preparedStatement.setString(2, capacitacion.getDia());
		    	preparedStatement.setString(3, capacitacion.getHora());
		    	preparedStatement.setString(4, capacitacion.getLugar());
		    	preparedStatement.setString(5, capacitacion.getDuracion());
		    	preparedStatement.setInt(6, capacitacion.getCantidadAsistentes());
		    	
		    	preparedStatement.executeUpdate();
		      
		      
		    } catch (Exception e) {
		      System.out.println(e.getMessage());
		    }
		    return capacitacion;
		  }
}
