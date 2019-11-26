package br.ufsc.das;

import java.io.Serializable;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String cliente;
	private String endereco;
	private String estado;

	private int qtdRoboDomestico;

	private double total;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getQtdRoboDomestico() {
		return qtdRoboDomestico;
	}

	public void setQtdRoboDomestico(int qtdRoboDomestico) {
		this.qtdRoboDomestico = qtdRoboDomestico;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	// Feito pq provavelmente o Mule tem um "bug" que somente aceitar setters do
	// tipo string
	public void setTotal(String total) {
		this.total = Double.parseDouble(total);
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", cliente=" + cliente
				+ ", endereco=" + endereco + ", estado=" + estado
				+ ", qtdRoboDomestico=" + qtdRoboDomestico + ", total=" + total
				+ "]";
	}

}
