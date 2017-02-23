package fr.adaming.managedBean;



import java.io.Serializable;





import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.entities.Admin;
import fr.adaming.metier.IAdminService;

@ManagedBean(name="adminMB")
@ViewScoped
public class AdminMB implements Serializable{
	
	private Admin admin;
	@EJB
	private IAdminService adminService;

	public AdminMB() {
		this.admin = new Admin();
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
//------Methodes admin-----
	public String ajouter(){
		adminService.ajouterAdminTestService(this.admin);
		return "succes";
		
	}
}



