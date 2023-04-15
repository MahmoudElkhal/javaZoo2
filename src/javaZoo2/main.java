package javaZoo2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class main {
	static Nourriture viande= new Nourriture(100,90,"viande");
	static Nourriture banane = new Nourriture(500,60,"banane");
	public static void main(String[] args) {
		
 		
 		Tigre t= new Tigre(300,50,"PinkPanther",10,main.viande);
 		Singe s= new Singe(400,50,"macaque",30,banane);
 		t.crier();
 		s.crier();
 		
 		System.out.println(t);
 		System.out.println(s);
 		
 		Zoo.newDay();
 		
 		System.out.println("liste des animaux classes selon l'etat de sante"+Zoo.listeAnimaux);
 		System.out.println("liste des animaux classes selon le poids"+Zoo.poidsListe());
 		System.out.println("liste des morts "+Zoo.listeMorts);
 		
 		
 		System.out.println(t.getEtatdesante());
 		System.out.println(s.getEtatdesante());
		
 		Zoo.newDay();
 		
 		
		
		System.out.println(t.getEtatdesante());
 		System.out.println(s.getEtatdesante());
 		Zoo.newDay();
		
		
		
		t.manger();// on nourrit le tigre
		
		System.out.println(t.getEtatdesante());
 		System.out.println(s.getEtatdesante());
 		Zoo.newDay();
 		
 		System.out.println("liste des animaux classes selon l'etat de sante"+Zoo.listeAnimaux);
 		System.out.println("liste des animaux classes selon le poids"+Zoo.poidsListe());
 		Zoo.newDay();
 		t.manger();
 		System.out.println("liste des animaux classes selon l'etat de sante"+Zoo.listeAnimaux);
 		System.out.println("liste des animaux classes selon le poids"+Zoo.poidsListe());
 		System.out.println("liste des morts "+Zoo.listeMorts);
 		
 		t.manger();
 		t.manger();
 		t.manger();
 		t.manger();
 		t.manger();
 		t.manger();

 		
 		//voir rip.txt
 		
 		
 		/*
 		System.out.println("-----------------------------------");
 		
 		System.out.println(Zoo.listeMorts);
 		
 		chargerMorts();
 		
 		System.out.println(Zoo.listeMorts);
 		
		*/
 		
 		
 		
}
     public static void chargerMorts() {//deserialisation des animaux peris
 		try {
 			ObjectInputStream inp = new ObjectInputStream(new FileInputStream("RIP.txt"));
 			Map m =(Map)inp.readObject();
 			Zoo.listeMorts=m;
 			
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 		
 		
 		
 	}
     
     
     
    
  
	}

