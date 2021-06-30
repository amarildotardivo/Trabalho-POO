package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Estoque;

public class EstoqueBD {
	
	public ArrayList<Estoque> BuscarProduto(String nome_busca){
		try {
			//REALIZA CONEX�O COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.estoque WHERE nome like '%"+ nome_busca + "%'";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Estoque> buscarProduto = new ArrayList<Estoque>();
			
			while(rs.next()) {
				Estoque est = new Estoque(
						rs.getInt("id"), 
						rs.getString("nome_produto"), 
						rs.getString("tipo_produto"), 
						rs.getInt("quantidade"), 
						rs.getDouble("preco_compra"), 
						rs.getDouble("preco_venda"), 
						rs.getString("nome_fabricante")
						);
				
				buscarProduto.add(est);
			}
			
			conectar.fecharConexaoBD();
			return buscarProduto;
			
		}
		catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
        }
		catch (Exception e) {
			System.err.println("Erro geral: "+ e.getMessage());
		}
		
		return null;
	}
	
	public void DeletarProduto(Estoque est){
		try {
			//REALIZA CONEX�O COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "DELETE FROM distribuidora_cosmeticos.estoque WHERE id = ?";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			stmt.setInt(1, est.getId());
			
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
	
	public ArrayList<Estoque> listarProdutos(){
		try {
			//REALIZA CONEX�O COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.estoque";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Estoque> listaProdutos = new ArrayList<Estoque>();
			
			while(rs.next()) {
				Estoque est = new Estoque(
						rs.getInt("id"), 
						rs.getString("nome_produto"), 
						rs.getString("tipo_produto"), 
						rs.getInt("quantidade"), 
						rs.getDouble("preco_compra"), 
						rs.getDouble("preco_venda"), 
						rs.getString("nome_fabricante")
						);
				
				listaProdutos.add(est);
			}
			
			conectar.fecharConexaoBD();
			return listaProdutos;
			
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
