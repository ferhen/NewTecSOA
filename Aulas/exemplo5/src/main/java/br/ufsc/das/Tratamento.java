package br.ufsc.das;

import java.util.Map;
import java.util.Random;

public class Tratamento {

	public Pedido tratarRequisicao(Map<String, String> params) {

		Pedido pedido = new Pedido();

		String quantidadeRoboDomesticoArk = params.get("QRDRA");
		String quantidadeRoboDomesticoSolar = params.get("QRDRS");

		String nome = params.get("nome");
		String endereco = params.get("endereco");
		String estado = params.get("estado");

		// Criando um numero randomico para o codigo do pedido (so para
		// testes...)
		//pedido.setCodigo(1 + new Random().nextInt(100));

		pedido.setCliente(nome);
		pedido.setEndereco(endereco);
		pedido.setEstado(estado);

		// tratamento dos itens
		// adiciona os itens
		// qRDAK - quantidade de robos(R) domesticos(D) reator ArK
		// qRDSL - quantidade de (R)obos (D)omesticos reator (S)o(L)ar

		int qReatorArk = 0;
		int qReatorSolar = 0;
		int qRoboDomestico = 0;

		int qRDAK = Integer.parseInt(quantidadeRoboDomesticoArk); // transforma
																	// para
																	// integer a
																	// string
																	// que tem a
																	// quantidade
																	// de robos
																	// pedidos

		int qRDSL = Integer.parseInt(quantidadeRoboDomesticoSolar);

		if (qRDAK > 0) {
			// se maior que um significa que existem pedidos para esse item ....
			// cada robo do tipo Robo Domestico com reatro Ark precisa de um
			// pedido para uma carcaca de robo e outro pedido para o reator
			// correspondente...

			qReatorArk = qRDAK;
			qRoboDomestico = qRDAK;
		}

		if (qRDSL > 0) {

			qRoboDomestico = qRoboDomestico + qRDSL;
			qReatorSolar = qRDSL;
		}

		// preencher beans com os itens

		pedido.setQtdRoboDomestico(qRoboDomestico);
		pedido.setQtdReatorArk(qReatorArk);
		pedido.setQtdReatorSolar(qReatorSolar);

		pedido.setTotal(100 + new Random().nextInt(1000)); // valor aleatorio só
		// para constar...

		return pedido;
	}
}
