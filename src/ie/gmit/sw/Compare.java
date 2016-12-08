package ie.gmit.sw;

import java.rmi.RemoteException;

public class Compare {
	private String s;
	private String t;
	private String algo;
	private Resultator result;
	
	private DamerauLevenshtein damerau = new DamerauLevenshtein();
	private HammingDistance hamming = new HammingDistance();
	private Levenshtein levenshtein = new Levenshtein();

	public Compare(String s, String t, String algo, Resultator result){
		this.s = s;
		this.t = t;
		this.algo = algo;
		this.result = result;
		
		init();
	}
	
	private void init(){
		int distance;
		
		switch (algo) {
			case "Damerau-Levenshtein Distance":
				distance=damerau.distance(s, t);
				
				try {
					result.setResult("Distance is: "+distance);
					result.setProcessed();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
				
			case "Hamming Distance":
				distance=hamming.distance(s, t);
				try {
					result.setResult("Distance is: "+distance);
					result.setProcessed();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
	
			case "Levenshtein Distance":
				distance=levenshtein.distance(s, t);
				try {
					result.setResult("Distance is: "+distance);
					result.setProcessed();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
		}
	}
}
