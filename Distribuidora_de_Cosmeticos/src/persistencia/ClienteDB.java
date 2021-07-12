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
//			String repSQL = "SELECT * FROM distribuidora_cosmeticos.representante";
			//CRIA O COMANDO SQL
			PreparedStatement stmtCli = conectar.conectarBD().prepareStatement(querySQL);
//			PreparedStatement stmtRep = conectar.conectarBD().prepareStatement(repSQL);
			
			ResultSet rs = stmtCli.executeQuery();
//			ResultSet rsRep = stmtRep.executeQuery();
			
			ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
			
			while(rs.next()) {
				Cliente cliente = new Cliente(
						rs.getInt("id"), 
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
	
	public ArrayList<Cliente> BuscarCliente(String nome_busca){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.cliente WHERE nome like '%"+ nome_busca + "%'";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Cliente> buscarCliente = new ArrayList<Cliente>();
			
			while(rs.next()) {
				Cliente cliente = new Cliente(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("logradouro"), 
						rs.getString("numero"), 
						rs.getString("bairro"), 
						rs.getString("cidade"), 
						rs.getString("telefone"), 
						rs.getString("cpf"), 
						rs.getString("nome_representante")
						);
				
				buscarCliente.add(cliente);
			}
			
			conectar.fecharConexaoBD();
			
			return buscarCliente;
			
		}
		catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
        }
		catch (Exception e) {
			System.err.println("Erro geral: "+ e.getMessage());
		}
		
		return null;
	}
	
	public boolean DeletarCliente(Cliente c){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "DELETE FROM distribuidora_cosmeticos.cliente WHERE id = ?";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			stmt.setInt(1, c.getId());
			
			stmt.executeUpdate();
			

			conectar.fecharConexaoBD();		
			
			System.out.println("Cliente Deletado com sucesso!");
			return true;
		}
		catch (SQLException ex){
            System.err.println("Erro SQL "+ex.getMessage());
        }
		catch (Exception ex) {
			System.err.println("Erro geral: "+ ex.getMessage());
		}
		
		return false;
	}
}


