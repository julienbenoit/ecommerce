package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.OneToMany;

public class LigneCommande implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	
	//===================Attributs propres==============================
	private int quantite;
	private float prix;

	
	//===================Attributs associés==============================
	@OneToMany
	private Produit produit_associe;
	
	@OneToMany
	private Commande commande_associe;
	
	
	
	//====================Constructeurs==================================

	public LigneCommande() {
		super();
	}
	public LigneCommande(int quantite, float prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}
	
	//====================Accesseurs==================================

	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Produit getProduit_associe() {
		return produit_associe;
	}
	public void setProduit_associe(Produit produit_associe) {
		this.produit_associe = produit_associe;
	}
	
	
	//====================Redefine ToString==============================
	@Override
	public String toString() {
		return "LigneCommande [quantite=" + quantite + ", prix=" + prix + "]";
	}
	
}
