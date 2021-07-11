package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.ClienteDB;
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
			
			//FECHA O COMANDO STMT E A CONEXÃO
			stmt.close();
			conectar.fecharConexaoBD();
			System.out.println("Conexão Encerrada Com Sucesso!!!");
		}
		catch (SQLException ex) {
			System.err.println("Erro na conexão do BD: "+ex.getMessage());
		}
		catch (Exception ex) {
			System.err.println("Erro geral: "+ex.getMessage());
		}
	}

	public ArrayList<Representante> listar_representantes() {
			
		RepresentanteBD repBD = new RepresentanteBD();
		ArrayList<Representante> listaRep = repBD.listarRepresentantes();
		
		return listaRep;
	}
	
	public boolean editar_cliente() {
		try {
			
			//REALIZA A CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();	
			System.out.println("Conexão Realizada Com Sucesso!!!");												
				
				//CRIA A STRING SQL
				String querySQL = "UPDATE distribuidora_cosmeticos.cliente SET `nome` = ?, `logradouro` = ?, "
						+ "`numero` = ?, `bairro` = ?, `cidade` = ?, `telefone` = ?, `cpf` = ?, `nome_representante` = ? "
						+ " WHERE id = ?";
				
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
				stmt.setInt(9, getId());
				
				//EXECUTA A QUERY NO BANCO DE DADOS
				int rowsAffected = stmt.executeUpdate();
				System.out.println("Atualizado: "+ rowsAffected+" linha(s)");
				System.out.println("Cliente Editado com Sucesso!!!");
				
				//FECHA O COMANDO STMT E A CONEXÃO
				stmt.close();
				conectar.fecharConexaoBD();
				System.out.println("Conexão Encerrada Com Sucesso!!!");
				
				return true;

		}
		catch (SQLException ex) {
			System.err.println("Erro na conexão do BD: "+ex.getMessage());
		}
		catch (Exception ex) {
			System.err.println("Erro geral: "+ex.getMessage());
		}
		
		return false;
	}
	
	public boolean deletar_cadastro(Cliente c) {
		ClienteDB cbd = new ClienteDB();
		boolean v = cbd.DeletarCliente(c);
		return v;
	}
	
	public ArrayList<Cliente> listar_clientes() {
			
		ClienteDB clienteBD = new ClienteDB();
		
		//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
		ArrayList<Cliente> listaClientes = clienteBD.listarClientes();
		
		return listaClientes;
	}
}
