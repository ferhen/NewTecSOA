package br.ufsc.das;

public class TratarPedidoReator {

	public PedidoReator tratarPedido(Pedido pedido) {

		PedidoReator bean = new PedidoReator();

		// setando itens iniciais
		bean.setCliente(pedido.getCliente());
		bean.setEndereco(pedido.getEndereco());
		bean.setEstado(pedido.getEstado());

		int qReatorArk = pedido.getqReatorArk();
		int qReatorSolar = pedido.getqReatorSolar();

		// populando a lista de itens

		bean.setItens("Reator Ark=" + qReatorArk + ";Reator Solar=" + qReatorSolar);

		return bean;

	}
}
