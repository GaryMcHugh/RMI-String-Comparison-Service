package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator{
	
	protected ResultatorImpl() throws RemoteException {
	}

	private static final long serialVersionUID = 777L;
	
	private String result;
	private boolean process = false;
	
	public String getResult() throws RemoteException {
		return this.result;
	}
	
	public void setResult(String result) throws RemoteException {
		this.result = result;	
	}
	
	public boolean isProcessed() throws RemoteException {
		return this.process;
	}
	
	public void setProcessed() throws RemoteException {
		this.process = true;	
	}




}
