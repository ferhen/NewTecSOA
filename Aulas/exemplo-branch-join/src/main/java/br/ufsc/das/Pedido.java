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

	private int qRoboDomestico;
	private int qRoboSeguranca;
	private int qRoboMedico;
	private int qReatorArk;
	private int qReatorSolar;

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

	public int getqRoboDomestico() {
		return qRoboDomestico;
	}

	public void setqRoboDomestico(int qRoboDomestico) {
		this.qRoboDomestico = qRoboDomestico;
	}

	public int getqRoboSeguranca() {
		return qRoboSeguranca;
	}

	public void setqRoboSeguranca(int qRoboSeguranca) {
		this.qRoboSeguranca = qRoboSeguranca;
	}

	public int getqRoboMedico() {
		return qRoboMedico;
	}

	public void setqRoboMedico(int qRoboMedico) {
		this.qRoboMedico = qRoboMedico;
	}

	public int getqReatorArk() {
		return qReatorArk;
	}

	public void setqReatorArk(int qReatorArk) {
		this.qReatorArk = qReatorArk;
	}

	public int getqReatorSolar() {
		return qReatorSolar;
	}

	public void setqReatorSolar(int qReatorSolar) {
		this.qReatorSolar = qReatorSolar;
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
				+ cep + ", qRoboDomestico=" + qRoboDomestico
				+ ", qRoboSeguranca=" + qRoboSeguranca + ", qRoboMedico="
				+ qRoboMedico + ", qReatorArk=" + qReatorArk
				+ ", qReatorSolar=" + qReatorSolar + "]";
	}

}
