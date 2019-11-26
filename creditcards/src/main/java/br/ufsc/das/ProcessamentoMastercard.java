package br.ufsc.das;

import java.util.UUID;

public class ProcessamentoMastercard {

	public CartaoCredito processamento(CartaoCredito cartao) {

		System.out.println("Processando cartão Mastercard --> " + cartao.getNumero());

		cartao.setCodigoAutorizacao("MASTERCARD-" + UUID.randomUUID().toString());

		return cartao;
	}

}
