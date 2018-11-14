package fr.domiq.bo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.domiq.config.DataSourceConfig;
import fr.domiq.entities.Categorie;
import fr.domiq.entities.Produit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class })
public class CatalogueTest {

	private AnnotationConfigApplicationContext context;

	@Before
	public void setup() {
		context = new AnnotationConfigApplicationContext("fr.domiq");
	}

	@Test
	public void test1() {
		try {
			CategorieService categorieService = context.getBean(CategorieService.class);
			List<Categorie> listCategories = categorieService.listCategories();
			categorieService.ajouterCategorie(new Categorie("Ordinateurs", "Ord"));
			categorieService.ajouterCategorie(new Categorie("Imprimantes", "imp"));
			List<Categorie> listCategories2 = categorieService.listCategories();
			assertTrue(listCategories.size() + 2 == listCategories2.size());
		} catch (BeansException e) {
			assertTrue(e.getMessage(), false);
		}
	}

	@Test
	public void test2() {
		try {
			ProduitService produitService = context.getBean(ProduitService.class);
			List<Produit> listProduits = produitService.listProduits();
			produitService.ajouterProduit(new Produit("HP45ERT", "HP7890", 6000, 50), 1L);
			produitService.ajouterProduit(new Produit("AZERTY", "HP7890", 6000, 50), 1L);
			List<Produit> listProduits2 = produitService.listProduits();
			assertTrue(listProduits.size() + 2 == listProduits2.size());
		} catch (BeansException e) {
			assertTrue(e.getMessage(), false);
		}
	}
}
