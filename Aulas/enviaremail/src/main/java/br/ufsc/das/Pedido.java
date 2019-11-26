package br.ufsc.das;

import java.io.Serializable;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String cliente;
	private String endereco;
	private String estado;

	private String emailCliente;

	private int qtdRoboDomestico;

	private int qtdReatorArk;
	private int qtdReatorSolar;

	private float total;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	public int getQtdReatorArk() {
		return qtdReatorArk;
	}

	public void setQtdReatorArk(int qtdReatorArk) {
		this.qtdReatorArk = qtdReatorArk;
	}

	public int getQtdReatorSolar() {
		return qtdReatorSolar;
	}

	public void setQtdReatorSolar(int qtdReatorSolar) {
		this.qtdReatorSolar = qtdReatorSolar;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", cliente=" + cliente
				+ ", endereco=" + endereco + ", estado=" + estado
				+ ", emailCliente=" + emailCliente + ", qtdRoboDomestico="
				+ qtdRoboDomestico + ", qtdReatorArk=" + qtdReatorArk
				+ ", qtdReatorSolar=" + qtdReatorSolar + ", total=" + total
				+ "]";
	}

}
