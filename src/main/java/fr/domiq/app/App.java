package fr.domiq.app;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import fr.domiq.bo.CategorieService;
import fr.domiq.bo.InitDbService;
import fr.domiq.bo.ProduitService;
import fr.domiq.config.DataSourceConfig;
import fr.domiq.entities.Categorie;
import fr.domiq.entities.Produit;

@Configuration
public class App {

	private static Logger log = Logger.getLogger(App.class);

	@Autowired
	private InitDbService initDbService;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private ProduitService produitService;

	public static void main(String[] args) {
		log.info("===> main()");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		App app = context.getBean(App.class);
		// app.init();
		app.test1();
		app.test2();
		((AbstractApplicationContext) context).close();
	}

	public void init() {
		log.info("===> init()");

		initDbService.dropTables();
		initDbService.createTables();
	}

	public void test1() {
		log.info("===> test1()");

		categorieService.ajouterCategorie(new Categorie("Ordinateurs", "Ord"));
		categorieService.ajouterCategorie(new Categorie("Imprimantes", "imp"));

		for (Categorie categorie : categorieService.listCategories()) {
			log.info(categorie);
		}
	}

	public void test2() {
		log.info("===> test2()");

		produitService.ajouterProduit(new Produit("HP45ERT", "HP7890", 6000, 50), 1L);
		produitService.ajouterProduit(new Produit("AZERTY", "HP7890", 6000, 50), 1L);

		for (Produit produit : produitService.listProduits()) {
			log.info(produit);
		}
	}
}
