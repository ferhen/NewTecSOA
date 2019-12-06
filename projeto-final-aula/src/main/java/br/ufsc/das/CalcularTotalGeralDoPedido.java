package br.ufsc.das;

import java.util.Collection;

public class CalcularTotalGeralDoPedido {

	public Pedido tratarResultadoPedido(Pedido pedido) {

		Collection<PedidoPeca> pecas = pedido.getPecas();
		float totalGeral = 0;

		for (PedidoPeca p : pecas) {
			totalGeral += p.getTotal();
		}
		
		pedido.setValorTotal(totalGeral);
		return pedido;
	}
}