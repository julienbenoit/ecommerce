package fr.adaming.metier;

import java.util.List;

import fr.adaming.entities.Produit;

public interface IAdminService {
	/**
	 * This method add a product to the table product
	 * @param p
	 */
	public void ajouterAdminService(Produit p);
	public void supprimerAdminService(Produit p);
	public void mofifierAdminService(Produit p);
	public List<Produit> consulterAdminService();
	
	
}
