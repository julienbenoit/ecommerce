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

@Stateless
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext(unitName = "ECommerce")
	EntityManager em;
	
	
	@Override
	public List<Categorie> consulterCategorieClientDao() {
		String req = "SELECT c FROM Categorie c ";

		Query query = em.createQuery(req);
		List<Categorie> listeCategorie = query.getResultList();
		return listeCategorie;
	}

	@Override
	public List<Produit> consulterProduitParCategorieDao(int id) {
		String req = "SELECT p FROM Produit p WHERE p.categorie_associe.id:=a ";

		Query query = em.createQuery(req);
		query.setParameter("a", id);
		List<Produit> listeProduit = query.getResultList();
		return listeProduit;
	}

	@Override
	public List<Produit> consulterProduitSelectionnerDao() {
		String req = "SELECT p FROM Produit p WHERE p.selection=true ";

		Query query = em.createQuery(req);

		List<Produit> listeProduit = query.getResultList();
		return listeProduit;
	}

	@Override
	public List<Produit> consulterProduitParMotCleDao(String cle) {
		String req = "SELECT p FROM Produit p WHERE p.designation like :a or p.description like:a ";

		Query query = em.createQuery(req);
		query.setParameter("a", "%" + cle + "%");
		List<Produit> listeProduit = query.getResultList();
		return listeProduit;
	}

	@Override
	public void ajouterProduitPanierDao(Produit p, Panier pa) {
		Produit p1=em.find(Produit.class, p.getId());

		
		LigneCommande lignecommande = new LigneCommande();
		lignecommande.setQuantite(p1.getQuantite());
		lignecommande.setPrix(p1.getPrix());
		em.persist(lignecommande);
		
		List<LigneCommande> listeLignecommande=new ArrayList<>();
		listeLignecommande.add(lignecommande);
	
		
	p1.setListeLigneCommande(listeLignecommande);

	

		em.merge(p1); 

		
	}

	@Override
	public void supprimerProduitPanierDao(Produit p, Panier pa) {
		
		LigneCommande ligneCommande=em.find(LigneCommande.class, p.getId());
		em.persist(ligneCommande); 
	

	}

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
