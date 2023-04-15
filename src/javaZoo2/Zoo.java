package javaZoo2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Zoo{
	
     static List<Animal> listeAnimaux = new ArrayList<>() ;
     static List<Nourriture> listeNourriture =new ArrayList<>() ;
     static Map<Animal,Date> listeMorts = new HashMap<>();
     
     static int budget=10000 ; 
     
    
      
     
     public static void ajouterAnimal( Animal a) {
    	 Zoo.listeAnimaux.add(a) ;
     }
     public static void ajouterNourriture( Nourriture n) {
    	 Zoo.listeNourriture.add(n) ;
     }
     
     public static void nourrir( Nourriture n ,int quantite) throws QuantiteException{
       
 		
 		 if( n.getQuantite()-quantite<0) throw new QuantiteException() ;
 		 
 		  n.setQuantite(n.getQuantite()-quantite);
 		
 	 


 }
 
     public static void acheterNourriture(Nourriture n) throws BudgetException {// on achète par lot de 100
    	 
    	 if(Zoo.budget<n.getPrix()*100) throw new BudgetException() ;
    	 Zoo.budget-=n.getPrix()*100 ;
    	 n.setQuantite(n.getQuantite()+100);
    
     }
    
     public static void newDay() {
    	 ArrayList<Animal> copie = new ArrayList(Zoo.listeAnimaux);
    	 for(Animal a : copie) {
    		 a.avoir_faim();
    	 }
    	 Collections.sort(listeAnimaux);
     }
     
     public static List poidsListe() {
    	 List<Animal> l2 = new ArrayList<>(Zoo.listeAnimaux);
    	 Collections.sort(l2, new poidsComparator());
    	 return l2;
     }
     
     public static <T> void ajouter(T something) {//something peut etre un animal comme peut etre une nourriture
    	 if( something instanceof Animal)Zoo.ajouterAnimal((Animal)something);
    	 else if(something instanceof Nourriture)Zoo.ajouterNourriture((Nourriture)something);
    	 
     }
     
}


     
