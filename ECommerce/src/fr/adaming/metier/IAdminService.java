package fr.adaming.metier;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

/**
 * This interface implements the methods for the handling rules of the actor Admin
 * @author POUNCHOU Julien, BARBISAN Benoit
 *
 */
@Local
public interface IAdminService {
	
	/**
	 * This method add a product to the table product
	 * @param Produit, Int (foreign key of a categorie)
	 * @return void
	 */
	public void ajouterAdminService(Produit p, int fk_categorie);
	
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
	 * This method get all the products from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	public List<Produit> consulterAdminService();

	/**
	 * This method display all of the categories
	 * @param void
	 * @return List<Categorie> 
	 */
	List<Categorie> consulterCategorieAdminService();
	
	
	/**
	 * This method add a new categorie to the table categorie
	 * @param Categorie
	 * @return void
	 */
	public void ajouterCategorieAdminService(Categorie c);
	
	
	/**
	 * This method delete a categorie of the table categorie
	 * @param Categorie
	 * @return void
	 */
	public void supprimerCategorieAdminService(Categorie c);
	
	
	/**
	 * This method update an existing categorie from the table categorie
	 * @param Categorie
	 * @return void
	 */
	public void mofifierCategorieAdminService(Categorie c);
	
	
	/**
	 * This method find the existence of an admin to allow the connection
	 * @param Admin
	 * @return Admin
	 */
	public Admin isExistService(Admin a);
	
	/**
	 * This test method add an admin to the table admins
	 * @param Admin
	 * @return void
	 */
	public void ajouterAdminTestService(Admin a);
	

}

