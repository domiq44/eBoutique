package fr.domiq.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.domiq.dao.ProduitDao;
import fr.domiq.dao.mapper.ProduitMapper;
import fr.domiq.entities.Produit;

@Repository
public class ProduitDaoImpl implements ProduitDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		String sql = "insert into produit (description, designation, prix, quantite, id_categorie) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, p.getDescription(), p.getDesignation(), p.getPrix(), p.getQuantite(), idCat);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listProduits() {
		String sql = "select * from produit inner join categorie on produit.id_categorie = categorie.id_categorie";
		return jdbcTemplate.query(sql, new ProduitMapper());
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		String sql = "select * from categorie where designation like ?";
		return jdbcTemplate.query(sql, new Object[] { "%" + mc + "%" }, new ProduitMapper());
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		String sql = "select * from categorie where id_categorie = ?";
		return jdbcTemplate.query(sql, new Object[] { idCat }, new ProduitMapper());
	}

	@Override
	public Produit getProduit(Long idP) {
		String sql = "select * from categorie where id_produit = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idP }, new ProduitMapper());
	}

	@Override
	public void supprimerProduit(Long idP) {
		String sql = "delete * from produit where id_produit = ?";
		jdbcTemplate.update(sql, new Object[] { idP });
	}

	@Override
	public void modifierProduit(Produit p) {
		String sql = "update produit set description = ?, designation = ?, prix = ?, quantite = ? where id_produit = ?";
		jdbcTemplate.update(sql, new Object[] { p.getDescription(), p.getDesignation(), p.getPrix(), p.getQuantite(), p.getIdProduit() });
	}
}
