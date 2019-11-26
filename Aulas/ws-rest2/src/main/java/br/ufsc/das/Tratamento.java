package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public Pedido tratarRequisicao(Map<String, String> params) {

		Pedido pedido = new Pedido();

		String quantidadeRoboDomestico = params.get("QRD");

		String nome = params.get("nome");
		String endereco = params.get("endereco");
		String estado = params.get("estado");

		pedido.setCliente(nome);
		pedido.setEndereco(endereco);
		pedido.setEstado(estado);

		int qRoboDomestico = 0;

		int qRD = Integer.parseInt(quantidadeRoboDomestico);

		if (qRD > 0) {
			qRoboDomestico = qRD;
		}

		// preencher beans com os itens

		pedido.setQtdRoboDomestico(qRoboDomestico);

		return pedido;
	}
}
