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

/**
 * This class handle the link between ServiceAdmin package and the view module
 * Methods defined here have a key word String as a return used as a navigation tool
 * Methods defined here have a void as input parameters
 * @author POUNCHOU Julien, BARBISAN Benoit
 *
 */
@ManagedBean(name="adminMB")
@SessionScoped
public class AdminMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//===================Attributs managed Bean==============================
	private Admin admin;
	private Produit produit;
	private Commande commande;
	private Categorie categorie;

	
	@EJB
	private IAdminService adminService;

	//===================Constructeurs==============================
	public AdminMB() {
		this.admin = new Admin();
		this.produit=new Produit();
		this.commande=new Commande();
		this.categorie=new Categorie();

	}

	//===================Accesseurs==================================
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

	
	//===================Méthodes managed bean================================
	
	
	/**
	 * This test method add an admin to the table admins
	 * @param void
	 * @return void
	 */
	public String ajouter(){
		adminService.ajouterAdminTestService(this.admin);
		return "succes";
		
	}
	
	/**
	 * This method add a product to the table product
	 * @param void
	 * @return String
	 */
	public String ajouterProduit(){
		adminService.ajouterAdminService(this.produit, this.categorie.getId());
		return "succes";
		
	}
	
	
	/**
	 * This method get all the products from the table product
	 * @param void
	 * @return String
	 */
	public String consulterProduit(){
	List<Produit> listeProduit=	adminService.consulterAdminService();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
	return "/consulterProduitAdmin.xhtml";
	}
	
	/**
	 * This method delete the product from the table product
	 * @param void
	 * @return String
	 */
	public String supprimerProduit(){
		adminService.supprimerAdminService(this.produit);
		return "succes";
		
	}
	
	/**
	 * This method update the product from the table product
	 * @param void
 	 * @return String
	 */
	public String modifierProduit(){
		adminService.mofifierAdminService(this.produit);
		return "/consulterProduitAdmin.xhtml";
		
	}
	
	/**
	 * This method add a new categorie to the table categorie
	 * @param void
	 * @return String
	 */
	public String ajouterCategorie(){
		adminService.ajouterCategorieAdminService(this.categorie);  
		return "succes";
		
	}
	
	
	/**
	 * This method display all of the categories
	 * @param void
	 * @return String
	 */
	public String consulterCategorie(){
	List<Categorie> listeCategorie=	adminService.consulterCategorieAdminService();
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieList", listeCategorie);
	return "/consulterCategorieAdmin.xhtml";
	}
	
	
	/**
	 * This method delete a categorie of the table categorie
	 * @param void
	 * @return String
	 */
	public String supprimerCategorie(){
		adminService.supprimerCategorieAdminService(this.categorie);
		return "/consulterCategorieAdmin.xhtml";
		
	}
	
	/**
	 * This method update an existing categorie from the table categorie
	 * @param void
	 * @return String
	 */
	public String modifierCategorie(){
		adminService.mofifierCategorieAdminService(this.categorie);
		return "/consulterCategorieAdmin.xhtml";
	}
	
	/**
	 * This method create an admin session if enabled
	 * @param void
	 * @return String
	 */
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

	/**
	 * This method shuts down the current admin session
	 * @param void
	 * @return String
	 */
	public String seDeconnecter() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

}



