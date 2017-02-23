package fr.adaming.dao;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
@Local
public interface IAdminDao {
	public void ajouterAdminDao(Admin a);
}
