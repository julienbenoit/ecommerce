package fr.adaming.metier;

import java.util.List;

import fr.adaming.entities.Produit;

public interface IAdminService {

	public void ajouterAdminService(Produit p);
	public void supprimerAdminService(Produit p);
	public void mofifierAdminService(Produit p);
	public List<Produit> consulterAdminService();
	
	
}
