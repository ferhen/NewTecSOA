package br.ufsc.das;

public class TratarPedidoRobo {

	public PedidoRobo tratarPedido(Pedido pedido) {

		PedidoRobo bean = new PedidoRobo();

		// setando itens iniciais
		bean.setCliente(pedido.getCliente());
		bean.setEndereco(pedido.getEndereco());
		bean.setEstado(pedido.getEstado());

		int qtdRoboDomestico = pedido.getqtdRoboDomestico();
		int qtdRoboSeguranca = pedido.getqtdRoboSeguranca();
		int qtdRoboMedico = pedido.getqtdRoboMedico();

		// populando a lista de itens

		bean.setItens("Robo Domestico=" + qtdRoboDomestico + ";" + "Robo Seguranca=" + qtdRoboSeguranca + ";" + "Robo Medico=" + qtdRoboMedico);

		return bean;
	}

}
