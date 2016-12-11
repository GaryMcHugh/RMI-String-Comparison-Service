package ie.gmit.sw;

import java.rmi.RemoteException;

//this is the compare method used to compare the strings and output a distance
public class Compare {
	//declare variables
	private String s;
	private String t;
	private String algo;
	private Resultator result;
	
	//declare the algorithms
	private DamerauLevenshtein damerau = new DamerauLevenshtein();
	private HammingDistance hamming = new HammingDistance();
	private Levenshtein levenshtein = new Levenshtein();

	//constructor
	public Compare(String s, String t, String algo, Resultator result){
		this.s = s;
		this.t = t;
		this.algo = algo;
		this.result = result;
		
		//call the init method
		init();
	}
	
	private void init(){
		int distance;
		
		//determine which algorithm is being used
		switch (algo) {
			case "Damerau-Levenshtein Distance":
				//compare the strings
				distance=damerau.distance(s, t);
				
				try {
					//set the result
					result.setResult("Damerau Levenshtein Distance: " + distance);
					//call the set processed method
					result.setProcessed();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
				
			case "Hamming Distance":
				//compare the strings
				distance=hamming.distance(s, t);
				try {
					//set the result
					result.setResult("Hamming Distance: " + distance);
					//call the set processed method
					result.setProcessed();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
	
			case "Levenshtein Distance":
				//compare the strings
				distance=levenshtein.distance(s, t);
				try {
					//set the result
					result.setResult("Levenshtein Distance: " + distance);
					//call the set processed method
					result.setProcessed();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
		}
	}
}
