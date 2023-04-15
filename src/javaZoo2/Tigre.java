package javaZoo2;

public class Tigre extends Animal {
	 
	  static final String cri ="AAArghrgh je suis un TIIIIGREE !!" ;
	  public static Nourriture nourriture;
     
	  public Tigre(float p, int es, String n, int a,Nourriture nrt ) {
		super(p, es, n , a);
		this.nourriture=nrt ;
		
		
	}
	  public Tigre(float p, int es, String n, int a ) {
			super(p, es, n , a);
			
			
			
		}
   
	

	@Override
	public void crier() {
		System.out.println(Tigre.cri) ;
		
	}

	@Override
	public void manger() {
		int q =1+((int)(this.getPoids())/10); //cette quantite change d'un animal a un autre
		try {
			Zoo.nourrir(this.nourriture,q) ;
			System.out.println("Tigre est heureux");
			this.setEtatdesante(this.getEtatdesante()+10);
		} catch (QuantiteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("Il y a "+this.nourriture.getQuantite()+" unite de "+nourriture.getDescription());
			System.out.println("On achete la viande ...");
			try {
				Zoo.acheterNourriture(this.nourriture);
				this.manger();
			} catch (BudgetException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		}
		
	} 
	

      
}
