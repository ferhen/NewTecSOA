package br.ufsc.das;

public class PedidoRobo extends PedidoPeca {

	private static final long serialVersionUID = 1L;
	
	/*
	private int qtdRoboDomestico;
    private int qtdRoboMedico;
    private int qtdRoboSeguranca;
    
	
    public int getQtdRoboDomestico() {
		return qtdRoboDomestico;
	}

	public void setQtdRoboDomestico(int qtdRoboDomestico) {
		this.qtdRoboDomestico = qtdRoboDomestico;
	}

    public int getQtdRoboMedico() {
        return qtdRoboMedico;
    }

    public void setQtdRoboMedico(int qtdRoboMedico) {
        this.qtdRoboMedico = qtdRoboMedico;
    }

    public int getQtdRoboSeguranca() {
        return qtdRoboSeguranca;
    }

    public void setQtdRoboSeguranca(int qtdRoboSeguranca) {
        this.qtdRoboSeguranca = qtdRoboSeguranca;
    }
    */
	
    
	@Override
	public String toString() {
		return "PedidoRoboBean [getCliente()=" + getCliente() + ", getEndereco()=" + getEndereco() + ", getEstado()=" + getEstado()
				+ ", getItens()=" + getItens() + ", getTotal()=" + getTotal() + "]";
	}
	
    
	/*
    @Override
	public String toString() {
		return "PedidoRoboBean [getCliente()=" + getCliente() + ", getEndereco()=" + getEndereco() + ", getEstado()=" + getEstado()
				+ ", qRoboDomestico=" + qtdRoboDomestico
				+ ", qRoboSeguranca=" + qtdRoboSeguranca 
				+ ", qRoboMedico="+ qtdRoboMedico 
				+ ", getTotal()=" + getTotal() + "]";
	}
	*/
}
