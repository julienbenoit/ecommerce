package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;
@Local
public interface IAdminDao {
	public void ajouterAdminDao(Admin a);
	List<Produit> consulterAdminService();
}
