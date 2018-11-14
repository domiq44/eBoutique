package fr.domiq.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.domiq.bo.CategorieService;
import fr.domiq.dao.CategorieDao;
import fr.domiq.entities.Categorie;

@Component
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieDao categorieDao;

	@Override
	public Long ajouterCategorie(Categorie c) {
		return categorieDao.ajouterCategorie(c);
	}

	@Override
	public List<Categorie> listCategories() {
		return categorieDao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return categorieDao.getCategorie(idCat);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		categorieDao.supprimerCategorie(idCat);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		categorieDao.modifierCategorie(c);
	}
}
