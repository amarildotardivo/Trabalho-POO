package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;

public class ClienteDB {
	
	public ArrayList<Cliente> listarClientes(){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.cliente";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
			
			while(rs.next()) {
				Cliente cliente = new Cliente(
						rs.getString("nome"), 
						rs.getString("logradouro"), 
						rs.getString("numero"), 
						rs.getString("bairro"), 
						rs.getString("cidade"), 
						rs.getString("telefone"), 
						rs.getString("cpf"), 
						rs.getString("nome_representante"));
				
				listaClientes.add(cliente);
			}
			
			conectar.fecharConexaoBD();
			return listaClientes;
			
		}
		catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
        }
		catch (Exception e) {
			System.err.println("Erro geral: "+ e.getMessage());
		}
		
		return null;
	}
	
	public ArrayList<Cliente> BuscarCliente(){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.cliente WHERE nome = ";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
			
			while(rs.next()) {
				Cliente cliente = new Cliente(
						rs.getString("nome"), 
						rs.getString("logradouro"), 
						rs.getString("numero"), 
						rs.getString("bairro"), 
						rs.getString("cidade"), 
						rs.getString("telefone"), 
						rs.getString("cpf"), 
						rs.getString("nome_representante"));
				
				listaClientes.add(cliente);
			}
			
			conectar.fecharConexaoBD();
			return listaClientes;
			
		}
		catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
        }
		catch (Exception e) {
			System.err.println("Erro geral: "+ e.getMessage());
		}
		
		return null;
	}
}


