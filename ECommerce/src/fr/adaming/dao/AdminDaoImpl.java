package fr.adaming.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

/**
 * This class contains the methods for the database relation of the actor Admin
 * @author POUNCHOU Julien, BARBISAN Benoit
 *
 */
@Stateless
public class AdminDaoImpl implements IAdminDao {

	@PersistenceContext(unitName = "ECommerce")
	EntityManager em;

	/**
	 * This test method add an admin to the table admins
	 * @param Admin
	 * @return void
	 */
	@Override
	public void ajouterAdminDao(Admin a) {
		em.persist(a);

	}
	
	/**
	 * This method get all the products from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterAdminDao() {
		String req = "SELECT p FROM Produit p ";
		Query query = em.createQuery(req);
		List<Produit> listeProduit = query.getResultList();
		return listeProduit;
	}

	/**
	 * This method add a product to the table product
	 * @param Produit, Int (foreign key of a categorie)
	 */
	@Override
	public void ajouterAdminDao(Produit p1, int fk_categorie) {
		Categorie c = em.find(Categorie.class, fk_categorie);
		p1.setCategorie_associe(c);
		em.persist(p1);

	}

	/**
	 * This method delete the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void supprimerAdminDao(Produit p2) {
		Produit p3 = em.find(Produit.class, p2.getId());
			em.remove(p3);
			}
	
	/**
	 * This method update the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
 	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void mofifierAdminDao(Produit p4) {
		em.merge(p4);

	}

	/**
	 * This method display all of the categories
	 * @param void
	 * @return List<Categorie> 
	 */
	@Override
	public List<Categorie> consulterCategorieAdminDao() {
		String req = "SELECT c FROM Categorie c ";
		Query query = em.createQuery(req);
		List<Categorie> listeCategorie = query.getResultList();
		return listeCategorie;
	}

	/**
	 * This method add a new categorie to the table categorie
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void ajouterCategorieAdminDao(Categorie c) {
		em.persist(c);

	}
	
	/**
	 * This method delete a categorie of the table categorie
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void supprimerCategorieAdminDao(Categorie c) {
		Categorie c1 = em.find(Categorie.class, c.getId());
		em.remove(c1);

	}

	/**
	 * This method update an existing categorie from the table categorie
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void mofifierCategorieAdminDao(Categorie c) {
		em.merge(c);

	}

	/**
	 * This method find the existence of an admin to allow the connection
	 * @param Admin
	 * @return Admin
	 */
	@Override
	public Admin isExist(Admin a) {

		String req = "SELECT a FROM Admin a WHERE a.nom=:pNom AND a.password=:pMdp";
		Query query = em.createQuery(req);
		query.setParameter("pNom", a.getNom());
		query.setParameter("pMdp", a.getPassword());
	
		List<Admin> listeAdmin = query.getResultList();
		if (listeAdmin.size() != 0) {
			Admin adminRetour = listeAdmin.get(0);
			return adminRetour;

		} else {
			return null;
		}
	
	}



}
