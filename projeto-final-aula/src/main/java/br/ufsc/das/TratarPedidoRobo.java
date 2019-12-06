package br.ufsc.das;

public class TratarPedidoRobo {

	public PedidoRobo tratarPedido(Pedido pedido) {

		PedidoRobo bean = new PedidoRobo();

		// setando itens iniciais
		bean.setCliente(pedido.getCliente());
		bean.setEndereco(pedido.getEndereco());
		bean.setEstado(pedido.getEstado());
		
		bean.setQtdRoboDomestico(pedido.getqtdRoboDomestico());
		bean.setQtdRoboMedico(pedido.getqtdRoboMedico());
		bean.setQtdRoboSeguranca(pedido.getqtdRoboSeguranca());

		bean.setItens("Robo Domestico=" + pedido.getqtdRoboDomestico() + ";" + "Robo Seguranca=" + pedido.getqtdRoboSeguranca() + ";" + "Robo Medico=" + pedido.getqtdRoboMedico());

		return bean;
	}

}
