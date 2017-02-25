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

@ManagedBean(name="clientMB")
@SessionScoped
public class ClientMB implements Serializable{
	
	private Client client;// voir si besoin instantier d'autre produit
	private Produit produit;
	private Commande commande;
	private Panier panier;
	@EJB
	private IClientService clientService;

	public ClientMB() {
		this.produit=new Produit();
		this.client=new Client();
		this.commande=new Commande();
		this.panier=new Panier();
	}

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

		//------Methodes Client-----
		public String ajouterProduitPanier(){
			clientService.ajouterProduitPanierService(this.produit, this.panier);
			return "/ajouterProduitdansPanier.xhtml";
			
		}
		
		public String enregistrerCommande(){
			clientService.enregistrerCommandeService(this.commande.getId(), this.client);
			return "/enregistrerCommandeClient.xhtml";
			
		}
		
		
		public String consulterProduitParCategorie(){
		List<Produit> listeProduit=	clientService.consulterProduitParCategorieService(this.commande.getId());
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
		return "/consulterProduitParCat.xhtml";
		}
		
		public String consulterProduitParMotCle(){
			List<Produit> listeProduit=	clientService.consulterProduitParMotCleService(this.produit.getDescription());
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
			return "/consulterProduitParMotCle.xhtml";
			}
		
		public String supprimerProduitPanier(){
			clientService.supprimerProduitPanierService(this.produit, this.panier);
			return "succes";
}
		public String consulterProduitSelectionner(){
			List<Produit> listeProduit=	clientService.consulterProduitSelectionnerService();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
			return "login";
}
		
		public String consulterCategorie(){
			List<Categorie> listeCategorie=	clientService.consulterCategorieClientService();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieList", listeCategorie);
			return "/consulterCat.xhtml";
			}
}
