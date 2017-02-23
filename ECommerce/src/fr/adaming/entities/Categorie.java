package fr.adaming.entities;

import java.util.Arrays;

public class Categorie {
	
	//===================Attributs propres==============================
	private int id;
	private long idCategorie;
	private String nomCategorie;
	private byte[] photo;
	private String description;
	
	//===================Constructeurs==============================

	public Categorie() {
		super();
	}
	public Categorie(long idCategorie, String nomCategorie, byte[] photo,
			String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}
	public Categorie(int id, long idCategorie, String nomCategorie,
			byte[] photo, String description) {
		super();
		this.id = id;
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	//===================Redefine toString==============================

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", idCategorie=" + idCategorie
				+ ", nomCategorie=" + nomCategorie + ", photo="
				+ Arrays.toString(photo) + ", description=" + description + "]";
	}
	
	
	
}
