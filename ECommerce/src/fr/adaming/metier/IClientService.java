package fr.adaming.metier;

public interface IClientService {
	public void ajouterClientService(Produit p);
	public void supprimerClientService(Produit p);
	public void mofifierClientService(Produit p);
	public List<Categorie> consulterClientCategoService();
	public List<Produit> consulterClientProduitService(Categorie c);
	public List<Produit> consulterClientProduitSelectService();
	public void enregistrerClientService();
}
