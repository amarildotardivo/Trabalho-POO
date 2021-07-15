package modelo;

public class Venda {
	
	private String nome_cliente, nome_produto;
	private int id, quantidade;
	private double preco_unitario, total;
	
	public Venda(int id, String nome_cliente, String nome_produto, int quantidade, double preco_unitario, double total) {
		this.id = id;
		this.nome_cliente = nome_cliente;
		this.nome_produto = nome_produto;
		this.quantidade = quantidade;
		this.setPreco_unitario(preco_unitario);
		this.setTotal(total);
	}
	
	public Venda() {}
	
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

	public double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
		
	
}
