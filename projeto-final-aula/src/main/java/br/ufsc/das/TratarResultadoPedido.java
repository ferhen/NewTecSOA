package br.ufsc.das;

import java.util.Collection;

public class TratarResultadoPedido {

	public String tratarResultadoPedido(Pedido pedido) {

		Collection<PedidoPeca> pecas = pedido.getPecas();

		StringBuilder sb = new StringBuilder();

		sb.append("Resultado do pedido:\n\n");

		sb.append("Cliente: " + pedido.getCliente() + "\n");
		sb.append("CEP: " + pedido.getCep() + "\n");
		sb.append("Endere�o: " + pedido.getEndereco() + "\n");
		sb.append("Estado: " + pedido.getEstado() + "\n");

		sb.append("\nDetalhamento das Pe�as:\n----------------------------\n\n");

		double totalGeral = 0;

		for (PedidoPeca p : pecas) {

			if (p instanceof PedidoReator) {
				sb.append("Reator - StarkSystem\n");
				sb.append("C�digo StarkSystem: " + p.getCodigo() + "\n");
			} else if (p instanceof PedidoRobo) {
				sb.append("Reator - BrRobotics\n");
				sb.append("C�digo BrRobotics: " + p.getCodigo() + "\n");
			}
			sb.append("Cliente: " + p.getCliente() + "\n");
			sb.append("Endereco: " + p.getEndereco() + "\n");
			sb.append("Estado: " + p.getEstado() + "\n");
			sb.append("Itens: " + p.getItens() + "\n");
			sb.append("Total: " + p.getTotal() + "\n");

			sb.append("\n");

			totalGeral += p.getTotal();

		}

		sb.append("\n----------------------------\n");
		sb.append("Total Itens: " + totalGeral);
		
		sb.append("\n----------------------------\n");
		sb.append("Total Geral: " + pedido.getValorTotal());

		return sb.toString();
	}

}
