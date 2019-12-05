package br.ufsc.das;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String cliente;
	private String endereco;
	private String estado;

	private String cep;

	private int qtdRoboDomestico;
	private int qtdRoboSeguranca;
	private int qtdRoboMedico;
	private int qtdReatorArk;
	private int qtdReatorSolar;

	private Collection<PedidoPeca> pecas = new ArrayList<>();

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

	public int getqtdRoboDomestico() {
		return qtdRoboDomestico;
	}

	public void setqtdRoboDomestico(int qRoboDomestico) {
		this.qtdRoboDomestico = qRoboDomestico;
	}

	public int getqtdRoboSeguranca() {
		return qtdRoboSeguranca;
	}

	public void setqtdRoboSeguranca(int qRoboSeguranca) {
		this.qtdRoboSeguranca = qRoboSeguranca;
	}

	public int getqtdRoboMedico() {
		return qtdRoboMedico;
	}

	public void setqtdRoboMedico(int qRoboMedico) {
		this.qtdRoboMedico = qRoboMedico;
	}

	public int getqtdReatorArk() {
		return qtdReatorArk;
	}

	public void setqtdReatorArk(int qReatorArk) {
		this.qtdReatorArk = qReatorArk;
	}

	public int getqtdReatorSolar() {
		return qtdReatorSolar;
	}

	public void setqtdReatorSolar(int qReatorSolar) {
		this.qtdReatorSolar = qReatorSolar;
	}

	public Collection<PedidoPeca> getPecas() {
		return pecas;
	}

	public void setPecas(Collection<PedidoPeca> pecas) {
		this.pecas = pecas;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", cliente=" + cliente
				+ ", endereco=" + endereco + ", estado=" + estado + ", cep="
				+ cep + ", qRoboDomestico=" + qtdRoboDomestico
				+ ", qRoboSeguranca=" + qtdRoboSeguranca + ", qRoboMedico="
				+ qtdRoboMedico + ", qReatorArk=" + qtdReatorArk
				+ ", qReatorSolar=" + qtdReatorSolar + "]";
	}

}
