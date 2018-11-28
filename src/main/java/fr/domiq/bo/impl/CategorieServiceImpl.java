package fr.domiq.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.domiq.bo.CategorieService;
import fr.domiq.dao.CategorieDao;
import fr.domiq.entities.Categorie;

@Component
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieDao categorieDao;

	@Transactional
	@Override
	public Long ajouterCategorie(Categorie c) {
		return categorieDao.ajouterCategorie(c);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Categorie> listCategories() {
		return categorieDao.listCategories();
	}

	@Transactional(readOnly = true)
	@Override
	public Categorie getCategorie(Long idCat) {
		return categorieDao.getCategorie(idCat);
	}

	@Transactional
	@Override
	public void supprimerCategorie(Long idCat) {
		categorieDao.supprimerCategorie(idCat);
	}

	@Transactional
	@Override
	public void modifierCategorie(Categorie c) {
		categorieDao.modifierCategorie(c);
	}
}
