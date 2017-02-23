package fr.adaming.metier;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

public interface IClientService {
	/**
	 * This method add the product to the table product
	 * 
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	public void ajouterProduitService(Produit p);
	
	/**
	 * This method delete the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	public void supprimerProduitService(Produit p);
	
	/**
	 * This method update the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
 	 * @return void : this method is an action doesn't return anything
	 */
	public void mofifierProduitService(Produit p);
	
	
	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	public List<Categorie> consulterCategorieService();
	
	/**
	 * This method get all the categories from the table product
	 * @param c is an object Categorie (long idCategorie, String nomCategorie, String description)
	 * @return List<Categorie> : return the list of all categories objects
	 */
	public List<Produit> consulterProduitService(Categorie c);
	
	/**
	 * This method get all the products selected by the client
	 * @param void
	 * @return List<Produit> : return the list of all categories objects
	 */
	public List<Produit> consulterProduitSelectService();
	
	
	/**
	 * This method saves the current commands in Panier 
	 * @param p is an object Panier, c is an object Commande
	 * @return void 
	 */
	public void enregistrerClientService(Panier p,Commande c);
}
