package sites;

import personnages.Gaulois;
import personnages.Soldat;


public class Village {
	private Gaulois chef;
	private Gaulois[] villageois = new Gaulois[4];
	public int nbVillageois = 0;
	
	public Village(Gaulois chef) {
		this.chef = chef;
	}
	
	public boolean ajouterVillageois(Gaulois nouveauVoisin) {
		
		if (nbVillageois < villageois.length) {	
		villageois[nbVillageois] = nouveauVoisin;
		nbVillageois++;
		System.out.println("Le " + chef.donnerAuteur() + chef.nom + " : \" Bienvenue " + nouveauVoisin.nom + "! \" ");
		return true;
		}
		System.out.println("Le " + chef.donnerAuteur() + chef.nom + " : \" Désolé "+ nouveauVoisin.nom + " mon village est deja bien rempli.\""); 
		 
		return false;
	}
	
	public void afficherVillageois() {
		System.out.println("Le village de " + chef.nom + " est habité par : "); 
		for (int i=0 ; i<nbVillageois; i++) {
			if (this.villageois[i] != null ) {
				System.out.println("- " + villageois[i].nom); 
			}
		}
		}
	
	
	public void changerChef( Gaulois chef) {
		System.out.println("Le " + this.chef.donnerAuteur() +" "+ this.chef.nom + " : \" Je laisse mon grand bouclier au grand " + chef.nom + "\"."); 
		System.out.println("Le " + chef.donnerAuteur()+ " "+ chef.nom + " : \"Merci ! \""); 
		this.chef = chef ; 
	}
	
	public Gaulois getchef() {
		return chef;
	}
}
