package fr.eni.zylim.encheres.bo;

import java.util.Collection;

public class Categorie {

    private  int no_categorie    ;
   private   String libelle   ;
private Collection< Article > articles;
public Categorie() {
	super();
}
public Categorie(int no_categorie, String libelle, Collection<Article> articles) {
	super();
	this.no_categorie = no_categorie;
	this.libelle = libelle;
	this.articles = articles;
}
public int getNo_categorie() {
	return no_categorie;
}
public void setNo_categorie(int no_categorie) {
	this.no_categorie = no_categorie;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public Collection<Article> getArticles() {
	return articles;
}
public void setArticles(Collection<Article> articles) {
	this.articles = articles;
}
@Override
public String toString() {
	return "Categorie [no_categorie=" + no_categorie + ", libelle=" + libelle + ", articles=" + articles + "]";
}

}
