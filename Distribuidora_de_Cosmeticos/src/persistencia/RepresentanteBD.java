package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Representante;

public class RepresentanteBD {
	
	public ArrayList<Representante> BuscarRepresentante(String nome_busca){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.representante WHERE nome like '%"+ nome_busca + "%'";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Representante> buscarRep = new ArrayList<Representante>();
			
			while(rs.next()) {
				Representante rep = new Representante(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("logradouro"), 
						rs.getString("numero"), 
						rs.getString("bairro"), 
						rs.getString("cidade"), 
						rs.getString("telefone"), 
						rs.getString("cpf"), 
						rs.getString("regiao"));
				
				buscarRep.add(rep);
			}
			
			conectar.fecharConexaoBD();
			return buscarRep;
			
		}
		catch (SQLException ex){
            System.err.println("Erro ao recuperar "+ex.getMessage());
        }
		catch (Exception e) {
			System.err.println("Erro geral: "+ e.getMessage());
		}
		
		return null;
	}
	
	public void DeletarRepresentante(Representante r){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "DELETE FROM distribuidora_cosmeticos.representante WHERE id = ?";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			stmt.setInt(1, r.getId());
			
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
	
	public ArrayList<Representante> listarRepresentantes(){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.representante";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Representante> listarep = new ArrayList<Representante>();
			
			while(rs.next()) {
				Representante rep = new Representante(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("logradouro"), 
						rs.getString("numero"), 
						rs.getString("bairro"), 
						rs.getString("cidade"), 
						rs.getString("telefone"), 
						rs.getString("cpf"), 
						rs.getString("regiao"));
				
				listarep.add(rep);
			}
			
			conectar.fecharConexaoBD();
			return listarep;
			
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


