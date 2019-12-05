package br.ufsc.das;

import java.util.Random;

public class SimulacaoInvocacaoStarkSystem {

	public PedidoReator invocarServico(PedidoReator p) {

		// Simulando que vamos invocar o WS da StarkSystem (nao usar essa classe no trabalho)
		p.setTotal(100 + new Random().nextInt(500));
		p.setCodigo(String.valueOf(1 + new Random().nextInt(30)));

		return p;

	}

}
