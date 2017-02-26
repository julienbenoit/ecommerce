package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

/**
 * This class implements the methods for the database connection of the actor Client
 * @author POUNCHOU Julien, BARBISAN benoit
 *
 */
@Stateless
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext(unitName = "ECommerce")
	EntityManager em;
	
	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Categorie> consulterCategorieClientDao() {
		String req = "SELECT c FROM Categorie c ";

		Query query = em.createQuery(req);
		List<Categorie> listeCategorie = query.getResultList();
		return listeCategorie;
	}

	/**
	 * This method get all the product from the table categorie
	 * @param c is an object Categorie (long idCategorie, String nomCategorie, String description)
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterProduitParCategorieDao(int id) {
		String req = "SELECT p FROM Produit p WHERE p.categorie_associe.id:=a ";

		Query query = em.createQuery(req);
		query.setParameter("a", id);
		List<Produit> listeProduit = query.getResultList();
		return listeProduit;
	}

	/**
	 * This method get all the products selected by the client
	 * @param void
	 * @return List<Produit> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterProduitSelectionnerDao() {
		String req = "SELECT p FROM Produit p WHERE p.selection=true ";

		Query query = em.createQuery(req);

		List<Produit> listeProduit = query.getResultList();
		return listeProduit;
	}

	/**
	 * This method allows the user to look for a product with key words research 
	 * @param cle : type String, the key word
	 * @return List<Produit> 
	 */
	@Override
	public List<Produit> consulterProduitParMotCleDao(String cle) {
		String req = "SELECT p FROM Produit p WHERE p.designation like :a or p.description like:a ";

		Query query = em.createQuery(req);
		query.setParameter("a", "%" + cle + "%");
		List<Produit> listeProduit = query.getResultList();
		return listeProduit;
	}

	/**
	 * This method add the product to the table command
	 * 
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public LigneCommande ajouterProduitPanierDao(Produit p, int quantite) {
		Produit p1=em.find(Produit.class, p.getId());

		
		LigneCommande lignecommande = new LigneCommande();
		lignecommande.setQuantite(p1.getQuantite());
		lignecommande.setPrix(p1.getPrix());
		em.persist(lignecommande);
		
		List<LigneCommande> listeLignecommande=new ArrayList<>();
		listeLignecommande.add(lignecommande);
		
	     p1.setListeLigneCommande(listeLignecommande);
		em.merge(p1); 
return lignecommande;
		
	}

	/**
	 * This method delete the product from the table command
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void supprimerProduitPanierDao(Produit p) {
		
		LigneCommande ligneCommande=em.find(LigneCommande.class, p.getId());
		em.remove(ligneCommande); 
	

	}

	/**
	 * This method saves the current commands in Panier 
	 * @param p is an object Panier, c is an object Commande
	 * @return void 
	 */
	@Override
	public Commande enregisterCommandeDao(int id_c, Client c) {
		
	em.persist(c);
	
		Commande commande = new Commande();
		commande.setClient_associe(c);
		LigneCommande ligneCommande=em.find(LigneCommande.class, id_c);
	List<LigneCommande> listeLigneCommande= new ArrayList<>();
	listeLigneCommande.add(ligneCommande);
		commande.setListeLigneCommande(listeLigneCommande);
		
		
	
		em.persist(commande);

		return commande;
	}

}
