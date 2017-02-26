package fr.adaming.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

/**
 * This class implements the methods for the handling rules of the actor Client
 * @author POUNCHOU Julien, BARBISAN benoit
 *
 */
@Stateless
public class ClientServiceImpl implements IClientService{

	@EJB
	IClientDao clientDao;
	
	/**
	 * This method add the product to the table command
	 * 
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void ajouterProduitPanierService(Produit p, Panier pa) {
		clientDao.ajouterProduitPanierDao(p, pa);
		
	}
	
	/**
	 * This method delete the product from the table command
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void supprimerProduitPanierService(Produit p, Panier pa) {
		clientDao.supprimerProduitPanierDao(p, pa);
	}

	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Categorie> consulterCategorieClientService() {
	List<Categorie> listeCategorie=clientDao.consulterCategorieClientDao();
		return listeCategorie;
	}

	/**
	 * This method get all the product from the table categorie
	 * @param c is an object Categorie (long idCategorie, String nomCategorie, String description)
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterProduitParCategorieService(int id_c) {
		List<Produit> listeProduit=clientDao.consulterProduitParCategorieDao(id_c);
		return listeProduit;
	}

	/**
	 * This method get all the products selected by the client
	 * @param void
	 * @return List<Produit> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterProduitSelectionnerService() {
		List<Produit> listeProduit=clientDao.consulterProduitSelectionnerDao();
		return listeProduit;
	}

	/**
	 * This method saves the current commands in Panier 
	 * @param p is an object Panier, c is an object Commande
	 * @return void 
	 */
	@Override
	public Commande enregistrerCommandeService(int id_c, Client c) {
		Commande commande=clientDao.enregisterCommandeDao(id_c, c);
		return null;
	}

	/**
	 * This method allows the user to look for a product with key words research 
	 * @param cle : type String, the key word
	 * @return List<Produit> 
	 */
	@Override
	public List<Produit> consulterProduitParMotCleService(String cle) {
		List<Produit> listeProduit=clientDao.consulterProduitParMotCleDao(cle);
		return listeProduit;
	}

}
