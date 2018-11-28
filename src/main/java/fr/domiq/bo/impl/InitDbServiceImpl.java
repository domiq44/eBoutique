package fr.domiq.bo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import fr.domiq.bo.InitDbService;

@Component
public class InitDbServiceImpl implements InitDbService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void dropTables() {
		log.info("Dropping tables ...");

		String sql = "drop table categorie if exists";
		jdbcTemplate.execute(sql);

		sql = "drop table produit if exists";
		jdbcTemplate.execute(sql);

		log.info("Done.");
	}

	@Override
	public void createTables() {
		log.info("Creating tables ...");

		String sql = "create table categorie ("
				+ "id_categorie bigint auto_increment primary key"
				+ ", nom_categorie varchar(20)"
				+ ", description varchar(255)"
				+ ")";
		jdbcTemplate.execute(sql);

		sql = "create table produit ("
				+ "id_produit bigint auto_increment primary key"
				+ ", description varchar(255)"
				+ ", designation varchar(15)"
				+ ", prix double"
				+ ", quantite int"
				+ ", id_categorie bigint"
				+ ")";
		jdbcTemplate.execute(sql);

		log.info("Done.");
	}
}
