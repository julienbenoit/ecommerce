package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.entities.Admin;

@Stateless
public class AdminDaoImpl implements IAdminDao {

	
		@PersistenceContext(unitName="ECommerce")
		EntityManager em;
		@Override
		public void ajouterAdminDao(Admin a) {
			em.persist(a);
			
		}
		
	}

	

