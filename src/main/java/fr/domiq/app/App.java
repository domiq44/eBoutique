package fr.domiq.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import fr.domiq.bo.CategorieService;
import fr.domiq.bo.InitDbService;
import fr.domiq.bo.ProduitService;
import fr.domiq.config.MainConfig;
import fr.domiq.entities.Categorie;
import fr.domiq.entities.Produit;

@Configuration
public class App {

	private static Logger log = LoggerFactory.getLogger(App.class);

	@Autowired
	private InitDbService initDbService;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private ProduitService produitService;

	public static void main(String[] args) {
		log.info("===> main()");
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		context.registerShutdownHook();
		//
		App app = context.getBean(App.class);
		//
		app.init();
		app.testCategorie();
		app.testProduit();
	}

	public void init() {
		log.info("===> init()");

		initDbService.dropTables();
		initDbService.createTables();
	}

	public void testCategorie() {
		log.info("===> testCategorie()");

		categorieService.ajouterCategorie(new Categorie("Ordinateurs", "Ord"));
		categorieService.ajouterCategorie(new Categorie("Imprimantes", "imp"));

		for (Categorie categorie : categorieService.listCategories()) {
			log.info(categorie.toString());
		}
	}

	public void testProduit() {
		log.info("===> testProduit()");

		produitService.ajouterProduit(new Produit("HP45ERT", "HP7890", 6000, 50), 1L);
		produitService.ajouterProduit(new Produit("AZERTY", "HP7890", 6000, 50), 1L);

		for (Produit produit : produitService.listProduits()) {
			log.info(produit.toString());
		}
	}
}
