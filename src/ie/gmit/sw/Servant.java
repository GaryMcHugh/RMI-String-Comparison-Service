package ie.gmit.sw;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/* Server is responsible for creating an instance of the remote object (MessageServiceImpl)
 * and binding it to a naming server (the RMI Registry) with a human-readable name. The RMI registry
 * can be started from the command line with the "rmiregistry" command, or programmatically using:
 *			LocateRegistry.createRegistry(1099);
 * Where 1099 is the port number that the registry is listening on for incoming client requests.
 *
 * Note: When a client asks the RMI registry for an object, the registry returns an instance of the
 * remote interface - a stub (technically a remote proxy). Therefore, before starting the registry, 
 * make sure to run the rmic compiler over the remote object to create the stub:
 *				rmic gmit.MessageServiceImpl
 *
 */

public class Servant {
	public static void main(String[] args) throws Exception{
		
		//declare a remote service
		StringService stringserv = new StringServiceImpl();
		
		//run it on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry with the human-readable name "stringserv"
		Naming.rebind("stringService", stringserv);
		
		//tell the user that the server is ready
		System.out.println("The Server is Ready");
	}
}
