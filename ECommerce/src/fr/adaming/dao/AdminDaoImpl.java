package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Stateless
public class AdminDaoImpl implements IAdminDao {

	
		@PersistenceContext(unitName="ECommerce")
		EntityManager em;
		@Override
		public void ajouterAdminDao(Admin a) {
			em.persist(a);
			
		}
		@Override
		public List<Produit> consulterAdminService() {
			// TODO Auto-generated method stub
			return null;
		}

		
	}

	

