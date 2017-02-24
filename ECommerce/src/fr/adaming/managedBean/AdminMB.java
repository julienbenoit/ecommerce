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
	private static final long serialVersionUID = 1L;
	
	private Admin admin;
	private Produit produit;
	private Commande commande;
	private Categorie categorie;
//	private List<Categorie> listeCategorie;
//	private List<Produit> listeProduit;
	
	@EJB
	private IAdminService adminService;

	public AdminMB() {
		this.admin = new Admin();
		this.produit=new Produit();
		this.commande=new Commande();
		this.categorie=new Categorie();
//		this.listeProduit = adminService.consulterAdminService();
//		this.listeCategorie = adminService.consulterCategorieAdminService();
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
	public void ajouterProduit(){
		adminService.ajouterAdminService(this.produit, this.categorie.getId());
//		return "succes";
		
	}
	public String consulterProduit(){
	List<Produit> listeProduit=	adminService.consulterAdminService();
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
	return "login";
	}
	
	
//	public List<Categorie> getListeCategorie() {
//		return listeCategorie;
//	}
//
//	public void setListeCategorie(List<Categorie> listeCategorie) {
//		this.listeCategorie = listeCategorie;
//	}
//
//	public List<Produit> getListeProduit() {
//		return listeProduit;
//	}
//
//	public void setListeProduit(List<Produit> listeProduit) {
//		this.listeProduit = listeProduit;
//	}

	public void supprimerProduit(){
		adminService.supprimerAdminService(this.produit);
//		return "succes";
		
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



