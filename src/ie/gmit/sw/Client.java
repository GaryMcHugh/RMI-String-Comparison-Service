package ie.gmit.sw;

import java.rmi.Naming;

public class Client {
	
	public static void main(String[] args) throws Exception{
		StringService stringService = (StringService) Naming.lookup("rmi://localhost:1099/stringService");
		
		stringService.compare("Distributed Systems", "Disturbed Systems", "Damerau-Levenshtein Distance");
    	stringService.compare("Distributed Systems", "Distressed Sausages", "Damerau-Levenshtein Distance");
    	stringService.compare("Distributed Systems", "Distasteful Sisters", "Hamming Distance");
    	stringService.compare("Distributed Systems", "Distended Cisterns", "Hamming Distance");
    	stringService.compare("Distributed Systems", "Distempered Sisyphus", "Levenshtein Distance");
    	stringService.compare("Distributed Systems", "Distilled Cistercians", "Levenshtein Distance");
		
		
	}//end main

}
