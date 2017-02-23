package fr.adaming.metier;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Local
public interface IAdminService {
	/**
	 * This method add a product to the table product
	 * @param p
	 */

	public void ajouterAdminService(Produit p);
	
	/**
	 * This method delete the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	public void supprimerAdminService(Produit p);
	
	/**
	 * This method update the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
 	 * @return void : this method is an action doesn't return anything
	 */
	public void mofifierAdminService(Produit p);
	
	
	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	public List<Produit> consulterAdminService();

	
	//Methode test
	public void ajouterAdminTestService(Admin a);
	

}

