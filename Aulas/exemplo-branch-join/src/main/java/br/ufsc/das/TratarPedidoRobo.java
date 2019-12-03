package br.ufsc.das;

public class TratarPedidoRobo {

	public PedidoRobo tratarPedido(Pedido pedido) {

		PedidoRobo bean = new PedidoRobo();

		// setando itens iniciais
		bean.setCliente(pedido.getCliente());
		bean.setEndereco(pedido.getEndereco());
		bean.setEstado(pedido.getEstado());

		int qRoboDomestico = pedido.getqRoboDomestico();
		int qRoboSeguranca = pedido.getqRoboSeguranca();
		int qRoboMedico = pedido.getqRoboMedico();

		// populando a lista de itens

		bean.setItens("Robo Domestico=" + qRoboDomestico + ";" + "Robo Seguranca=" + qRoboSeguranca + ";" + "Robo Medico=" + qRoboMedico);

		return bean;
	}

}
