package fr.domiq.service;

import java.util.List;

import fr.domiq.entities.Categorie;

public interface CategorieService {
	Long ajouterCategorie(Categorie c);
	List<Categorie> listCategories();
	Categorie getCategorie(Long idCat);
	void supprimerCategorie(Long idCat);
	void modifierCategorie(Categorie c);
}
