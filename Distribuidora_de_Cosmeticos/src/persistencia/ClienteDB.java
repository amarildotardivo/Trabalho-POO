package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import apresentacao.TelaErro;
import apresentacao.TelaInformacao;
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
			String nomeCliente = null;
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
				nomeCliente = rs.getString("nome");
				
				buscarCliente.add(cliente);
			}
			
			conectar.fecharConexaoBD();
			
			//Popup de Informação
			TelaInformacao tInformacao = new TelaInformacao("Cliente: " + nomeCliente   , " Buscado com Sucesso!");
			tInformacao.setVisible(true);
			
			return buscarCliente;
			
		}
		catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
          //Popup de Erro
			TelaErro tErro = new TelaErro("Error de Banco de Dados: " + ex);
			tErro.setVisible(true);
        }
		catch (Exception e) {
			System.err.println("Erro geral: "+ e.getMessage());
			//Popup de Erro
			TelaErro tErro = new TelaErro("Error: " + e);
			tErro.setVisible(true);
		}
		
		return null;
	}
	
	public void DeletarCliente(Cliente c){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "DELETE FROM distribuidora_cosmeticos.cliente WHERE id = ?";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			stmt.setInt(1, c.getId());
			
			stmt.executeUpdate();
			
			System.out.println("Cliente Deletado com sucesso!");
			//Popup de Informação
			TelaInformacao tInformacao = new TelaInformacao("Cliente: " + c.getNome(), "Deletado com Sucesso!");
			tInformacao.setVisible(true);

			conectar.fecharConexaoBD();			
		}
		catch (SQLException ex){
            System.err.println("Erro SQL "+ex.getMessage());
          //Popup de Erro
			TelaErro tErro = new TelaErro("Error SQL: " + ex);
			tErro.setVisible(true);
        }
		catch (Exception ex) {
			System.err.println("Erro geral: "+ ex.getMessage());
			//Popup de Erro
			TelaErro tErro = new TelaErro("Error geral: " + ex);
			tErro.setVisible(true);
		}
	}
}


