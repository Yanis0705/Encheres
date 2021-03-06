package fr.eni.zylim.encheres.bo;

import java.util.Collection;

public class Utilisateur {

	private int no_utilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String code_postal;
	private String ville;
	private String mot_de_passe;
	private int credit;
	boolean administrateur;
	private Collection<ArticleVendu> articles;
	private Collection<Enchere> encheres;

	@Override
	public String toString() {
		return "Utilisiteur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_postal="
				+ code_postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", articles=" + articles + ", encheres=" + encheres + "]";
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public Collection<ArticleVendu> getArticles() {
		return articles;
	}

	public void setArticles(Collection<ArticleVendu> articles) {
		this.articles = articles;
	}

	public Collection<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(Collection<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur,
			Collection<ArticleVendu> articles, Collection<Enchere> encheres) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
		this.articles = articles;
		this.encheres = encheres;
	}
	
	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe,boolean administrateur) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.administrateur = administrateur;
	
	}
	

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe,boolean administrateur, int no_utilisateur) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.administrateur = administrateur;
	
	}
	
	public Utilisateur(String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe,boolean administrateur, int no_utilisateur) {
		super();

		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.administrateur = administrateur;
		this.no_utilisateur = no_utilisateur;
	}



	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String code_postal, String ville, String mot_de_passe) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
	}

	public Utilisateur(int no_utilisateur, String pseudo) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		
	}


	
}
