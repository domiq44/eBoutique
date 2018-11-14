package fr.domiq.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.domiq.bo.ProduitService;
import fr.domiq.dao.ProduitDao;
import fr.domiq.entities.Produit;

@Component
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitDao produitDao;

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		return produitDao.ajouterProduit(p, idCat);
	}

	@Override
	public List<Produit> listProduits() {
		return produitDao.listProduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		return produitDao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		return produitDao.produitsParCategorie(idCat);
	}

	@Override
	public Produit getProduit(Long idP) {
		return produitDao.getProduit(idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		produitDao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
		produitDao.modifierProduit(p);
	}
}
