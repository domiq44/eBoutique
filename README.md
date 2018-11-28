It is a simple Spring JDBC project using H2 as database.

There is no Spring XML file since configuration is done in Java (JavaConfig).

This is the output after running `App.java` :

~~~~
[2018-11-28 19:42:25,089] INFO  fr.domiq.app.App ===> main() 
[2018-11-28 19:42:26,221] INFO  com.zaxxer.hikari.HikariDataSource springHikariCP - Starting... 
[2018-11-28 19:42:26,643] INFO  com.zaxxer.hikari.HikariDataSource springHikariCP - Start completed. 
[2018-11-28 19:42:26,836] INFO  fr.domiq.app.App ===> init() 
[2018-11-28 19:42:26,837] INFO  fr.domiq.bo.impl.InitDbServiceImpl Dropping tables ... 
[2018-11-28 19:42:26,863] INFO  fr.domiq.bo.impl.InitDbServiceImpl Done. 
[2018-11-28 19:42:26,863] INFO  fr.domiq.bo.impl.InitDbServiceImpl Creating tables ... 
[2018-11-28 19:42:26,905] INFO  fr.domiq.bo.impl.InitDbServiceImpl Done. 
[2018-11-28 19:42:26,906] INFO  fr.domiq.app.App ===> testCategorie() 
[2018-11-28 19:42:26,968] INFO  fr.domiq.app.App Categorie [idCategorie=1, nomCategorie=Ordinateurs, description=Ord] 
[2018-11-28 19:42:26,972] INFO  fr.domiq.app.App Categorie [idCategorie=2, nomCategorie=Imprimantes, description=imp] 
[2018-11-28 19:42:26,972] INFO  fr.domiq.app.App ===> testProduit() 
[2018-11-28 19:42:26,982] INFO  fr.domiq.app.App Produit [idProduit=1, designation=HP45ERT, description=HP7890, prix=6000.0, quantite=50, categorie=Categorie [idCategorie=1, nomCategorie=Ordinateurs, description=HP7890]] 
[2018-11-28 19:42:26,983] INFO  fr.domiq.app.App Produit [idProduit=2, designation=AZERTY, description=HP7890, prix=6000.0, quantite=50, categorie=Categorie [idCategorie=1, nomCategorie=Ordinateurs, description=HP7890]] 
[2018-11-28 19:42:26,986] INFO  com.zaxxer.hikari.HikariDataSource springHikariCP - Shutdown initiated... 
[2018-11-28 19:42:26,989] INFO  com.zaxxer.hikari.HikariDataSource springHikariCP - Shutdown completed. 
~~~~

Or you can run the test case `CatalogueTest.java`.

