package br.ufsc.das;

public class PedidoReator extends PedidoPeca {

	private static final long serialVersionUID = 1L;
	
	private int qtdReatorArk;
	private int qtdReatorSolar;

    public int getQtdReatorArk() {
        return qtdReatorArk;
    }

    public void setQtdReatorArk(int qtdReatorArk) {
        this.qtdReatorArk = qtdReatorArk;
    }
	
    public int getQtdReatorSolar() {
        return qtdReatorSolar;
    }

    public void setQtdReatorSolar(int qtdReatorSolar) {
        this.qtdReatorSolar = qtdReatorSolar;
    }
    
	/*
	@Override
	public String toString() {
		return "PedidoReatorBean [getCliente()=" + getCliente() + ", getEndereco()=" + getEndereco() + ", getEstado()=" + getEstado()
				+ ", getItens()=" + getItens() + ", getTotal()=" + getTotal() + "]";
	}
	 */	
	
	
	@Override
	public String toString() {
		return "PedidoReatorBean [getCliente()=" + getCliente() + ", getEndereco()=" + getEndereco() + ", getEstado()=" + getEstado()
				+ ", qtdReatorArk=" + qtdReatorArk
				+ ", qtdReatorSolar=" + qtdReatorSolar
				+ ", getTotal()=" + getTotal() + "]";
	}
	
	
}
