package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.DBConnection;
import modelo.entity.Cliente;

public class ClienteService {
	
		DBConnection conexion = DBConnection.getInstance();
		
		public List<Cliente> findAllClientes(){
			
			List<Cliente> clientes = new ArrayList<>();
			DBConnection conexion = DBConnection.getInstance();
		
			String sql = "SELECT u.*, c.nombres, c.apellidos, c.telefonos, c.afp, c.sistema_salud, c.direccion, c.comuna, c.edad "
					+ "FROM usuarios u INNER JOIN clientes c ON u.run=c.rut";
			
			try {
				
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
			
				while(rs.next()) {
					
					int run = rs.getInt("run");
					String nombre = rs.getString("nombre");
					String fechaNacimiento = rs.getString("fecha_nacimiento");
					String tipo = rs.getString("tipo");
					String nombres = rs.getString("nombres");
					String apellidos = rs.getString("apellidos");
					String telefonos = rs.getString("telefonos");
					String afp = rs.getString("afp");
					int sistemaSalud = rs.getInt("sistema_salud");
					String direccion = rs.getString("direccion");
					String comuna = rs.getString("comuna");
					byte edad = rs.getByte("edad");
				
					Cliente cliente = new Cliente(run,nombre,fechaNacimiento, tipo,
							run, nombres,apellidos,telefonos,afp,sistemaSalud,direccion,comuna,edad);
					clientes.add(cliente);
				}
			} catch (Exception e) {
				e.getMessage();
			}
			return clientes;
		}
		
		public boolean deleteClienteByRut(int rut) {
			
			DBConnection conexion = DBConnection.getInstance();
		    String sql = "DELETE FROM clientes "
		    		+ "WHERE rut = ?" ;

		    try {
		    	
		    	PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
		    	statement.setInt(1, rut);
		    	int rowsAffected = statement.executeUpdate();
		      
		    	return rowsAffected > 0;
		      
		    } catch (Exception e) {
		    	
		      System.out.println(e.getMessage());
		      return false;
		      
		    }
		     
		}
		
		public Cliente findByRutCliente(int run) {
			
			Cliente cliente = null;
			String sql = "SELECT u.*, c.nombres, c.apellidos, c.telefonos, c.afp, c.sistema_salud, c.direccion, c.comuna, c.edad "
					+ "FROM usuarios u INNER JOIN clientes c ON u.run=c.rut "
					+ "WHERE u.run = ?";
			    
			try {
				
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			    statement.setInt(1, run);
			    ResultSet rs = statement.executeQuery();
			    	
			    if(rs.next()) {
			    	
					String nombre = rs.getString("nombre");
					String fechaNacimiento = rs.getString("fecha_nacimiento");
					String tipo = rs.getString("tipo");
					int rut = run;
					String nombres = rs.getString("nombres");
					String apellidos = rs.getString("apellidos");
					String telefonos = rs.getString("telefonos");
					String afp = rs.getString("afp");
					int sistemaSalud = rs.getInt("sistema_salud");
					String direccion = rs.getString("direccion");
					String comuna = rs.getString("comuna");
					byte edad = rs.getByte("edad");
				
					cliente = new Cliente(run,nombre,fechaNacimiento,tipo,
							rut, nombres,apellidos,telefonos,afp,sistemaSalud,direccion,comuna,edad);
				
			    }
			    	
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			      
			}
			return cliente;
			    
		}

		  public Cliente updateCliente(Cliente cliente) {
			  
			  String sql = "UPDATE clientes SET "
			  		+ "rut=?, nombres=?, apellidos=?, telefonos=?, afp=?, sistema_salud=?, direccion=?, comuna=?, edad=? "
			  		+ "WHERE rut = ?";
			    
			  try {
				  
				  PreparedStatement statement = conexion.getConnection().prepareStatement(sql);

				  statement.setInt(1, cliente.getRutCliente());
				  statement.setString(2, cliente.getNombres());
				  statement.setString(3, cliente.getApellidos());
				  statement.setString(4, cliente.getTelefonos());
				  statement.setString(5, cliente.getAfp());
				  statement.setInt(6, cliente.getSistemaSalud());
				  statement.setString(7, cliente.getDireccion());
				  statement.setString(8, cliente.getComuna());
				  statement.setInt(9, cliente.getEdad());
				  statement.setInt(10, cliente.getRunUsuario());
				  
				  statement.executeUpdate();
			      
			    } catch (Exception e) {
			    	
			    	System.out.println(e.getMessage());
			    	
			    }
			  
			    return cliente;
		  }

		  public Cliente saveCliente(Cliente cliente) {
			  
			  DBConnection conexion = DBConnection.getInstance();
			  String sql = "INSERT INTO clientes "
			  		+ "(rut, nombres, apellidos, telefonos, afp, sistema_salud, direccion, comuna, edad) "
			    	+ "VALUES ( ? , ?, ?, ?, ?, ?, ? ,?, ?)";
			  
			  try {
				  
				  PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);
				  
				  preparedStatement.setInt(1, cliente.getRutCliente());
				  preparedStatement.setString(2, cliente.getNombres());
				  preparedStatement.setString(3, cliente.getApellidos());
				  preparedStatement.setString(4, cliente.getTelefonos());
				  preparedStatement.setString(5, cliente.getAfp());
				  preparedStatement.setInt(6, cliente.getSistemaSalud());
				  preparedStatement.setString(7, cliente.getDireccion());
				  preparedStatement.setString(8, cliente.getComuna());
				  preparedStatement.setInt(9, cliente.getEdad());
				  
				  preparedStatement.executeUpdate();
				  
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
					
				}
			    return cliente;
			    
		  }
		  
	}
