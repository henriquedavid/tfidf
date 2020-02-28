package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.lang.*;
import java.util.Map;


public class TFIDF {
	
	Map<String, List<Integer>> tf;
	Map<String, List<Double>> weight_words;
	int qnt_docs;
	
	public TFIDF() {
		tf = new Hashtable<String, List<Integer>>();
		weight_words = new Hashtable<String, List<Double>>();
	}
	
	public void readFile() {
		try {
			File folder = new File("./res/");
			List<File> files = Arrays.asList(folder.listFiles());
			int doc_int = 0;
			qnt_docs = files.size();
			for(File f : files) {
				BufferedReader bf = new BufferedReader(new FileReader(f));
			
				String st;
			
				// Reading line by line.
				while((st = bf.readLine()) != null) {
					String [] lista = splitWord(st);
					for(String v_ : lista) {
						add(v_, doc_int);
					}
				}
				
				if(doc_int+1 < files.size())
					addColuna();
				
				doc_int++;
			}
			
			System.out.println("VALOR = QNT REP");
			for( Map.Entry<String, List<Integer>> v_ : tf.entrySet() ) {
				System.out.println(v_.getKey() + " = " + v_.getValue());
			}
			
		} catch(IOException e) {
			System.out.println("ERRO: " + e );
		}
	}
	
	private String [] splitWord(String word_) {
		String [] lista = word_.split("[ .,]");
		return lista;
	}
	
	private void add(String palavra, int doc_num) {
		if(!tf.containsKey(palavra)) {
			// A palavra não está contida no dicionário, então adiciona ela e atribui 1
			List<Integer> l = new ArrayList<Integer>();
			if(doc_num >= 1) {
				for(int i = 0; i < doc_num ; i++) {
					l.add(0);
				}
			}
			l.add(1);
			
			tf.put(palavra, l);
		}else {
			// Atualiza o valor correspondente a chave.
			List<Integer> valor_ = tf.get(palavra);
			int v = valor_.get(doc_num);
			valor_.set(doc_num, v + 1);
			
		}
	}
	
	private void addColuna() {
		for( Map.Entry<String, List<Integer>> v_ : tf.entrySet() ) {
			List<Integer> a = v_.getValue();
			a.add(0);
			tf.put(v_.getKey(), a);
		}
	}

	public void calculate_weight() {
		for( Map.Entry<String, List<Integer>> v_ : tf.entrySet() ) {
			List<Double> calculos = new ArrayList<Double>();
			double idf_ = idf(v_.getKey());
			for(Integer c_ : v_.getValue()) {
				double calculo = c_ * idf_;
				calculos.add(calculo);
			}
			weight_words.put(v_.getKey(), calculos);
		}
	}
	
	public Map<String, List<Double>> getWeight(){
		return weight_words;
	}
	
	private int qntDocTerm(String term) {
		int qnt = 0;
		List<Integer> l_ = tf.get(term);
		for(int i = 0; i < l_.size(); i++) {
			if(l_.get(i) != 0)
				qnt++;
		}
		return qnt;
	}
	
	private double idf(String key_) {
		double qnt = qntDocTerm(key_);
		double div = qnt_docs/qnt;
		return Math.log10(div);
	}
}
