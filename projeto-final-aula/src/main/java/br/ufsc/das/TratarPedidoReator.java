package br.ufsc.das;

public class TratarPedidoReator {

	public PedidoReator tratarPedido(Pedido pedido) {

		PedidoReator bean = new PedidoReator();

		// setando itens iniciais
		bean.setCliente(pedido.getCliente());
		bean.setEndereco(pedido.getEndereco());
		bean.setEstado(pedido.getEstado());

		int qtdReatorArk = pedido.getqtdReatorArk();
		int qtdReatorSolar = pedido.getqtdReatorSolar();

		// populando a lista de itens

		bean.setItens("Reator Ark=" + qtdReatorArk + ";Reator Solar=" + qtdReatorSolar);

		return bean;

	}
}
