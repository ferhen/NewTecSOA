package br.ufsc.das;

import java.io.Serializable;

public class CartaoCredito implements Serializable {

	private static final long serialVersionUID = 1L;

	public String CardNumber;
	public String CardName;
	public String ExpirationDate;
	public String TransactionValue;
	public String ReceivedValue;
	public String TransactionData;
	
//	public String getNumero() {
//		return numero;
//	}
//
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}
//
//	public String getCodigoAutorizacao() {
//		return codigoAutorizacao;
//	}
//
//	public void setCodigoAutorizacao(String codigoAutorizacao) {
//		this.codigoAutorizacao = codigoAutorizacao;
//	}

	@Override
	public String toString() {
		return "CartaoCredito [CardNumber=" + CardNumber + ", CardName=" + CardName + ", ExpirationDate=" + ExpirationDate + ", TransactionValue=" + TransactionValue + "]";
	}

}