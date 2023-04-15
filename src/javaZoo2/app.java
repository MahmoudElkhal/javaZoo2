

package javaZoo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class app extends Application {
	
	public void start(Stage fenetre) {
		
		GridPane racine = new GridPane();
		racine.setPadding(new Insets(50,50,50,50));
		ListView<String> ListAnimaux = new ListView<String>();
		ObservableList<String> a = FXCollections.observableArrayList();
		for(Animal animal :Zoo.listeAnimaux) {
			String alerte =(animal.getEtatdesante()<30) ? "    risque de mourir" : " ";
			a.add(animal.getNom()+alerte+"");
		}
		
		ListAnimaux.getItems().addAll(a);
		GridPane Formulaire = new GridPane();
		Label typel=new Label("Type : ");
		Label noml=new Label("Nom : ");
		Label agel=new Label("Age : ");
		Label poidsl=new Label("Poids : ");
		Label etatsantel=new Label("Etat de santé  : ");
		TextField type =new TextField();
		TextField nom =new TextField();
		TextField age =new TextField();
		TextField poids =new TextField();
		TextField etatsante =new TextField();
		Button ajouterAnimal = new Button("Ajouter l'animal");
	
		ajouterAnimal.addEventHandler(MouseEvent.MOUSE_PRESSED,new EventHandler(){
	
	  public void handle(Event evt) {
			if(type.getText().equals("tigre")) {
				Tigre tigre = new Tigre(Integer.valueOf(poids.getText()),Integer.valueOf(etatsante.getText()),nom.getText(),Integer.valueOf(age.getText()),main.viande);
				a.add(tigre.getNom());
				
				try {
					
					Connection cnx =connexion();
					Statement st = cnx.createStatement();
				    String requete = "insert into Animal values('"+nom.getText()+"','"+type.getText()+"',"+poids.getText()+","+etatsante.getText()+","+age.getText()+",'"+Tigre.cri+"');";
				    
				    st.executeUpdate(requete);
				}
				
				
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(type.getText().equals("singe")) {
				Singe singe = new Singe(Integer.valueOf(poids.getText()),Integer.valueOf(etatsante.getText()),nom.getText(),Integer.valueOf(age.getText()),main.banane);
				a.add(singe.getNom());
				try {
					Connection cnx = connexion();
					Statement st = cnx.createStatement();
				    String requete = "insert  into Animal values('"+nom.getText()+"','"+type.getText()+"',"+poids.getText()+","+etatsante.getText()+","+age.getText()+",'"+Singe.cri+"');";
				    st.executeUpdate(requete);
				}
				
				
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			ListAnimaux.getItems().clear();
			ListAnimaux.getItems().addAll(a);
			
		}

});
		Button newDay = new Button("New Day");
		newDay.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler(){

			@Override
			public void handle(Event event) {
			
				Zoo.newDay();
				
				ListAnimaux.getItems().clear();
				a.clear();
				for(Animal animal :Zoo.listeAnimaux) {
					String alerte =(animal.getEtatdesante()<30) ? "     risque de mourir" : " ";
					a.add(animal.getNom()+alerte);
				}
		
				ListAnimaux.getItems().addAll(a);
				

				
			}
			
		});
		Button save = new Button("save");
		save.setOnMouseClicked(evt->{
			
			try {
				Connection cnx =connexion();;
				Statement st = cnx.createStatement();
				String rqt = "delete from Animal ;" ;
				System.out.println(rqt);
				st.execute(rqt);
				for(Animal animal : Zoo.listeAnimaux) {
					if(animal instanceof Tigre) {
						String rqt1 ="insert into Animal values('"+animal.getNom()+"', 'tigre'"+","+animal.getPoids()+","+animal.getEtatdesante()+","+animal.getAge()+",'"+Tigre.cri +"');";
						System.out.println(rqt1);
						st.execute(rqt1);
					}
					if(animal instanceof Singe) {
						String rqt1 ="insert into Animal values('"+animal.getNom()+"', 'singe'"+","+animal.getPoids()+","+animal.getEtatdesante()+","+animal.getAge()+",'"+Singe.cri +"');";
						st.execute(rqt1);
					}
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		});
		Formulaire.add(noml, 0, 0);
		Formulaire.add(nom,1,0);
		Formulaire.add(typel,0,1);
		Formulaire.add(type,1,1);
		Formulaire.add(agel,0,2);
		Formulaire.add(age,1,2);
		Formulaire.add(poidsl,0,3);
		Formulaire.add(poids,1,3);
		Formulaire.add(etatsantel,0,4);
		Formulaire.add(etatsante,1,4);
	    Formulaire.setPadding(new Insets(50,50,50,50));
		Formulaire.setVgap(15);
		Formulaire.setHgap(20);
		racine.add(ListAnimaux, 0, 0);
		racine.add(Formulaire, 1, 0);
		racine.add(ajouterAnimal, 2, 1);
		racine.add(newDay, 0, 1);
		racine.add(save, 1, 1);
		racine.setHgap(20);
		racine.setVgap(30);
		
		Scene sc = new Scene(racine);
	
		fenetre.setScene(sc);
		
		
		fenetre.show();
		
	}

	public static void main(String[] args) {
		animalfromdb();
		
		
		app.launch();
		
		
      // t.mourir();
      // t1.mourir() ;
		
		
		//Singe s = new Singe(1000,50,"Ilyass",11);
		
		//Nourriture viande= new Nourriture(1000,90);
		
		/*
		t.crier();
		System.out.println(Zoo.listeAnimaux);
		Nourriture n= new Nourriture("viande",100,200);
		
		t.manger();
		System.out.println(t.getEtatdesante());
		Zoo.newDay();
		System.out.println(t.getEtatdesante());
		Zoo.newDay();
		System.out.println(t.getEtatdesante());
		Zoo.newDay();
		System.out.println(t.getEtatdesante());
		Zoo.newDay();
		
		System.out.println(Zoo.listeAnimaux);
		
		
		
		
		
		System.out.println(Zoo.listeNourriture);
		*/
		
		
		
		
	}
	public static Connection connexion() throws SQLException {
	   	  String url ="jdbc:mysql://localhost:3306/javazoo" ;
	   	  
	   	  Connection cnx = DriverManager.getConnection(url,"root","root") ;
	   	  return cnx ;
	   	  
	     }
	     public static void animalfromdb() {
	    	 try {
				Connection cnx =connexion();
				Statement st = cnx.createStatement();
				String requete = "select * from Animal ";
				ResultSet rst = st.executeQuery(requete);
				while(rst.next()) {
					if(rst.getString("type_animal").equals("tigre")) {
					   Tigre tigre = new Tigre(rst.getInt("poids"),rst.getInt("etatsante"),rst.getString("nom"),rst.getInt("age"),main.viande);
					   
				       
				}
					if(rst.getString("type_animal").equals("singe")) {
						   Singe singe= new Singe(rst.getInt("poids"),rst.getInt("etatsante"),rst.getString("nom"),rst.getInt("age"),main.banane);
					       
					}
				}
			} 
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }

}
