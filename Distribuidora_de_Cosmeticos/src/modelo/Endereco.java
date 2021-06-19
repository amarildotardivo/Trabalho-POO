package modelo;

public abstract class Endereco {
	
	protected String nome, logradouro, numero, bairro, cidade, telefone;
	
	public Endereco(String nome, String logradouro, String numero, String bairro, String cidade, String telefone) {
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.telefone = telefone;
	}

	//GETER'S AND SETTER'S
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//METODOS ABSTRATOS
	public abstract void realizar_cadastro();
	public abstract void deletar_cadastro();
	
}
