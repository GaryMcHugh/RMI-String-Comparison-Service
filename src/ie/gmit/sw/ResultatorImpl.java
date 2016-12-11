package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator{
	
	//empty constructor
	protected ResultatorImpl() throws RemoteException {
	}
	
	//declare variables
	private static final long serialVersionUID = 777L;
	
	private String result;
	private boolean process = false;
	
	//return the result
	public String getResult() throws RemoteException {
		return this.result;
	}
	
	//set the result
	public void setResult(String result) throws RemoteException {
		this.result = result;	
	}
	
	//return process
	public boolean isProcessed() throws RemoteException {
		return this.process;
	}
	
	//set the process to true
	public void setProcessed() throws RemoteException {
		this.process = true;	
	}




}
