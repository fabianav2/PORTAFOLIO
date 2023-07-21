package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.DBConnection;
import modelo.entity.Administrativo;
import modelo.entity.Profesional;

public class ProfesionalService {
	
	DBConnection conexion = DBConnection.getInstance();
	
	public List<Profesional> findAllProfesionales(){
		
		List<Profesional> profesionales = new ArrayList<>();
		DBConnection conexion = DBConnection.getInstance();
	
		String sql = "SELECT u.*, p.titulo, p.fecha_ingreso "
				+ "FROM usuarios u INNER JOIN profesionales p ON u.run=p.run";
		
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
				
				int run = rs.getInt("run");
				String nombre = rs.getString("nombre");
				String fechaNacimiento = rs.getString("fecha_nacimiento");
				String tipo = rs.getString("tipo");
				String titulo = rs.getString("titulo");
				String fechaIngreso = rs.getString("fecha_ingreso");
			
				Profesional profesional = new Profesional(run, nombre,fechaNacimiento,tipo, run, titulo, fechaIngreso);
				profesionales.add(profesional);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return profesionales;
	}
	
	public boolean deleteProfesionalByRun(int run) {
		
		DBConnection conexion = DBConnection.getInstance();
	    String sql = "DELETE FROM profesionales "
	    		+ "WHERE run = ?" ;

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
	
	public Profesional findByRunProfesional(int run) {
		
		Profesional profesional = null;
		String sql = "SELECT u.*, p.titulo, p.fecha_ingreso "
				+ "FROM usuarios u INNER JOIN profesionales p ON u.run=p.run "
				+ "WHERE p.run = ?";
		    
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
		    statement.setInt(1, run);
		    ResultSet rs = statement.executeQuery();
		    	
		    if(rs.next()) {
		    	
				String nombre = rs.getString("nombre");
				String fechaNacimiento = rs.getString("fecha_nacimiento");
				String tipo = rs.getString("tipo");
				String titulo = rs.getString("titulo");
				String fechaIngreso = rs.getString("fecha_ingreso");
				
				profesional = new Profesional(run, nombre,fechaNacimiento,tipo, run, titulo, fechaIngreso);
		        
		    }
		    	
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		      
		}
		return profesional;
		    
	}
	
	  public Profesional updateProfesional(Profesional profesional) {
		  
		  String sql = "UPDATE profesionales SET titulo = ?, fecha_ingreso = ? "
		  		+ "WHERE run = ?";
		    
		  try {
			  
			  PreparedStatement statement = conexion.getConnection().prepareStatement(sql);

			  statement.setString(1, profesional.getTitulo());
			  statement.setString(2, profesional.getFechaIngreso());
			  statement.setInt(3, profesional.getRun());
		    	
			  statement.executeUpdate();
		      
		    } catch (Exception e) {
		    	
		    	System.out.println(e.getMessage());
		    	
		    }
		  
		    return profesional;
	  }

	  public Profesional saveProfesional(Profesional profesional) {
		  
		  DBConnection conexion = DBConnection.getInstance();
		  String sql = "INSERT INTO profesionales (run, titulo, fecha_ingreso) "
		    		+ "VALUES ( ? , ?, ?)";
		  
		  try {
			  
			  PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);
			  
			  preparedStatement.setInt(1, profesional.getRunUsuario());
			  preparedStatement.setString(2, profesional.getTitulo());
			  preparedStatement.setString(3, profesional.getFechaIngreso());
			  
			  preparedStatement.executeUpdate();
			  
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
		    return profesional;
		    
	  }

}
