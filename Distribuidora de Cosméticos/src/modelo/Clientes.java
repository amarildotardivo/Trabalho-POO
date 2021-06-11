package modelo;

public class Clientes {
	private String nome_cliente, CPF, nome_representante;
	private boolean cliente_ativo;
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNome_representante() {
		return nome_representante;
	}
	public void setNome_representante(String nome_representante) {
		this.nome_representante = nome_representante;
	}
	public boolean isCliente_ativo() {
		return cliente_ativo;
	}
	public void setCliente_ativo(boolean cliente_ativo) {
		this.cliente_ativo = cliente_ativo;
	}
	
	
}
