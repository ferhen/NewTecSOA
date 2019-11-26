package br.ufsc.das;

public class MontaCorpoMensagem {

	public String corpoMensagem(Pedido pedido) {

		String itensRobos = "Robo Domestico=" + pedido.getQtdRoboDomestico();
		String itensReator = "Reator Ark=" + pedido.getQtdReatorArk()
				+ ";Reator Solar=" + pedido.getQtdReatorSolar();

		StringBuilder sb = new StringBuilder();

		sb.append("Compra Efetuada com sucesso - Dados da Compra \n");
		sb.append("\nCodigo da compra: " + pedido.getCodigo());
		sb.append("\nCliente: " + pedido.getCliente());
		sb.append("\nEndereco: " + pedido.getEndereco());
		sb.append("\nEstado: " + pedido.getEstado());
		sb.append("\nItens comprados: ");

		sb.append("\n\tRobos: " + itensRobos);
		sb.append("\n\tReatores: " + itensReator);

		return sb.toString();

	}

}
