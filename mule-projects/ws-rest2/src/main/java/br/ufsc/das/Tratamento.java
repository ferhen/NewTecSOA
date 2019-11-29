package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public Pedido tratarRequisicao(Map<String, String> params) {

		Pedido pedido = new Pedido();

		String quantidadeRoboDomestico = params.get("QRD");
		String quantidadeRoboMedico = params.get("QRM");
		String quantidadeRoboSeguranca = params.get("QRS");

		String nome = params.get("nome");
		String endereco = params.get("endereco");
		String estado = params.get("estado");

		pedido.setCliente(nome);
		pedido.setEndereco(endereco);
		pedido.setEstado(estado);

		int qRoboDomestico = 0;
		int qRoboMedico = 0;
		int qRoboSeguranca = 0;

		int qRD = Integer.parseInt(quantidadeRoboDomestico);
		int qRM = Integer.parseInt(quantidadeRoboMedico);
		int qRS = Integer.parseInt(quantidadeRoboSeguranca);

		if (qRD > 0) {
			qRoboDomestico = qRD;
		}
		
		if (qRM > 0) {
			qRoboMedico = qRM;
		}
		
		if (qRS > 0) {
			qRoboSeguranca = qRS;
		}

		// preencher beans com os itens

		pedido.setQtdRoboDomestico(qRoboDomestico);
		pedido.setQtdRoboMedico(qRoboMedico);
		pedido.setQtdRoboSeguranca(qRoboSeguranca);

		return pedido;
	}
}
