package fr.adaming.managedBean;



import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;
import fr.adaming.metier.IAdminService;

@ManagedBean(name="adminMB")
@ViewScoped
public class AdminMB implements Serializable{
	
	private Admin admin;
	private Produit produit;
	private Commande commande;
	private Categorie categorie;
	@EJB
	private IAdminService adminService;

	public AdminMB() {
		this.admin = new Admin();
		this.produit=new Produit();
		this.commande=new Commande();
		this.categorie=new Categorie();
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
	public String ajouterProduit(){
		adminService.ajouterAdminService(this.produit);
		return "succes";
		
	}
	public String consulterProduit(){
	List<Produit> listeProduit=	adminService.consulterAdminService();
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
	return "login";
	}
	public String supprimerProduit(){
		adminService.supprimerAdminService(this.produit);
		return "succes";
		
	}
	public String modifierProduit(){
		adminService.mofifierAdminService(this.produit);
		return "succes";
		
	}
	public String ajouterCategorie(){
		adminService.ajouterCategorieAdminService(this.categorie);  
		return "succes";
		
	}
	public String consulterCategorie(){
	List<Categorie> listeCategorie=	adminService.consulterCategorieAdminService();
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeCategorie);
	return "login";
	}
	public String supprimerCategorie(){
		adminService.supprimerCategorieAdminService(this.categorie);
		return "succes";
		
	}
	public String modifierCategorie(){
		adminService.mofifierCategorieAdminService(this.categorie);
		return "succes";
		
	}
}



