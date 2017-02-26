package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;
import fr.adaming.metier.IClientService;

/**
 * This class handle the link between ServiceClient package and the View module
 * Methods defined here have a key word String as a return used as a navigation tool
 * Methods defined here have a void as input parameters
 * @author POUNCHOU Julien, BARBISAN Benoit
 *
 */
@ManagedBean(name="clientMB")
@SessionScoped
public class ClientMB implements Serializable{
	
	
	//===================Attributs managed Bean==============================
	private Client client;// voir si besoin instantier d'autre produit
	private Produit produit;
	private Commande commande;
	private Panier panier;
	@EJB
	private IClientService clientService;

	
	//===================Constructeurs==============================
	public ClientMB() {
		this.produit=new Produit();
		this.client=new Client();
		this.commande=new Commande();
		this.panier=new Panier();
	}

	
	//===================Accesseurs==================================
	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	//===================Méthodes managed bean================================
	
	
	/**
	 * This method add the product to the table command
	 * 
	 * @param void
	 * @return String
	 */
	public String ajouterProduitPanier(){
		clientService.ajouterProduitPanierService(this.produit, this.panier);
		return "/ajouterProduitdansPanier.xhtml";
		
	}
	
	/**
	 * This method saves the current commands in Panier 
	 * @param void
	 * @return String 
	 */
	public String enregistrerCommande(){
		clientService.enregistrerCommandeService(this.commande.getId(), this.client);
		return "/enregistrerCommandeClient.xhtml";
		
	}
	
	/**
	 * This method get all the product from the table categorie
	 * @param void
	 * @return String
	 */
	public String consulterProduitParCategorie(){
	List<Produit> listeProduit=	clientService.consulterProduitParCategorieService(this.commande.getId());
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
	return "/consulterProduitParCat.xhtml";
	}
	
	/**
	 * This method allows the user to look for a product with key words research 
	 * @param void
	 * @return String 
	 */
	public String consulterProduitParMotCle(){
		List<Produit> listeProduit=	clientService.consulterProduitParMotCleService(this.produit.getDescription());
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
		return "/consulterProduitParMotCle.xhtml";
	}
	
	/**
	 * This method delete the product from the table command
	 * @param void
	 * @return String
	 */
	public String supprimerProduitPanier(){
		clientService.supprimerProduitPanierService(this.produit, this.panier);
		return "succes";
	}
	
	/**
	 * This method get all the products selected by the client
	 * @param void
	 * @return List<Produit> : return the list of all categories objects
	 */
	public String consulterProduitSelectionner(){
		List<Produit> listeProduit=	clientService.consulterProduitSelectionnerService();
			
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
	return "login";
	}
	
	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return String
	 */
	public String consulterCategorie(){
		List<Categorie> listeCategorie=	clientService.consulterCategorieClientService();
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieList", listeCategorie);
	return "/consulterCat.xhtml";
	}
}
