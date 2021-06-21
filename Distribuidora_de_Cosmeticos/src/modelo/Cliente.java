package modelo;

public class Cliente extends Endereco{
	
	private String cpf, nome_representante;
			
	public Cliente(String nome, String logradouro, String numero, String bairro, String cidade, String telefone, String cpf, String nome_representante) {
		super(nome, logradouro, numero, bairro, cidade, telefone);
		
		this.cpf = cpf;
		this.nome_representante = nome_representante;
	}
	
	
	//GETTER'S AND SETTER'S
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
		
	}

	public void deletar_cadastro() {
		
	}
}
