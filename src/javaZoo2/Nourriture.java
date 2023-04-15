package javaZoo2;

public class Nourriture {
	String description ;
    int quantite ; 
    int prix ; // pour une unité
    
    Nourriture(int q , int p , String s){
    	this.description=s ;
    	this.quantite=q ;
    	this.prix=p ;
    	Zoo.ajouter(this);
    }
    

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPrix() {
		return prix;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return this.description;
	}
	

    
    
    
}
