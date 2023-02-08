package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Centro;
import modelo.Departamento;

public class DepartamentoDao {

	private ConexionBD conexion;

	public DepartamentoDao() {
		this.conexion = new ConexionBD();
	}
	
	public ArrayList<Departamento> obtenerDepartamento(){
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Departamento> lista = new ArrayList<Departamento>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from Departamentos");
			
			while(resultado.next()) {
				int cod_departamento = resultado.getInt("cod_departamento");
				int cod_centro=resultado.getInt("cod_centro");
				String tipo_dir = resultado.getString("tipo_dir");
				int presupuesto = resultado.getInt("presupuesto");
				String nombre = resultado.getString("nombre");
				
				Departamento departamento = new Departamento(cod_departamento, cod_centro, tipo_dir, presupuesto, nombre);
				lista.add(departamento);
			}
		}catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre los departamentos: "+e.getMessage());
		}finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			}catch(SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			}catch (Exception e) {
				
			}
		}return lista;
	}
	
	 public int insertarDepartamento (Departamento departamento) {
			Connection con = conexion.getConexion();
			PreparedStatement consulta = null;
			int resultado=0;
			
			try {
				consulta = con.prepareStatement("INSERT INTO Departamentos (cod_departamento,cod_centro,tipo_dir,presupueto, nombre)"
						+ " VALUES (?,?,?,?,?) ");
				
				
				consulta.setInt(1, departamento.getCod_departamento() );
				consulta.setInt(2, departamento.getCod_centro());
				consulta.setString(3, departamento.getTipo_dir());
				consulta.setInt(4,  departamento.getPresupuesto());
				consulta.setString(5, departamento.getNombre());
				resultado=consulta.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Error al realizar la inserci�n del departamento: "
			        +e.getMessage());
			} finally {
				try {
					consulta.close();
					conexion.desconectar();
				} catch (SQLException e) {
					System.out.println("Error al liberar recursos: "+e.getMessage());
				} catch (Exception e) {
					
				}
			}
			return resultado;
	    }

}
