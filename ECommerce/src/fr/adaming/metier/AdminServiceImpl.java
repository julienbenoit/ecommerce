package fr.adaming.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;


@Stateless
public class AdminServiceImpl implements IAdminService{
	
	@EJB
	IAdminDao adminDao;

	@Override
	public void ajouterAdminTestService(Admin a) {
		adminDao.ajouterAdminDao(a);
		
	}
	
	@Override
	public void ajouterAdminService(Produit p, int fk_categorie) {
		adminDao.ajouterAdminDao(p,fk_categorie);
		
	}

	@Override
	public void supprimerAdminService(Produit p) {
		adminDao.supprimerAdminDao(p);
		
	}

	@Override
	public void mofifierAdminService(Produit p) {
	adminDao.mofifierAdminDao(p);
		
	}

	@Override
	public List<Produit> consulterAdminService() {
		List<Produit> listeProduit=adminDao.consulterAdminDao();
		return listeProduit;
	}

	@Override
	public List<Categorie> consulterCategorieAdminService() {
		List<Categorie> listeCategorie=adminDao.consulterCategorieAdminDao();
		return listeCategorie;
	}

	@Override
	public void ajouterCategorieAdminService(Categorie c) {
		adminDao.ajouterCategorieAdminDao(c);
		
	}

	@Override
	public void supprimerCategorieAdminService(Categorie c) {
		adminDao.supprimerCategorieAdminDao(c);
		
	}

	@Override
	public void mofifierCategorieAdminService(Categorie c) {
		adminDao.mofifierCategorieAdminDao(c);
		
	}

	@Override
	public Admin isExistService(Admin a) {
		return adminDao.isExist(a);
		 
	}



	

}
