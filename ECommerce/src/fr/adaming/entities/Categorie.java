package fr.adaming.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categories")
public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//===================Attributs propres==============================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorie")
	private int id;
	private long idCategorie;
	private String nomCategorie;
	private String description;
	
	
	//===================Attributs associ�s==============================
	@OneToMany(mappedBy="categorie_associe", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private List<Produit> listeProduit;
	
	
	
	//===================Constructeurs==================================

	public Categorie() {
		super();
	}
	public Categorie(long idCategorie, String nomCategorie,
			String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	public Categorie(int id, long idCategorie, String nomCategorie, String description) {
		super();
		this.id = id;
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	
	
	//===================Accesseurs==============================

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Produit> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
	//===================Redefine toString==============================


	@Override
	public String toString() {
		return "Categorie [id=" + id + ", idCategorie=" + idCategorie
				+ ", nomCategorie=" + nomCategorie + ", description=" + description + "]";
	}
	
	
	
}
