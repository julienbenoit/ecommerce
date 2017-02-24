package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
@Local
public interface IAdminDao {
	public void ajouterAdminDao(Admin a);
	public List<Produit> consulterAdminDao();
	public void ajouterAdminDao(Produit p);
	public void supprimerAdminDao(Produit p);
	public void mofifierAdminDao(Produit p);
	public List<Categorie> consulterCategorieAdminDao();
	public void ajouterCategorieAdminDao(Categorie c);
	public void supprimerCategorieAdminDao(Categorie c);
	public void mofifierCategorieAdminDao(Categorie c);
	
}
