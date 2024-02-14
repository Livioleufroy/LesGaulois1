package personnages;
import java.security.SecureRandom;
import java.util.Random;

import Equipements.Gaulois.Potion;

public class Druide extends Gaulois {
	private Potion[] stockPotions;
    private int nombrePotions; // Pour garder une trace du nombre actuel de potions
    private Random random; // Ajout de l'objet Random

    public Druide(String nom, int force) {
        super(nom, force);
        stockPotions = new Potion[10]; // Initialisation avec une taille fixe de 10 potions max
        nombrePotions = 0;
        try {
            random = SecureRandom.getInstanceStrong();
            } catch (Exception e) {
            e.printStackTrace();
            }
    }

    public void fabriquerPotion(int quantite) {
        if (quantite + nombrePotions > stockPotions.length) {
            augmenterTailleStock(quantite + nombrePotions - stockPotions.length);
        }
        int puissance = 2 + random.nextInt(5); // Génère une puissance aléatoire entre 2 et 6
        for (int i = 0; i < quantite; i++) {
            
            stockPotions[nombrePotions++] = new Potion(puissance);
        }
        this.parler("J'ai concocté "+ quantite +" potions de puissance " + puissance);
    }
    private void augmenterTailleStock(int nombreNecessaire) {
        int nouvelleTaille = stockPotions.length + nombreNecessaire;
        Potion[] nouveauStock = new Potion[nouvelleTaille];
        for (int i = 0; i < nombrePotions; i++) {
            nouveauStock[i] = stockPotions[i];
        }
        stockPotions = nouveauStock;
    }
    public void donnerPotion(Gaulois gaulois) {
        if ("Obélix".equals(gaulois.getNom())) {
            this.parler("Non, Obélix Non !... Et tu le sais très bien !");
            return;
        }
        
        if (nombrePotions > 0) {
            Potion potion = stockPotions[0]; // Prend la première potion du stock
            System.arraycopy(stockPotions, 1, stockPotions, 0, --nombrePotions); // Décale toutes les potions
            stockPotions[nombrePotions] = null; // Décrémente le nombre de potions
            gaulois.setPuissancePotion(potion.getPuissance()); // Met à jour la puissance du Gaulois
            this.parler("donne une potion de puissance " + potion.getPuissance() + " à " + gaulois.getNom() + ".");
        } else {
            this.parler("Désolé " + gaulois.getNom() + " il n'y a plus une seule goutte de potion.");
        }
    }

    }
