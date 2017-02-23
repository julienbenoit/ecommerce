package fr.adaming.entities;

import java.util.Date;

public class Commande {
	
	//===================Attributs propres==============================
	private int id;
	private long idCommande;
	private Date dateCommande;
	
	
	
	
	
	
	//===================Constructeurs==============================
	public Commande() {
		super();
	}
	
	public Commande(long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public Commande(int id, long idCommande, Date dateCommande) {
		super();
		this.id = id;
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}
	
	//===================Accesseurs==============================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	//===================Redefine toString==============================
	@Override
	public String toString() {
		return "Commande [id=" + id + ", idCommande=" + idCommande
				+ ", dateCommande=" + dateCommande + "]";
	}
	
	
}
