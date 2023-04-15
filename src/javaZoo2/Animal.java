package javaZoo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public abstract class  Animal implements Comparable,Serializable{
     private float poids ;
     private int etatdesante ; // en pourcentage 
     private String nom ; // on suppose que deux animaux n'ont pas le meme nom
     private int age ; //en mois 
     
     
     
     public Animal(float p , int es ,String n , int a) {
    	 this.poids=p ;
    	 this.etatdesante=es ;
    	 this.nom=n ;
    	 this.age=a ;
    	 Zoo.ajouter(this);
    	 
     }
     public abstract void crier();
     
     public abstract void manger() ;
     public void mourir() {
    	 String filename = "RIP.txt" ;
    	 try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));//true : mode append		
			Zoo.listeMorts.put(this,new Date());
			out.writeObject(Zoo.listeMorts);
			
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 
    	 Zoo.listeAnimaux.remove(this);
    	 System.out.println(this.nom+" est mort");
     }
     
     public void avoir_faim() {
    	 this.etatdesante-=10;
    	 if(this.etatdesante <= 0) this.mourir();
    	 else if(this.etatdesante < 30) System.out.println(this.nom+" est en danger,il doit manger le plutot possible"); 
     }
     
     
     
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public int getEtatdesante() {
		return etatdesante;
	}
	public void setEtatdesante(int etatdesante) {
		this.etatdesante = etatdesante;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
     
	@Override
	public int compareTo(Object o) {
		Animal a =(Animal)o;
		return this.etatdesante-a.etatdesante;
	}
	@Override
	public String toString() {
		return this.getNom();
	}
   
     
     
}
