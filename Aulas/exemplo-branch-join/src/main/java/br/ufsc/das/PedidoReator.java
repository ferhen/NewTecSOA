package br.ufsc.das;

public class PedidoReator extends PedidoPeca {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "PedidoReatorBean [getCliente()=" + getCliente() + ", getEndereco()=" + getEndereco() + ", getEstado()=" + getEstado()
				+ ", getItens()=" + getItens() + ", getTotal()=" + getTotal() + "]";
	}

}
