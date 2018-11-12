package session;

import java.util.List;

import javax.ejb.Remote;

import metier.Produit;

@Remote
public interface ProduitRemote {
	public int ajouterProduit(Produit p);
	public Produit modifierProduit(Produit p);
	public void supprimerProduit(Produit p);
	public Produit getProduit(int idProduit);
	public List<Produit> findAllProduits();
}
