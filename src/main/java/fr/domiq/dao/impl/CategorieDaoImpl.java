package fr.domiq.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.domiq.dao.CategorieDao;
import fr.domiq.dao.mapper.CategorieMapper;
import fr.domiq.entities.Categorie;

@Repository
public class CategorieDaoImpl implements CategorieDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long ajouterCategorie(Categorie c) {
		String sql = "insert into categorie (nom_categorie, description) values (?, ?)";
		jdbcTemplate.update(sql, c.getNomCategorie(), c.getDescription());
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		String sql = "select * from categorie";
		return jdbcTemplate.query(sql, new CategorieMapper());
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		String sql = "select * from categorie where id_categorie = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idCat }, new CategorieMapper());
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		String sql = "delete * from categorie where id_categorie = ?";
		jdbcTemplate.update(sql, new Object[] { idCat });
	}

	@Override
	public void modifierCategorie(Categorie c) {
		String sql = "update categorie set nom_categorie = ?, description = ? where id_categorie = ?";
		jdbcTemplate.update(sql, new Object[] { c.getNomCategorie(), c.getDescription(), c.getIdCategorie() });
	}
}
