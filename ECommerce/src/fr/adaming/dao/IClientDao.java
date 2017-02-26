package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

/**
 * This interface implements the methods for the database connection of the actor Client
 * @author POUNCHOU Julien, BARBISAN benoit
 *
 */
@Local
public interface IClientDao {

	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	public List<Categorie> consulterCategorieClientDao();
	
	/**
	 * This method get all the product from the table categorie
	 * @param c is an object Categorie (long idCategorie, String nomCategorie, String description)
	 * @return List<Categorie> : return the list of all categories objects
	 */
	public List<Produit> consulterProduitParCategorieDao(int id);
	
	/**
	 * This method get all the products selected by the client
	 * @param void
	 * @return List<Produit> : return the list of all categories objects
	 */
	public List<Produit> consulterProduitSelectionnerDao();
	
	/**
	 * This method allows the user to look for a product with key words research 
	 * @param cle : type String, the key word
	 * @return List<Produit> 
	 */
	public List<Produit> consulterProduitParMotCleDao(String cle);
	
	/**
	 * This method add the product to the table command
	 * 
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	public void ajouterProduitPanierDao(Produit p, Panier pa);
	
	/**
	 * This method delete the product from the table command
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	public void supprimerProduitPanierDao(Produit p, Panier pa);
	
	/**
	 * This method saves the current commands in Panier 
	 * @param p is an object Panier, c is an object Commande
	 * @return void 
	 */
	public Commande enregisterCommandeDao(int id_c, Client c);
	
	
}
