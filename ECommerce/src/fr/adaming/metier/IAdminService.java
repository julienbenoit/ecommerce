package fr.adaming.metier;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Local
public interface IAdminService {
	/**
	 * This method add a product to the table product
	 * @param p
	 */
	public void ajouterAdminService(Admin p);
//	public void supprimerAdminService(Produit p);
//	public void mofifierAdminService(Produit p);
//	public List<Produit> consulterAdminService();
	
	
}
