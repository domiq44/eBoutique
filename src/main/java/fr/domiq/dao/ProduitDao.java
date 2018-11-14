package fr.domiq.dao;

import java.util.List;

import fr.domiq.entities.Produit;

public interface ProduitDao {
	Long ajouterProduit(Produit p, Long idCat);
	List<Produit> listProduits();
	List<Produit> produitsParMotCle(String mc);
	List<Produit> produitsParCategorie(Long idCat);
	Produit getProduit(Long idP);
	void supprimerProduit(Long idP);
	void modifierProduit(Produit p);
}
