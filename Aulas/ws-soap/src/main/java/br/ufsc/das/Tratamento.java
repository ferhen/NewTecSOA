package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public Pedido tratarRequisicao(Map<String, String> params) {

		Pedido pedido = new Pedido();

		String quantidadeReatorArk = params.get("QRA");
		String quantidadeReatorSolar = params.get("QRS");

		String nome = params.get("nome");
		String endereco = params.get("endereco");
		String estado = params.get("estado");

		pedido.setCliente(nome);
		pedido.setEndereco(endereco);
		pedido.setEstado(estado);

		int qReatorArk = 0;
		int qReatorSolar = 0;

		int qRA = Integer.parseInt(quantidadeReatorArk);

		int qRS = Integer.parseInt(quantidadeReatorSolar);

		if (qRA > 0) {
			qReatorArk = qRA;
		}

		if (qRS > 0) {
			qReatorSolar = qRS;
		}

		// preencher beans com os itens

		pedido.setQtdReatorArk(qReatorArk);
		pedido.setQtdReatorSolar(qReatorSolar);

		return pedido;
	}
}
