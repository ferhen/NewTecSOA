package br.ufsc.das;

import java.util.UUID;

public class ProcessamentoVisa {

	public CartaoCredito processamento(CartaoCredito cartao) {

		System.out.println("Processando cartão Visa --> " + cartao.getNumero());

		cartao.setCodigoAutorizacao("VISA-" + UUID.randomUUID().toString());

		return cartao;
	}

}
