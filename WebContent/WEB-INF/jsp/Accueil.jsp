<%@page import="fr.eni.zylim.encheres.bo.ArticleVendu"%>
<%@page import="fr.eni.zylim.encheres.bll.ArticleVenduManager"%>
<%@page import="fr.eni.zylim.encheres.bll.QueyCollection"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style><%@include file="/style/Accueil.css"%></style>
<%-- <style><%@include file="/style/responsive_style.css"%></style> --%>

<title>Accueil</title>
</head>
<body>
<div class ="titre_logo_connexion_inscription">
<div class= "logo">
    <a href="<%="/encheres/consulteraccueilconnexion"%>"><img src="<%=getServletContext().getContextPath()%>/images/icone.png"  class="ico2" ></a>
</div>

<div class= "titre">
<h1 >Troc-enchères</h1>
</div>
<div class="inscription_connexion">
<a href=/encheres/ajouterutilisateur>S'inscrire</a>
<a href=/encheres/connexionutilisateur>Se connecter</a>
</div>
</div>


<div class ="filtre_recherche">

<div class = "filtre_categorie">
<p>Filtres</p>
<!-- <form method="post" action="*******"> -->


    <input type="text" id="input_search" value="Le nom de l'article contient">
    <img src=/encheres/images/icon_search.jfif id="input_img">

    

<div class="filtre_categories">
       <label for="categories">Catégories</label>
       <select name="categories" id="categories">
           <option value="informatique">Informatique</option>
           <option value="ameublement">Ameublement</option>
           <option value="vetement">Vetement</option>
           <option value="sport">Sport</option>
           <option value="loisirs">Loisirs</option>
           
       </select>
</div>
   </div>
 
   <div = "rechercher_submit">
   <input  type="submit" value="Rechercher" class = input_submit>
   </div>
   </div>
<!-- </form> -->
<div class = "les_articles">


 <c:forEach items="${lesArticles}" var="article">
     <div class = "affiche_article">
     <div class ="image_article_affiche">
     
              <img src= "${article.image_article}" id ="image_article"/>
       </div>  
      <div class ="affiche"> 
      <h3><a href ="/encheres/detailachatservlet">${article.nom_article}</a></h3> 
      <p>${article.description}</p>
      <p>${article.date_debut_encheres}</p>
      <p>${article.rue}</p>
      <p>${article.code_postal}</p>
      <p>${article.ville}</p>
      <p>${article.pseudo}</p> 
      <p>${article.prix_initial} pts</p>        
          
    </div>   
    </div>      
    </c:forEach> 

    </div>
</body>
</html>