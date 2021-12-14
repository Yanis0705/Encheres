
	<%@page import="fr.eni.zylim.encheres.bo.ArticleVendu"%>
<%@page import="fr.eni.zylim.encheres.bll.ArticleVenduManager"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@ include file="/style/Profil.css"%></style>
</head>
<body>
	<br>
	<a href="<%="/encheres/consulteraccueilconnexion"%>"><img
		class="ico"
		src="<%=getServletContext().getContextPath()%>/images/icone.png"></a>
	<br>
	<%
      if (session != null) {
         if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            out.print("Bienvenue  " + name + "  ");
         } else {
            response.sendRedirect("/WEB-INF/jsp/AccountUtil.jsp");
         }
      }
   %>
	<br>
	<br>
	<a href="<%="/encheres/vendrearticle"%>">Vendre un article</a>
	<br>
	<a href="<%="/encheres/profile"%>">Mon profil</a>
	<br>
	<a href="<%="/encheres/consulteraccueilconnexion"%>">Déconexion</a>
	<form>

		<p>Filtres :</p>
		<div>
			<input type="radio" id="huey" name="drone" value="Achats" checked>
			<label for="huey">Achats</label>
			<div>
				<input type="checkbox" id="horns" name="encheres_ouvertes" checked>
				<label for="horns">encheres ouvertes</label>
			</div>

			<div>
				<input type="checkbox" id="horns" name="mes_enchères_en_cours">
				<label for="horns">mes enchères en cours</label>
			</div>
			<div>
				<input type="checkbox" id="horns" name="mes_enchères_remportées">
				<label for="horns">mes enchères remportées</label>
			</div>

		</div>

		<div>
			<input type="radio" id="dewey" name="drone" value="Mes_ventes">
			<label for="dewey">Mes ventes</label>
			<div>
				<input type="checkbox" id="scales" name="mes_ventes_en_cours"
					checked> <label for="scales">mes ventes en cours</label>
			</div>

			<div>
				<input type="checkbox" id="scales" name="ventes_non_débutées">
				<label for="scales">ventes non débutées</label>
			</div>
			<div>
				<input type="checkbox" id="scales" name="ventes_terminées">
				<label for="scales">ventes terminées</label>
			</div>

		</div>
		<p>
		<p>
			<label for="categories">Catégories</label></> <select
				name="categories" id="categories">
				<option value="informatique">Informatique</option>
				<option value="ameublement">Ameublement</option>
				<option value="vetement">Vetement</option>
				<option value="sport">Sport</option>
				<option value="loisirs">Loisirs</option>

			</select>
		</p>
		<input type="text" id="input_search"
			value="Le nom de l'article contient"> <br>
		<input type="submit" value="Rechercher">

	</form>
	
	<c:forEach items="${lesArticles}" var="article">
     
        	
        <h3><a href ="/encheres/detailachatservlet">${article.nom_article}</a></h3>
            <p>${article.description}</p>
             <p>${article.prix_initial}</p>
             <p>${article.date_fin_encheres}</p>
           
    </c:forEach>

</body>
</html>
