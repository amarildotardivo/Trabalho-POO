package persistencia;

import java.sql.SQLException;
import java.sql.Statement;

public class CriarBD {
	
	public void criarBD()throws SQLException {
		
		ConexaoBD conexao = new ConexaoBD();

		Statement stmt = conexao.conectarBD().createStatement();
		System.out.println("Realizada conexão com o BD!");
		
		stmt.execute("CREATE DATABASE IF NOT EXISTS distribuidora_cosmeticos");
		System.out.println("Criado BD da Distribuidora!");
		
		stmt.execute("USE distribuidora_cosmeticos");
		System.out.println("Utilizando BD da Distribuidora...");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS representante(\r\n"
				+ "    id int KEY AUTO_INCREMENT,\r\n"
				+ "    nome VARCHAR(255),\r\n"
				+ "    logradouro VARCHAR(255),\r\n"
				+ "    numero VARCHAR(255),\r\n"
				+ "    bairro VARCHAR(255),\r\n"
				+ "    cidade VARCHAR(255),\r\n"
				+ "    telefone VARCHAR(255),\r\n"
				+ "    cpf VARCHAR(255),\r\n"
				+ "    regiao VARCHAR(255)\r\n"
				+ ");");
		System.out.println("Criada tabela REPRESENTANTE!");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS cliente(\r\n"
				+ "    id int KEY AUTO_INCREMENT,\r\n"
				+ "    nome VARCHAR(255),\r\n"
				+ "    logradouro VARCHAR(255),\r\n"
				+ "    numero VARCHAR(255),\r\n"
				+ "    bairro VARCHAR(255),\r\n"
				+ "    cidade VARCHAR(255),\r\n"
				+ "    telefone VARCHAR(255),\r\n"
				+ "    cpf VARCHAR(255),\r\n"
				+ "    nome_representante VARCHAR(255)\r\n"
				+ ");");
		System.out.println("Criada tabela CLIENTE!");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS fabricante(\r\n"
				+ "	   id int KEY AUTO_INCREMENT,\r\n"
				+ "    nome VARCHAR(255),\r\n"
				+ "    logradouro VARCHAR(255),\r\n"
				+ "    numero VARCHAR(255),\r\n"
				+ "    bairro VARCHAR(255),\r\n"
				+ "    cidade VARCHAR(255),\r\n"
				+ "    telefone VARCHAR(255),\r\n"
				+ "    cnpj VARCHAR(255)\r\n"
				+ ");");
		System.out.println("Criada tabela FABRICANTE!");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS estoque(\r\n"
				+ "    id int KEY AUTO_INCREMENT,\r\n"
				+ "    nome_produto VARCHAR(255),\r\n"
				+ "    quantidade INT,\r\n"
				+ "    preco_compra DOUBLE,\r\n"
				+ "    preco_venda DOUBLE,\r\n"
				+ "    tipo_produto VARCHAR(255),\r\n"
				+ "    nome_fabricante VARCHAR(255)\r\n"
				+ ");");
		System.out.println("Criada tabela ESTOQUE!");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS venda(\r\n"
				+ "    id int KEY AUTO_INCREMENT,\r\n"
				+ "    nome_cliente VARCHAR(255),\r\n"
				+ "    nome_produto VARCHAR(255),\r\n"
				+ "    quantidade INT,\r\n"
				+ "    preco_unitario DOUBLE,\r\n"
				+ "    total DOUBLE \r\n"
				+");");
		System.out.println("Criada tabela VENDA!");
		
		conexao.fecharConexaoBD();
		System.out.println("FINALIZADA CONEXÃO COM O BD!");
	}
}
