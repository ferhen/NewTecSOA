package calculoTaxaComissao;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;
import calculoTaxaComissao.Interfaces.RMIInterface;

public class Program extends UnicastRemoteObject implements RMIInterface 
{
	private static final long serialVersionUID = 1L;

	protected Program() throws RemoteException
	{
		super();
	}
	
	public static void main(String[] args) 
	{
		try
		{
			try 
			{
				LocateRegistry.createRegistry(11099);
			}
			catch(ExportException e)
			{
				LocateRegistry.getRegistry(11099);
			}
			Naming.rebind("//127.0.0.1:11099/comissaoService", new Program());
			System.err.println("Server ready.");
		}
		catch (Exception e)
		{
			System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
		}
	}

	@Override
	public double calcularValorComComissao(float valor) throws RemoteException {
		return 1.15 * valor;
	}
}
