package fr.eni.zylim.encheres.bll;



import java.sql.Date;



public class QueyCollection {
private int no_article;
private String nom_article;
private String description;
private String libelle;

private Date date_debut_encheres;
private Date date_fin_encheres;
private String rue;
private String code_postal;
private String ville;
private String pseudo;
private int prix_initial ;
private String image_article;
public String getImage_article() {
	return image_article;
}
public void setImage_article(String image_article) {
	this.image_article = image_article;
}
public int getNo_article() {
return no_article;
}
public void setNo_article(int no_article) {
this.no_article = no_article;
}
public String getNom_article() {
return nom_article;
}
public void setNom_article(String nom_article) {
this.nom_article = nom_article;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
public String getLibelle() {
return libelle;
}
public void setLibelle(String libelle) {
this.libelle = libelle;
}

public Date getDate_debut_encheres() {
return date_debut_encheres;
}
public void setDate_debut_encheres(Date date_debut_encheres) {
this.date_debut_encheres = date_debut_encheres;
}
public Date getDate_fin_encheres() {
return date_fin_encheres;
}
public void setDate_fin_encheres(Date date_fin_encheres) {
this.date_fin_encheres = date_fin_encheres;
}
public String getRue() {
return rue;
}
public void setRue(String rue) {
this.rue = rue;
}
public String getCode_postal() {
return code_postal;
}
public void setCode_postal(String code_postal) {
this.code_postal = code_postal;
}
public String getVille() {
return ville;
}
public void setVille(String ville) {
this.ville = ville;
}
public String getPseudo() {
return pseudo;
}
public void setPseudo(String pseudo) {
this.pseudo = pseudo;
}
public int getPrix_initial() {
return prix_initial;
}
public void setPrix_initial(int prix_initial) {
this.prix_initial = prix_initial;
}
public QueyCollection(int no_article, String nom_article, String description, String libelle, 
Date date_debut_encheres, Date date_fin_encheres, String rue, String code_postal, String ville,
String pseudo, int prix_initial, String image_article ) {
super();
this.no_article = no_article;
this.nom_article = nom_article;
this.description = description;
this.libelle = libelle;

this.date_debut_encheres = date_debut_encheres;
this.date_fin_encheres = date_fin_encheres;
this.rue = rue;
this.code_postal = code_postal;
this.ville = ville;
this.pseudo = pseudo;
this.prix_initial = prix_initial;
this.image_article =image_article ;
}
public QueyCollection() {
super();
}

}


