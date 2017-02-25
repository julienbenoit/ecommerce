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

@Stateless
public class ClientServiceImpl implements IClientService{

	@EJB
	IClientDao clientDao;
	@Override
	public void ajouterProduitPanierService(Produit p, Panier pa) {
		clientDao.ajouterProduitPanierDao(p, pa);
		
	}

	@Override
	public void supprimerProduitPanierService(Produit p, Panier pa) {
		clientDao.supprimerProduitPanierDao(p, pa);
	}

	@Override
	public List<Categorie> consulterCategorieClientService() {
	List<Categorie> listeCategorie=clientDao.consulterCategorieClientDao();
		return listeCategorie;
	}

	@Override
	public List<Produit> consulterProduitParCategorieService(int id_c) {
		List<Produit> listeProduit=clientDao.consulterProduitParCategorieDao(id_c);
		return listeProduit;
	}

	@Override
	public List<Produit> consulterProduitSelectionnerService() {
		List<Produit> listeProduit=clientDao.consulterProduitSelectionnerDao();
		return listeProduit;
	}

	@Override
	public Commande enregistrerCommandeService(int id_c, Client c) {
		Commande commande=clientDao.enregisterCommandeDao(id_c, c);
		return null;
	}

	@Override
	public List<Produit> consulterProduitParMotCleService(String cle) {
		List<Produit> listeProduit=clientDao.consulterProduitParMotCleDao(cle);
		return listeProduit;
	}

}
