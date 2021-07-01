package modelo;

public class Venda {
	
	private String nome_cliente, nome_produto;
	private int id, quantidade;
	
	public Venda(int id, String nome_cliente, String nome_produto, int quantidade) {
		this.id = id;
		this.nome_cliente = nome_cliente;
		this.nome_produto = nome_produto;
		this.quantidade = quantidade;
	}
	
	
	//GETER'S AND SETTER'S
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
		
	
}
