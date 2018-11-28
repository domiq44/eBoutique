package fr.domiq.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.domiq.bo.ProduitService;
import fr.domiq.dao.ProduitDao;
import fr.domiq.entities.Produit;

@Component
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitDao produitDao;

	@Transactional
	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		return produitDao.ajouterProduit(p, idCat);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Produit> listProduits() {
		return produitDao.listProduits();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Produit> produitsParMotCle(String mc) {
		return produitDao.produitsParMotCle(mc);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		return produitDao.produitsParCategorie(idCat);
	}

	@Transactional(readOnly = true)
	@Override
	public Produit getProduit(Long idP) {
		return produitDao.getProduit(idP);
	}

	@Transactional
	@Override
	public void supprimerProduit(Long idP) {
		produitDao.supprimerProduit(idP);
	}

	@Transactional
	@Override
	public void modifierProduit(Produit p) {
		produitDao.modifierProduit(p);
	}
}
