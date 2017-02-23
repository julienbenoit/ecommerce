package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//===================Attributs propres==============================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_commande")
	private int id;
	private long idCommande;
	private Date dateCommande;
	
	
	//===================Attributs associés==============================
	@ManyToOne
	@JoinColumn(name = "fk_client" , referencedColumnName="id_client")
	private Client client_associe;
	private List<LigneCommande> listeLigneCommande;
	
	
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

	
	public Client getClient_associe() {
		return client_associe;
	}

	public void setClient_associe(Client client_associe) {
		this.client_associe = client_associe;
	}

	//===================Redefine toString==============================
	@Override
	public String toString() {
		return "Commande [id=" + id + ", idCommande=" + idCommande
				+ ", dateCommande=" + dateCommande + "]";
	}
	
	
}
