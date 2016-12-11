package ie.gmit.sw;

import java.rmi.Naming;

public class Client {
	
	//this class represents the rmi client 
	public static void main(String[] args) throws Exception{
		
		//Ask the registry running on 10.2.2.65 and listening in port 1099 for the instance of
		//the StringService object that is bound to the RMI registry with the name stringService.
		StringService stringService = (StringService) Naming.lookup("rmi://localhost:1099/stringService");
		
		//calls the compare method of String Service
		//compare the strings that were provided using the different algorithms provided
		
		stringService.compare("Distributed Systems", "Disturbed Systems", "Damerau-Levenshtein Distance");
    	stringService.compare("Distributed Systems", "Distressed Sausages", "Damerau-Levenshtein Distance");
    	
    	stringService.compare("Distributed Systems", "Distasteful Sisters", "Hamming Distance");
    	stringService.compare("Distributed Systems", "Distended Cisterns", "Hamming Distance");
    	
    	stringService.compare("Distributed Systems", "Distempered Sisyphus", "Levenshtein Distance");
    	stringService.compare("Distributed Systems", "Distilled Cistercians", "Levenshtein Distance");
    	
    	//TODO:
    	//I need to create code here in the client to remove a task from the Linked List (inQueue)
    	//process that task... keep polling until its done
    	//put the completed task in the map (the outQueue) so it can be returned to the user
    	//have this loop until all the tasks are complete
		
		
	}//end main

}
