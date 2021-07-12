package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Produto;

public class ProdutoBD {
	
	public ArrayList<Produto> BuscarProduto(String nome_busca){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.estoque WHERE nome_produto like '%"+ nome_busca + "%'";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Produto> buscarProduto = new ArrayList<Produto>();
			
			while(rs.next()) {
				Produto est = new Produto(
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
	
	public void DeletarProduto(Produto est){
		try {
			//REALIZA CONEXÃO COM O BD
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
	
	public ArrayList<Produto> listarProdutos(){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.estoque";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
			
			while(rs.next()) {
				Produto est = new Produto(
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
