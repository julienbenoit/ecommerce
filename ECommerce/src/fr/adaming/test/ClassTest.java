package fr.adaming.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Produit;

public class ClassTest {

	public static void main(String[] args) {
				//Etape 1: créer un objet de type entity manager factory
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECommerce");
				
				//Etape2: créer un Entity manager
				EntityManager em = emf.createEntityManager();
				
				//Etape 3: récupérer une transaction
				EntityTransaction tx = em.getTransaction();
				
				//Etape 4: ouvrir la transaction
				tx.begin();
				
				//Etape 5: générer des tables
				System.out.println("je suis dans la connexion");
				Admin admin1 = new Admin("a", "aaa", "POUNCHOU");
				System.out.println(admin1);
				Admin admin2 = new Admin("b", "bbb", "BARBISAN");
				Admin admin3 = new Admin("c", "c", "GUILLAUME");
				
//				Date date1 = new Date(1000,01,01);
//				
//				Commande com1 = new Commande(999999,date1);
//				Commande com2 = new Commande(999999,date1);
//				
//				Client cli1 = new Client(999999, "CLient1", "ssss", "ssss", "11111");
//				Client cli2 = new Client(999999, "CLient2", "ssss", "ssss", "11111");
//				Client cli3 = new Client(999999, "CLient3", "ssss", "ssss", "11111");
//				
//				Produit produit1 = new Produit(99999, "legume", "carotte", 20, 3, true); 
//				Produit produit2 = new Produit(99999, "legume", "tomate", 20, 3, false);
//				Produit produit3 = new Produit(99999, "legume", "choux", 20, 3, true);
				
//				LigneCommande lignecommande1 = new LigneCommande(produit1.getQuantite(), produit1.getPrix());
//				LigneCommande lignecommande2 = new LigneCommande(produit2.getQuantite(), produit2.getPrix());
				
				
				em.persist(admin1);
				em.persist(admin2);
				em.persist(admin3);
				
//				em.persist(com1);
//				em.persist(com2);
//
//				em.persist(cli1);
//				em.persist(cli2);
//				em.persist(cli3);
//				
//				em.persist(produit1);
//				em.persist(produit2);
//				em.persist(produit3);
				
//				em.persist(lignecommande1);
//				em.persist(lignecommande2);

				tx.commit();
				
				em.close();
				emf.close();
	}

}
