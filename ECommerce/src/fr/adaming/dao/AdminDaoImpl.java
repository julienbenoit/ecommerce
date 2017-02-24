package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateless
public class AdminDaoImpl implements IAdminDao {

	@PersistenceContext(unitName = "ECommerce")
	EntityManager em;

	@Override
	public void ajouterAdminDao(Admin a) {
		em.persist(a);

	}

	@Override
	public List<Produit> consulterAdminDao() {
		String req = "SELECT p FROM Produit p ";

		Query query = em.createQuery(req);
		List<Produit> listeProduit = query.getResultList();
		return listeProduit;
	}

	@Override
	public void ajouterAdminDao(Produit p) {
		em.persist(p);

	}

	@Override
	public void supprimerAdminDao(Produit p) {
		Produit p1 = em.find(Produit.class, p.getId());
		em.remove(p);

	}

	@Override
	public void mofifierAdminDao(Produit p) {

		em.persist(p);

	}

	@Override
	public List<Categorie> consulterCategorieAdminDao() {
		String req = "SELECT c FROM Categorie c ";
		Query query = em.createQuery(req);
		List<Categorie> listeCategorie = query.getResultList();
		return listeCategorie;
	}

	@Override
	public void ajouterCategorieAdminDao(Categorie c) {
		em.persist(c);

	}

	@Override
	public void supprimerCategorieAdminDao(Categorie c) {
		Categorie c1 = em.find(Categorie.class, c.getId());
		em.remove(c1);

	}

	@Override
	public void mofifierCategorieAdminDao(Categorie c) {
		em.persist(c);

	}

}
