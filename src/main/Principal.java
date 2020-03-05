package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Principal {
	public static void main(String[] args) {
		
		TFIDF tfidf = new TFIDF();
		
		tfidf.readFile();
		tfidf.calculate_weight();
		Map<String, List<Double>> pesos = tfidf.getWeight();
		
		
		try {
			FileWriter out = new FileWriter("output.txt");
			for( Map.Entry<String, List<Double>> v_ : pesos.entrySet() ) {
				out.write(v_.getKey() + " = " + v_.getValue() + "\n");
				//System.out.println(v_.getKey() + " = " + v_.getValue());
			}
			out.close();
			System.out.println("Finished!");
		} catch(IOException e) {
			System.out.println("Ops! An error!");
			e.printStackTrace();
		}
		
	}
}
