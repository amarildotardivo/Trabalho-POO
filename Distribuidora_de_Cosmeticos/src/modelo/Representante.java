package modelo;

public class Representante extends Endereco {
	
	private String regiao;

	public Representante(String nome, String logradouro, String numero, String bairro, String cidade, String telefone, String regiao) {
		super(nome, logradouro, numero, bairro, cidade, telefone);
	
		this.regiao = regiao;
	}

	//GETER'S AND SETTER'S
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
