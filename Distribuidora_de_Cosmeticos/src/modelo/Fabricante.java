package modelo;

public class Fabricante extends Endereco {
	
	private String cnpj;

	public Fabricante(String nome, String logradouro, String numero, String bairro, String cidade, String telefone, String cnpj) {
		
		super(nome, logradouro, numero, bairro, cidade, telefone);

		this.cnpj = cnpj;
	}
	
	//GETER'S AND SETTER'S
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	//METODOS
	public void realizar_cadastro() {
		
	}
	
	public void deletar_cadastro() {
		
	}
	
	
}
