package fr.domiq.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class Categorie implements Serializable {
	private static final long serialVersionUID = -2997700450077538436L;

	private Long idCategorie;
	private String nomCategorie;
	private String description;
	private Collection<Produit> produits = new HashSet<Produit>();

	public Categorie(String nomCategorie, String description) {
		this.nomCategorie = nomCategorie;
		this.description = description;
	}

	public Categorie() {
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [idCategorie=");
		builder.append(idCategorie);
		builder.append(", nomCategorie=");
		builder.append(nomCategorie);
		builder.append(", description=");
		builder.append(description);
		// builder.append(", produits=");
		// builder.append(produits);
		builder.append("]");
		return builder.toString();
	}
}