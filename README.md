It is a simple Spring JDBC project using H2 as database.

There is no Spring XML file since configuration is done in Java (JavaConfig).

This is the output after running `App.java` :

~~~~
[2018-11-14 22:35:35,324] INFO  fr.domiq.app.App ===> main() 
[2018-11-14 22:35:35,745] INFO  org.springframework.context.annotation.AnnotationConfigApplicationContext Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@ee7d9f1: startup date [Wed Nov 14 22:35:35 CET 2018]; root of context hierarchy 
[2018-11-14 22:35:36,139] INFO  org.springframework.jdbc.datasource.DriverManagerDataSource Loaded JDBC driver: org.h2.Driver 
[2018-11-14 22:35:36,212] INFO  fr.domiq.app.App ===> init() 
[2018-11-14 22:35:36,214] INFO  fr.domiq.bo.impl.InitDbServiceImpl Dropping tables ... 
[2018-11-14 22:35:36,550] INFO  fr.domiq.bo.impl.InitDbServiceImpl Done. 
[2018-11-14 22:35:36,550] INFO  fr.domiq.bo.impl.InitDbServiceImpl Creating tables ... 
[2018-11-14 22:35:36,601] INFO  fr.domiq.bo.impl.InitDbServiceImpl Done. 
[2018-11-14 22:35:36,602] INFO  fr.domiq.app.App ===> test1() 
[2018-11-14 22:35:36,685] INFO  fr.domiq.app.App Categorie [idCategorie=1, nomCategorie=Ordinateurs, description=Ord] 
[2018-11-14 22:35:36,685] INFO  fr.domiq.app.App Categorie [idCategorie=2, nomCategorie=Imprimantes, description=imp] 
[2018-11-14 22:35:36,685] INFO  fr.domiq.app.App ===> test2() 
[2018-11-14 22:35:36,757] INFO  fr.domiq.app.App Produit [idProduit=1, designation=HP45ERT, description=HP7890, prix=6000.0, quantite=50, categorie=Categorie [idCategorie=1, nomCategorie=Ordinateurs, description=HP7890]] 
[2018-11-14 22:35:36,757] INFO  fr.domiq.app.App Produit [idProduit=2, designation=AZERTY, description=HP7890, prix=6000.0, quantite=50, categorie=Categorie [idCategorie=1, nomCategorie=Ordinateurs, description=HP7890]] 
[2018-11-14 22:35:36,757] INFO  org.springframework.context.annotation.AnnotationConfigApplicationContext Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@ee7d9f1: startup date [Wed Nov 14 22:35:35 CET 2018]; root of context hierarchy 
~~~~

Or you can run the test case `CatalogueTest.java`.

