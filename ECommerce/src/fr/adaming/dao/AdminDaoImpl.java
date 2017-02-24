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
	public void ajouterAdminDao(Produit p1, int fk_categorie) {
		Categorie c = em.find(Categorie.class, fk_categorie);
		p1.setCategorie_associe(c);
		em.persist(p1);

	}

	@Override
	public void supprimerAdminDao(Produit p2) {
		Produit p3 = em.find(Produit.class, p2.getId());
			em.remove(p3);
			}
	
	@Override
	public void mofifierAdminDao(Produit p4) {
		em.merge(p4);

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
		em.merge(c);

	}

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
