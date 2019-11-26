package br.ufsc.das;

public class LancarExcecaoCartaoNaoReconhecido {

	public void lancarExcecao(CartaoCredito cartao) {

		throw new IllegalArgumentException("Não foi possível identificar a bandeira do cartão com número " + cartao.getNumero());

	}

}
