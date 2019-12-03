package calculoTaxaComissao.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote 
{
	public double calcularValorComComissao(float valor) throws RemoteException;
}
