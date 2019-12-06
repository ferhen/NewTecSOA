package br.ufsc.das;

public class TratarPedidoReator {

	public PedidoReator tratarPedido(Pedido pedido) {

		PedidoReator bean = new PedidoReator();

		// setando itens iniciais
		bean.setCliente(pedido.getCliente());
		bean.setEndereco(pedido.getEndereco());
		bean.setEstado(pedido.getEstado());
		bean.setQtdReatorArk(pedido.getqtdReatorArk());
		bean.setQtdReatorSolar(pedido.getqtdReatorSolar());
		
		return bean;

	}
}
