package ie.gmit.sw;

import java.rmi.RemoteException;

//this is an alternative compare method that would have been used if I got the final part of the project working
public class CompareRunner implements Runnable{

	//declare variables
	private String str1;
	private String str2;
	private Resultator result;
	private String algo;
	
	//declare algorithms
	private DamerauLevenshtein damerau = new DamerauLevenshtein();
	private HammingDistance hamming = new HammingDistance();
	private Levenshtein levenshtein = new Levenshtein();
	
	//constructor
	public CompareRunner(String str1, String str2, Resultator result, String algo) {
		this.str1 = str1;
		this.str2 = str2;
		this.result = result;
		this.algo = algo;
	}
	
	//runnables run method
	public void run() {
		int distance;
		
		//determine the algorithm used
		if(algo.equalsIgnoreCase("Damerau Levenshtein")){
			//compare the strings
			distance = damerau.distance(str1, str2);
			try {
				//output the distance
				result.setResult("Damerau Levenshtein Distance: " + distance);
				//make the thread sleep
				Thread.sleep(1000);
				//call the set processed method
				result.setProcessed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(algo.equalsIgnoreCase("Hamming Distance")){
			//compare the strings
			distance = hamming.distance(str1, str2);
			try {
				//output the distance
				result.setResult("Hamming Distance: " + distance);
				//make the thread sleep
				Thread.sleep(1000);
				//call the set processed method
				result.setProcessed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(algo.equalsIgnoreCase("Levenshtein")){
			//compare the strings
			distance = levenshtein.distance(str1, str2);
			try {
					//output the distance
					result.setResult("Levenshtein Distance: " + distance);
					//make the thread sleep
					Thread.sleep(1000);
					//call the set processed method
					result.setProcessed();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
