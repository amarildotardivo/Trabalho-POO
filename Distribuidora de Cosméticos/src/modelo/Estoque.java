package modelo;

public class Estoque {
	private String nome_produto, tipo_produto, nome_fabricante;
	private int quantidade;
	private double preco_compra, preco_venda;
	
	public Estoque(String nome_produto, String tipo_produto, int quantidade, double preco_compra, double preco_venda, String nome_fabricante) {
		this.nome_produto = nome_produto;
		this.tipo_produto = tipo_produto;
		this.quantidade = quantidade;
		this.preco_compra = preco_compra;
		this.preco_venda = preco_venda;
		this.nome_fabricante = nome_fabricante;
	}
	
	
	//GETER'S AND SETTER'S
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	
	public String getTipo_produto() {
		return tipo_produto;
	}
	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getPreco_compra() {
		return preco_compra;
	}
	public void setPreco_compra(double preco_compra) {
		this.preco_compra = preco_compra;
	}
	
	public double getPreco_venda() {
		return preco_venda;
	}
	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}
	
	public String getNome_fabricante() {
		return nome_fabricante;
	}
	public void setNome_fabricante(String nome_fabricante) {
		this.nome_fabricante = nome_fabricante;
	}
	
	
	
	
	
	
}
