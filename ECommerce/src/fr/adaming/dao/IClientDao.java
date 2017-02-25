package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;
@Local
public interface IClientDao {

	public List<Categorie> consulterCategorieClientDao();
	public List<Produit> consulterProduitParCategorieDao(int id);
	public List<Produit> consulterProduitSelectionnerDao();
	public List<Produit> consulterProduitParMotCleDao(String cle);
	public void ajouterProduitPanierDao(Produit p, Panier pa);
	public void supprimerProduitPanierDao(Produit p, Panier pa);
	public Commande enregisterCommandeDao(int id_c, Client c);
	
	
}
