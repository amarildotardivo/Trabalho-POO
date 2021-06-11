package modelo;

public class Estoque {
	private String nome_produto, tipo_medida, tipo_produto;
	private int peso, quantidade;
	private double preco_compra, preco_venda;
	
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	public String getTipo_medida() {
		return tipo_medida;
	}
	public void setTipo_medida(String tipo_medida) {
		this.tipo_medida = tipo_medida;
	}
	public String getTipo_produto() {
		return tipo_produto;
	}
	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
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
	
	
	
}
