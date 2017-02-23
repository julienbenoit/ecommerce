package fr.adaming.metier;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Local
public interface IAdminService {

	public void ajouterAdminService(Admin a);
//	public void supprimerAdminService(Produit p);
//	public void mofifierAdminService(Produit p);
//	public List<Produit> consulterAdminService();
	
	
}
