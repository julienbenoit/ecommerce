package fr.adaming.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

/**
 * This class contains the methods for the handling rules of the actor Admin
 * @author POUNCHOU Julien, BARBISAN Benoit
 *
 */
@Stateless
public class AdminServiceImpl implements IAdminService{
	
	@EJB
	IAdminDao adminDao;

	/**
	 * This test method add an admin to the table admins
	 * @param Admin
	 * @return void
	 */
	@Override
	public void ajouterAdminTestService(Admin a) {
		adminDao.ajouterAdminDao(a);
		
	}
	
	/**
	 * This method add a product to the table product
	 * @param p
	 */
	@Override
	public void ajouterAdminService(Produit p, int fk_categorie) {
		adminDao.ajouterAdminDao(p,fk_categorie);
		
	}

	/**
	 * This method delete the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void supprimerAdminService(Produit p) {
		adminDao.supprimerAdminDao(p);
		
	}
	
	/**
	 * This method update the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
 	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void mofifierAdminService(Produit p) {
	adminDao.mofifierAdminDao(p);
		
	}

	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterAdminService() {
		List<Produit> listeProduit=adminDao.consulterAdminDao();
		return listeProduit;
	}

	/**
	 * This method display all of the categories
	 * @param void
	 * @return List<Categorie> 
	 */
	@Override
	public List<Categorie> consulterCategorieAdminService() {
		List<Categorie> listeCategorie=adminDao.consulterCategorieAdminDao();
		return listeCategorie;
	}

	/**
	 * This method add a new categorie to the table categorie
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void ajouterCategorieAdminService(Categorie c) {
		adminDao.ajouterCategorieAdminDao(c);
		
	}

	/**
	 * This method delete a categorie of the table categorie
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void supprimerCategorieAdminService(Categorie c) {
		adminDao.supprimerCategorieAdminDao(c);
		
	}

	/**
	 * This method update an existing categorie from the table categorie
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void mofifierCategorieAdminService(Categorie c) {
		adminDao.mofifierCategorieAdminDao(c);
		
	}
	/**
	 * This method find the existence of an admin to allow the connection
	 * @param Admin
	 * @return Admin
	 */
	@Override
	public Admin isExistService(Admin a) {
		return adminDao.isExist(a);
		 
	}



	

}
