package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;
import fr.adaming.metier.IClientService;

@ManagedBean(name="clientMB")
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
	
	//------Methodes Client-----
		public String ajouterProduitPanier(){
			clientService.ajouterProduitPanierService(this.produit, this.panier);
			return "succes";
			
		}
		public String consulterProduitParCategorie(){
		List<Produit> listeProduit=	clientService.consulterProduitParCategorieService(this.commande.getId());
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productList", listeProduit);
		return "login";
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
}
