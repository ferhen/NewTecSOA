package br.ufsc.das;

import java.io.Serializable;

public class CartaoCredito implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numero;

	private String codigoAutorizacao;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}

	public void setCodigoAutorizacao(String codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}

	@Override
	public String toString() {
		return "CartaoCredito [numero=" + numero + ", codigoAutorizacao=" + codigoAutorizacao + "]";
	}

}
