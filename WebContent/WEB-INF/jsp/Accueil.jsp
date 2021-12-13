<%@page import="fr.eni.zylim.encheres.bo.ArticleVendu"%>
<%@page import="fr.eni.zylim.encheres.bll.ArticleVenduManager"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style><%@include file="/style/Accueil.css"%></style>
<style><%@include file="/style/responsive_style.css"%></style>

<title>Accueil</title>
</head>
<body>

<div id="wrapper">

<div class="form_div">
<p class="form_label">Troc-enchères</p>
<a href=/encheres/ajouterutilisateur>S'inscrire</a></li>
<a href=/encheres/connexionutilisateur>Se connecter</a></li>
<p class="le_filtre">Filtres</p>
<form method="post" action="*******">
<div id="input_container">
<div class="barre_de_recherche">
    <input type="text" id="input_search" value="Le nom de l'article contient">
    <img src=/encheres/images/icon_search.jfif id="input_img">
    </div>  
    

<p>
       <label for="categories">Catégories</label><br />
       <select name="categories" id="categories">
           <option value="informatique">Informatique</option>
           <option value="ameublement">Ameublement</option>
           <option value="vetement">Vetement</option>
           <option value="sport">Sport</option>
           <option value="loisirs">Loisirs</option>
           
       </select>
   </p>
   <input type="submit" value="Rechercher">
</form>

  


<div class = "tous_les_articles">

<div class= un_article>

<img src="url" />
 <c:forEach items="${lesArticles}" var="article">
     
        	
        <h3><a href ="/encheres/detailachatservlet">${article.nom_article}</a></h3>
            <p>${article.description}</p>
             <p>${article.prix_initial}</p>
             <p>${article.date_fin_encheres}</p>
           
    </c:forEach>
    
<p class = "retrait">afficher l'adresse de retrait</p>
<p class = "pseudo_vendeur">afficher le pseudo de vendeur</p>


</div>

</div>
</div>
</body>
</html>