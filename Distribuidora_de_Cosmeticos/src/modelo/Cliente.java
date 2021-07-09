package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import apresentacao.TelaErro;
import apresentacao.TelaInformacao;
import persistencia.ConexaoBD;
import persistencia.RepresentanteBD;

public class Cliente extends Endereco{
	
	private int id;
	private String cpf, nome_representante;
			
	public Cliente(int id, String nome, String logradouro, String numero, String bairro, String cidade, String telefone, String cpf, String nome_representante) {
		super(nome, logradouro, numero, bairro, cidade, telefone);
		
		this.id = id;
		this.cpf = cpf;
		this.nome_representante = nome_representante;
	}
	
	public Cliente() {}
	
	//GETTER'S AND SETTER'S
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome_representante() {
		return nome_representante;
	}
	public void setNome_representante(String nome_representante) {
		this.nome_representante = nome_representante;
	}
	
	//METODOS
	public void realizar_cadastro() {
		
		try {
			
			//REALIZA A CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();	
			System.out.println("Conexão Realizada Com Sucesso!!!");
			
			//CRIA A STRING SQL
			String querySQL = "INSERT INTO distribuidora_cosmeticos.cliente (nome, logradouro, numero, bairro, cidade, telefone, cpf, nome_representante) "
					+ "VALUES(?,?,?,?,?,?,?,?)";
			
			//CRIA O COMANDO SQL
			PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
			
			//SETA OS VALORES NA STRING querySQL
			stmt.setString(1, getNome());
			stmt.setString(2, getLogradouro());
			stmt.setString(3, getNumero());
			stmt.setString(4, getBairro());
			stmt.setString(5, getCidade());
			stmt.setString(6, getTelefone());
			stmt.setString(7, getCpf());
			stmt.setString(8, getNome_representante());
			
			
			//EXECUTA A QUERY NO BANCO DE DADOS
			stmt.executeUpdate();
			System.out.println("Cliente Cadastrado com Sucesso!!!");
			
			//Popup de Informação
			TelaInformacao tInformacao = new TelaInformacao("Cliente: " + getNome(), "Salvo com Sucesso!");
			tInformacao.setVisible(true);
			
			//FECHA O COMANDO STMT E A CONEXÃO
			stmt.close();
			conectar.fecharConexaoBD();
			System.out.println("Conexão Encerrada Com Sucesso!!!");
		}
		catch (SQLException ex) {
			System.err.println("Erro na conexão do BD: "+ex.getMessage());
			//Popup de Erro
			TelaErro tErro = new TelaErro("Error de Banco de Dados: " + ex);
			tErro.setVisible(true);
		}
		catch (Exception ex) {
			System.err.println("Erro geral: "+ex.getMessage());
			//Popup de Erro
			TelaErro tErro = new TelaErro("Error: " + ex);
			tErro.setVisible(true);
		}
	}

	public ArrayList<Representante> listar_representantes() {
		try {
			
			//REALIZA A CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();	
			System.out.println("Conexão Realizada Com Sucesso!!!");
			
			RepresentanteBD repBD = new RepresentanteBD();
			ArrayList<Representante> listaRep = repBD.listarRepresentantes();
			
			//FECHA A CONEXÃO
			conectar.fecharConexaoBD();
			System.out.println("Conexão Encerrada Com Sucesso!!!");
			
			return listaRep;
		}
		catch (SQLException ex) {
			System.err.println("Erro na conexão do BD: "+ex.getMessage());
			//Popup de Erro
			TelaErro tErro = new TelaErro("Error de Banco de Dados: " + ex);
			tErro.setVisible(true);
		}
		catch (Exception ex) {
			System.err.println("Erro geral: "+ex.getMessage());
			//Popup de Erro
			TelaErro tErro = new TelaErro("Error: " + ex);
			tErro.setVisible(true);
		}
		
		return null;
	}
	
	public void deletar_cadastro() {
		
	}
	
}
