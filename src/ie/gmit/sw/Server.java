package ie.gmit.sw;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) throws Exception{
		
		StringService stringserv = new StringServiceImpl();
		
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("stringService", stringserv);
		
		System.out.println("The Server is Ready");
	}
}
