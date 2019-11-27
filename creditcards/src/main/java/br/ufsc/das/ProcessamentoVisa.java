package br.ufsc.das;

import java.util.UUID;

public class ProcessamentoVisa {

	public String processamento(CartaoCredito cartao) {

		System.out.println("Processando cartão Visa --> " + cartao.getNumero());

		cartao.setCodigoAutorizacao("VISA-" + UUID.randomUUID().toString());

		return "teste";
	}

}
