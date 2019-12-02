package br.ufsc.das;

import java.util.Random;

public class SimulacaoInvocacaoBrRobotics {

	public PedidoRobo invocarServico(PedidoRobo p) {

		// Simulando que vamos invocar o WS da BrRobotics (nao usar essa classe no trabalho)
		p.setTotal(100 + new Random().nextInt(200));
		p.setCodigo(String.valueOf(1 + new Random().nextInt(50)));

		return p;

	}

}
