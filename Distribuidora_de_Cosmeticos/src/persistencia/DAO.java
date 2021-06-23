package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

	
	public static void main(String[] args) {
		Connection connection;
		
		// TODO Auto-generated method stub
		try {
			//REALIZA A CONEXÃO COM O BANCO DE DADOS
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "1234");
			System.out.println(connection);
			
			//String querySQL = "UPDATE `distribuidora_cosmeticos`.`cliente` SET `nome` = 'fe' WHERE `nome` = 'fernanda2';";
			
			PreparedStatement pst = connection.prepareStatement("UPDATE `distribuidora_cosmeticos`.`cliente` SET `nome` = 'feDEdEUS' WHERE `nome` = 'fernada2';");
			System.out.println(pst);
			pst.executeUpdate();
			
			//ResultSet rs = pst.executeQuery();
			//System.out.println(rs);
			
			//while(rs.next()) {
				
			//	System.out.println(rs.getString("nome"));
			//}
			
			
		}
		catch(Exception e) {
			System.err.println("Erro geral: "+e.getMessage());
		}
		
//Connection connection;
//		
//		// TODO Auto-generated method stub
//		try {
//			//REALIZA A CONEXÃO COM O BANCO DE DADOS
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "1234");
//			System.out.println(connection);
//			
//			String querySQL = "UPDATE distribuidora_cosmeticos.cliente SET `nome` = 'fe' WHERE `nome` = 'fernanda2'";
//			
//			PreparedStatement pst = connection.prepareStatement(querySQL);
//			pst.executeUpdate();
//			
////			String querySQL = "SELECT * FROM distribuidora_cosmeticos.cliente";
////			
////			PreparedStatement pst = connection.prepareStatement(querySQL);
////			System.out.println(pst);
////			
////			ResultSet rs = pst.executeQuery();
////			System.out.println(rs);
////			
////			while(rs.next()) {
////				
////				System.out.println(rs.getString("nome"));
////			}
//			
//			
//		}
//		catch(Exception e) {
//			System.err.println("Erro geral: "+e.getMessage());
//		}


	}

}
