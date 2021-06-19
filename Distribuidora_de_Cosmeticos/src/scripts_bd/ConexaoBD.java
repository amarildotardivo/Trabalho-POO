package scripts_bd;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {      
	
	public static void criarBD()throws SQLException {
		
		final String url = "jdbc:mysql://localhost:3306";         
		final String usuario = "root";         
		final String senha = "1234";//ALTERAR A SENHA DO ROOT DO MYSQL SE PRECISAR PARA CRIAR O BD E AS TABELAS
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);    
		
		Statement stmt = conexao.createStatement();
		System.out.println("Realizada conexão com o BD!");
		
		stmt.execute("CREATE DATABASE IF NOT EXISTS distribuidora_cosmeticos");
		System.out.println("Criado BD da Distribuidora!");
		
		stmt.execute("USE distribuidora_cosmeticos");
		System.out.println("Utilizando BD da Distribuidora...");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS representante(\r\n"
				+ "	id_representante INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "    nome VARCHAR(255),\r\n"
				+ "    logradouro VARCHAR(255),\r\n"
				+ "    numero VARCHAR(255),\r\n"
				+ "    bairro VARCHAR(255),\r\n"
				+ "    cidade VARCHAR(255),\r\n"
				+ "    telefone VARCHAR(255),\r\n"
				+ "    regiao VARCHAR(255),\r\n"
				+ "    PRIMARY KEY (id_representante)\r\n"
				+ ")");
		System.out.println("Criada tabela REPRESENTANTE!");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS cliente(\r\n"
				+ "	id_cliente INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "    nome VARCHAR(255),\r\n"
				+ "    logradouro VARCHAR(255),\r\n"
				+ "    numero VARCHAR(255),\r\n"
				+ "    bairro VARCHAR(255),\r\n"
				+ "    cidade VARCHAR(255),\r\n"
				+ "    telefone VARCHAR(255),\r\n"
				+ "    cpf VARCHAR(255),\r\n"
				+ "    nome_representante VARCHAR(255),\r\n"
				+ "    PRIMARY KEY (id_cliente)\r\n"
				+ ")");
		System.out.println("Criada tabela CLIENTE!");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS fabricante(\r\n"
				+ "	id_fabricante INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "	nome VARCHAR(255),\r\n"
				+ "    logradouro VARCHAR(255),\r\n"
				+ "    numero VARCHAR(255),\r\n"
				+ "    bairro VARCHAR(255),\r\n"
				+ "    cidade VARCHAR(255),\r\n"
				+ "    telefone VARCHAR(255),\r\n"
				+ "    cnpj VARCHAR(255),\r\n"
				+ "    PRIMARY KEY (id_fabricante)\r\n"
				+ ")");
		System.out.println("Criada tabela FABRICANTE!");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS estoque(\r\n"
				+ "	id_estoque INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "    nome_produto VARCHAR(255),\r\n"
				+ "    quantidade INT,\r\n"
				+ "    preco_compra DOUBLE,\r\n"
				+ "    preco_venda DOUBLE,\r\n"
				+ "    tipo_produto VARCHAR(255),\r\n"
				+ "    nome_fabricante VARCHAR(255),\r\n"
				+ "    PRIMARY KEY (id_estoque)\r\n"
				+ ")");
		System.out.println("Criada tabela ESTOQUE!");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS venda(\r\n"
				+ "	id_venda INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "    nome_cliente VARCHAR(255),\r\n"
				+ "    nome_produto VARCHAR(255),\r\n"
				+ "    quantidade INT,\r\n"
				+ "    PRIMARY KEY (id_venda)\r\n"
				+ ")");
		System.out.println("Criada tabela VENDA!");
		
		conexao.close();     
		System.out.println("FINALIZADA CONEXÃO COM O BD!");
	}  
	
}
