package fr.adaming.entities;

public class Client {
	
	//===================Attributs propres==============================
	private int id;
	private long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;
	
	//===================Constructeurs==============================
	public Client() {
		super();
	}
	
	public Client(long idClient, String nomClient, String adresse,
			String email, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	
	public Client(int id, long idClient, String nomClient, String adresse,
			String email, String tel) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	
	//===================Accesseurs==============================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	//===================Redefine ToString==============================
	@Override
	public String toString() {
		return "Client [id=" + id + ", idClient=" + idClient + ", nomClient="
				+ nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + "]";
	}
	
	
}
