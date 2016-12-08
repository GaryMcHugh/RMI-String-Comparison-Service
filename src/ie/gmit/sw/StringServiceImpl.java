package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringServiceImpl extends UnicastRemoteObject implements StringService{
	
	private static final long serialVersionUID = 777L;
	
	private Resultator res;
	
	protected StringServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public Resultator compare(String s, String t, String algo) throws RemoteException {
		res = new ResultatorImpl();
		
        Compare ss = new Compare(s, t, algo, res);

        System.out.println(res.getResult());
		
		return res;
	}



}
