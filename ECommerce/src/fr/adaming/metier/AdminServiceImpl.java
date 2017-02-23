package fr.adaming.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;


@Stateless
public class AdminServiceImpl implements IAdminService{
	
	@EJB
	IAdminDao adminDao;

	@Override
	public void ajouterAdminService(Admin a) {
		adminDao.ajouterAdminDao(a);
		
	}

	@Override
	public void supprimerAdminService(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mofifierAdminService(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produit> consulterAdminService() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
