package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Venda;

public class VendaBD {
	
	public ArrayList<Venda> listarVendas(){
		try {
			//REALIZA CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			
			//STRING COM A QUERY SQL 
			String querySQL = "SELECT * FROM distribuidora_cosmeticos.venda";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Venda> listaVendas = new ArrayList<Venda>();
			
			while(rs.next()) {
				Venda venda = new Venda(
						rs.getInt("id"), 
						rs.getString("nome_cliente"),
						rs.getString("nome_produto"),
						rs.getInt("quantidade")
						);
				
				listaVendas.add(venda);
			}
			
			conectar.fecharConexaoBD();
			return listaVendas;
			
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
