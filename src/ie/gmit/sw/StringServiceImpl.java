package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringServiceImpl extends UnicastRemoteObject implements StringService{
	
	private static final long serialVersionUID = 777L;
	
	private Resultator res;
	
	//default constructor
	protected StringServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//implementation of the compare method
	public Resultator compare(String s, String t, String algo) throws RemoteException {
		//create a new instance of ResultatorImpl
		res = new ResultatorImpl();
		
		//create an instance of compare and compare the strings using the algorithm and put the result in res
        Compare ss = new Compare(s, t, algo, res);
        
        //get the result
        System.out.println(res.getResult());
		
        //return the result
		return res;
	}



}
