package main;

import java.util.List;
import java.util.Map;

public class Principal {
	public static void main(String[] args) {
		
		TFIDF tfidf = new TFIDF();
		
		tfidf.readFile();
		tfidf.calculate_weight();
		Map<String, List<Double>> pesos = tfidf.getWeight();
		
		System.out.println("KEY = Weight");
		for( Map.Entry<String, List<Double>> v_ : pesos.entrySet() ) {
			System.out.println(v_.getKey() + " = " + v_.getValue());
		}
		
	}
}
