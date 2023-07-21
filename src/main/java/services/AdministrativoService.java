package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.DBConnection;
import modelo.entity.Administrativo;

public class AdministrativoService {
	DBConnection conexion = DBConnection.getInstance();
	
	public List<Administrativo> findAllAdministrativos(){
		
		List<Administrativo> administrativos = new ArrayList<>();
		DBConnection conexion = DBConnection.getInstance();
	
		String sql = "SELECT u.*, a.area, a.experiencia "
				+ "FROM usuarios u INNER JOIN administrativos a ON u.run=a.run";
		
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
				
				int run = rs.getInt("run");
				String nombre = rs.getString("nombre");
				String fechaNacimiento = rs.getString("fecha-nacimiento");
				String tipo = rs.getString("tipo");
				String area = rs.getString("area");
				String experiencia = rs.getString("experiencia");
			
				Administrativo administrativo = new Administrativo(run, nombre,fechaNacimiento, tipo, run, area, experiencia);
				administrativos.add(administrativo);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return administrativos;
	}
	
	public boolean deleteAdministrativoByRun(int run) {
		
		DBConnection conexion = DBConnection.getInstance();
	    String sql = "DELETE FROM administrativos WHERE run = ?" ;

	    try {
	    	
	    	PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
	    	statement.setInt(1, run);
	    	int rowsAffected = statement.executeUpdate();
	      
	    	return rowsAffected > 0;
	      
	    } catch (Exception e) {
	    	
	      System.out.println(e.getMessage());
	      return false;
	      
	    }
	     
	}
	
	public Administrativo findByRunAdministrativo(int run) {
		
		Administrativo administrativo = null;
		String sql = "SELECT u.*, a.area, a.experiencia "
				+ "FROM usuarios u INNER JOIN administrativos a "
				+ "ON u.run=a.run WHERE u.run = ?";
		    
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
		    statement.setInt(1, run);
		    ResultSet rs = statement.executeQuery();
		    	
		    if(rs.next()) {
		    	
				String nombre = rs.getString("nombre");
				String fechaNacimiento = rs.getString("fecha_nacimiento");
				String tipo = rs.getString("tipo");
				String area = rs.getString("area");
				String experiencia = rs.getString("experiencia");
				
				administrativo = new Administrativo(run, nombre,fechaNacimiento, tipo, run, area, experiencia);
		        
		    }
		    	
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		      
		}
		return administrativo;
		    
	}

	  public Administrativo updateAdministrativo(Administrativo administrativo) {
		  
		  String sql = "UPDATE administrativos SET "
		  		+ "area = ?, experiencia = ? "
		  		+ "WHERE run = ?";
		    
		  try {
			  
			  PreparedStatement statement = conexion.getConnection().prepareStatement(sql);

			  statement.setString(1, administrativo.getArea());
			  statement.setString(2, administrativo.getAniosExperiencia());
			  statement.setInt(3, administrativo.getRun());
		    	
			  statement.executeUpdate();
		      
		    } catch (Exception e) {
		    	
		    	System.out.println(e.getMessage());
		    	
		    }
		  
		    return administrativo;
	  }

	  public Administrativo saveAdministrativo(Administrativo administrativo) {
		  
		  DBConnection conexion = DBConnection.getInstance();
		  String sql = "INSERT INTO administrativos "
		  		+ "(run, area, experiencia) "
		    	+ "VALUES ( ? , ?, ?)";
		  
		  try {
			  
			  PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);
			  preparedStatement.setInt(1, administrativo.getRunUsuario());
			  preparedStatement.setString(2, administrativo.getArea());
			  preparedStatement.setString(3, administrativo.getAniosExperiencia());
			  
			  preparedStatement.executeUpdate();
			  
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
		    return administrativo;
		    
	  }
	  
}
