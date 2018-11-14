package fr.domiq.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.domiq.entities.Categorie;

public class CategorieMapper implements RowMapper<Categorie> {

	@Override
	public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categorie categorie = new Categorie();
		categorie.setIdCategorie(rs.getLong("id_categorie"));
		categorie.setNomCategorie(rs.getString("nom_categorie"));
		categorie.setDescription(rs.getString("description"));
		return categorie;
	}
}
