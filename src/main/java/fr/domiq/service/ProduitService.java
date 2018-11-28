package fr.domiq.service;

import java.util.List;

import fr.domiq.entities.Produit;

public interface ProduitService {
	Long ajouterProduit(Produit p, Long idCat);
	List<Produit> listProduits();
	List<Produit> produitsParMotCle(String mc);
	List<Produit> produitsParCategorie(Long idCat);
	Produit getProduit(Long idP);
	void supprimerProduit(Long idP);
	void modifierProduit(Produit p);
}
