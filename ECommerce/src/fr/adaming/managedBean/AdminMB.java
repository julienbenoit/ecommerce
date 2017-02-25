package fr.adaming.managedBean;



import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;
import fr.adaming.metier.IAdminService;

@ManagedBean(name="adminMB")
@SessionScoped
public class AdminMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
	
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	//------Methodes admin-----
	public String ajouter(){
		adminService.ajouterAdminTestService(this.admin);
		return "succes";
		
	}
	public String ajouterProduit(){
		adminService.ajouterAdminService(this.produit, this.categorie.getId());
		return "succes";
		
	}
	public String consulterProduit(){
	List<Produit> listeProduit=	adminService.consulterAdminService();
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
	return "/consulterProduitAdmin.xhtml";
	}
	
	
	public String supprimerProduit(){
		adminService.supprimerAdminService(this.produit);
		return "succes";
		
	}
	public String modifierProduit(){
		adminService.mofifierAdminService(this.produit);
		return "/consulterProduitAdmin.xhtml";
		
	}
	public String ajouterCategorie(){
		adminService.ajouterCategorieAdminService(this.categorie);  
		return "succes";
		
	}
	public String consulterCategorie(){
	List<Categorie> listeCategorie=	adminService.consulterCategorieAdminService();
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieList", listeCategorie);
	return "/consulterCategorieAdmin.xhtml";
	}
	
	
	
	public String supprimerCategorie(){
		adminService.supprimerCategorieAdminService(this.categorie);
		return "/consulterCategorieAdmin.xhtml";
		
	}
	public String modifierCategorie(){
		adminService.mofifierCategorieAdminService(this.categorie);
		return "/consulterCategorieAdmin.xhtml";
	}
	
	public String connecter() {
		Admin adminR = adminService.isExistService(this.admin);

		if (adminR != null) {
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agentSes", adminR);

			return "succes";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Les infos sont erronées"));
			return "echec";
		}

	}

	public String seDeconnecter() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

}



