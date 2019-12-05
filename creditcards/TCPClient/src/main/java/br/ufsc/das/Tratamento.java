package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public CartaoCredito tratarFormulario(Map<String, String> params) {

		CartaoCredito cartao = new CartaoCredito();

		cartao.CardNumber = params.get("CardNumber");
		cartao.CardName = params.get("CardName");
		cartao.ExpirationDate = params.get("ExpirationDate");
		cartao.TransactionValue = params.get("TransactionValue");

		return cartao;
	}

}