package modelo;

public class Fabricante extends Endereco {
	
	private int id;
	private String cnpj;

	public Fabricante(int id, String nome, String logradouro, String numero, String bairro, String cidade, String telefone, String cnpj) {
		
		super(nome, logradouro, numero, bairro, cidade, telefone);
		
		this.id = id;
		this.cnpj = cnpj;
	}
	
	//GETER'S AND SETTER'S
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	@Override
	public String toString() {
		return getNome();
	}
	
	
}
