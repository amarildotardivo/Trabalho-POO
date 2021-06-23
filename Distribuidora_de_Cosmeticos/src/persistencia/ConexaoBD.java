package persistencia;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {      
	
	final String url = "jdbc:mysql://localhost:3306";         
	final String usuario = "root";         
	final String senha = "1234";//ALTERAR A SENHA DO ROOT DO MYSQL SE PRECISAR PARA CRIAR O BD E AS TABELAS
	
	private Connection conexao;

	//CONSTRUTOR DA CONEX�O
	public ConexaoBD() throws SQLException{
		try {
			//REALIZA A CONEX�O COM O BANCO DE DADOS
			conexao = DriverManager.getConnection(url, usuario, senha);
			
		}
		catch(Exception e) {
			System.err.println("Erro geral: "+e.getMessage());
		}
	}
	
	//GET DA CONEX�O
	public Connection conectarBD() {
		return this.conexao;
	}
	
	//METODO QUE FECHA A CONEX�O
	public void fecharConexaoBD() {
		try {
			conexao.close();
		}
		catch (Exception e) {
			System.err.println("Erro ao desconectar: "+e.getMessage());
		}
	}	 
	
}
