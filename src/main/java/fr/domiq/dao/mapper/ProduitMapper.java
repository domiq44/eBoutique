package fr.domiq.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.domiq.entities.Produit;

public class ProduitMapper implements RowMapper<Produit> {

	@Override
	public Produit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Produit produit = new Produit();
		produit.setIdProduit(rs.getLong("id_produit"));
		produit.setDesignation(rs.getString("designation"));
		produit.setDescription(rs.getString("description"));
		produit.setPrix(rs.getDouble("prix"));
		produit.setQuantite(rs.getInt("quantite"));
		produit.setCategorie(new CategorieMapper().mapRow(rs, rowNum));

		return produit;
	}
}
