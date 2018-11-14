package fr.domiq.entities;

import java.io.Serializable;

public class Produit implements Serializable {
	private static final long serialVersionUID = 6242966908281591511L;

	private Long idProduit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	private Categorie categorie;

	public Produit() {
	}

	public Produit(String designation, String description, double prix, int quantite) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produit [idProduit=");
		builder.append(idProduit);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", description=");
		builder.append(description);
		builder.append(", prix=");
		builder.append(prix);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append(", categorie=");
		builder.append(categorie);
		builder.append("]");
		return builder.toString();
	}
}