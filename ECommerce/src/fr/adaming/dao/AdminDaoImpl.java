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
	public void ajouterAdminDao(Produit p, int fk_categorie) {
		Categorie c = em.find(Categorie.class, fk_categorie);
		p.setCategorie_associe(c);
		em.persist(p);

	}

	@Override
	public void supprimerAdminDao(Produit p) {
		Produit p1 = em.find(Produit.class, 2);
		Categorie c=em.find(Categorie.class, 1);
		p1.setCategorie_associe(c);
		System.out.println("kjjjjjjjjjjjj" + p1);
		try {
			em.remove(p1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("coucou");
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
