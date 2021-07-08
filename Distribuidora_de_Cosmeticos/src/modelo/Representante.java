package modelo;

public class Representante extends Endereco {
	
	private int id;
	private String regiao, cpf;

	public Representante(int id, String nome, String logradouro, String numero, String bairro, String cidade, String telefone, String cpf, String regiao) {
		super(nome, logradouro, numero, bairro, cidade, telefone);
		
		this.id = id;
		this.regiao = regiao;
		this.cpf = cpf;
	}

	public Representante() {}
	
	//GETER'S AND SETTER'S
	
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
	
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
	//METODOS
	public void realizar_cadastro() {
			
	}
		
	public void deletar_cadastro() {
			
	}
	
}
