package br.ufsc.das;

import java.io.Serializable;

public abstract class PedidoPeca implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String cliente;
	private String endereco;
	private String estado;
	private String itens;
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

	public String getItens() {
		return itens;
	}

	public void setItens(String itens) {
		this.itens = itens;
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

}
