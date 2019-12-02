package br.ufsc.das;

public class PedidoRobo extends PedidoPeca {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "PedidoRoboBean [getCliente()=" + getCliente() + ", getEndereco()=" + getEndereco() + ", getEstado()=" + getEstado()
				+ ", getItens()=" + getItens() + ", getTotal()=" + getTotal() + "]";
	}

}
