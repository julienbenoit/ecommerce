package fr.adaming.metier;

public interface IAdminService {

	public void ajouterAdminService(Produit p);
	public void supprimerAdminService(Produit p);
	public void mofifierAdminService(Produit p);
	public List<Produit> consulterAdminService();
	
}
