package fr.eni.zylim.encheres.bo;

import java.sql.Date;

public class Enchere {

	private Date date_enchere;
	private int montant_enchere;
	private int no_article;
	private int no_utilisateur;
	
	public Date getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(Date date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public Enchere() {
		
	}
	
	public Enchere( Date date_enchere, int montant_enchere, int no_article, int no_utilisateur) {
		this(date_enchere , montant_enchere);
		
		this.no_article = no_article;
		this.no_utilisateur = no_utilisateur;
	}
	public Enchere( Date date_enchere, int montant_enchere) {
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		
	}
	




	@Override
	public String toString() {
		return "Enchere [ date_enchere=" + date_enchere + ", montant_enchere="
				+ montant_enchere + ", no_article=" + no_article + ", no_utilisateur=" + no_utilisateur + "]";
	}

}
