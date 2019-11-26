package br.ufsc.das;

public class ImprimirPedido {

	public void receberETestar(Pedido pedido) {

		System.out
				.println("=======================BLOCO DE Saida do ESB ==================");
		System.out.println("Pedido=" + pedido.getCodigo());
		System.out.println("Cliente=" + pedido.getCliente());
		System.out.println("Endereco=" + pedido.getEndereco());
		System.out.println("Estado=" + pedido.getEstado());

		StringBuilder itensRobos = new StringBuilder();
		itensRobos.append("Robo Domestico=" + pedido.getQtdRoboDomestico());

		StringBuilder itensReator = new StringBuilder();
		itensReator.append("Reator Ark=" + pedido.getQtdReatorArk() + ";");
		itensReator.append("Gerador Solar=" + pedido.getQtdReatorSolar());

		System.out.println("Itens=" + itensRobos + " - " + itensReator);

		System.out.println("Total=" + pedido.getTotal());

	}

}
