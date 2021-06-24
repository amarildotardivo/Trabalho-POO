package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Fabricante;

public class FabricanteBD {
	
	public ArrayList<Fabricante> BuscarFabricante(String nome_busca){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.fabricante WHERE nome like '%"+ nome_busca + "%'";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Fabricante> buscarFabricante = new ArrayList<Fabricante>();
			
			while(rs.next()) {
				Fabricante fab = new Fabricante(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("logradouro"), 
						rs.getString("numero"), 
						rs.getString("bairro"), 
						rs.getString("cidade"), 
						rs.getString("telefone"), 
						rs.getString("cnpj"));
				
				buscarFabricante.add(fab);
			}
			
			conectar.fecharConexaoBD();
			return buscarFabricante;
			
		}
		catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
        }
		catch (Exception e) {
			System.err.println("Erro geral: "+ e.getMessage());
		}
		
		return null;
	}
	
	public void DeletarFabricante(Fabricante f){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "DELETE FROM distribuidora_cosmeticos.fabricante WHERE id = ?";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			stmt.setInt(1, f.getId());
			
			stmt.executeUpdate();
			
			conectar.fecharConexaoBD();
			
		}
		catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
        }
		catch (Exception ex) {
			System.err.println("Erro geral: "+ ex.getMessage());
		}
	}
	
	public ArrayList<Fabricante> listarFabricantes(){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.fabricante";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Fabricante> listaFabricantes = new ArrayList<Fabricante>();
			
			while(rs.next()) {
				Fabricante fab = new Fabricante(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("logradouro"), 
						rs.getString("numero"), 
						rs.getString("bairro"), 
						rs.getString("cidade"), 
						rs.getString("telefone"), 
						rs.getString("cnpj"));
				
				listaFabricantes.add(fab);
			}
			
			conectar.fecharConexaoBD();
			return listaFabricantes;
			
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
