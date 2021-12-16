<%@page import="java.util.List"%>
<%@page import="fr.eni.zylim.encheres.bll.CategorieManager"%>
<%@page import="fr.eni.zylim.encheres.bo.Categorie"%>
<%@page import="fr.eni.zylim.encheres.bll.UtilisateurManager"%> 
<%@page import="fr.eni.zylim.encheres.bo.Utilisateur"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="fr">
    <head>
    	<meta charset="UTF-8">
  	    <meta name="viewport"content="width=device-width, initial-scale=1.">
  	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Place your kit's code here -->
   		<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
	<style><%@ include file="/style/Inscription.css"%></style>
        <title>Nouvelle Vente</title>
    </head>
<body>

<h3>
<a href="/WEB-INF/jsp/Utilisateur.jsp">Troc-enchères.org</a>
</h3>
<h4>Nouvelle Vente</h4>

 <!-- Formulaire Vendre un article-->
    <section class="">
    	<%
    	
    	Utilisateur user = null;
      if (session != null) {
         if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            user = UtilisateurManager.getUtilisateurProfile(name);
         } else {
            response.sendRedirect("/WEB-INF/jsp/AccountUtil.jsp");
         }
      }
    	
%>   
    <%--   <form class="paveArticle" action="<%=request.getContextPath()%>/vendrearticle" method="post">  --%>
      <form action="<c:url value="/vendrearticle"/>" method="post">
      <table align=center cellspacing=10>
        <tr>
          <td for="article">Article :</td>
          <td><input class="input" type="text" name="nom" id="article"  placeholder="Nom de l'article" value="${param.nom}" required></td>
        </tr>

        <tr>
          <td for="description">Description :</td>
          <td><textarea class="input"name="description" id="description" placeholder="Entrez une description de l'article"  value="${param.description}"></textarea>
        </tr>

        <tr>
          <td for="categorie">Catégorie :</td>
            <td><select  name="categorie" class="input" id="categorie">
			<% for(Categorie categorie : CategorieManager.selectionnerToutesLesCategories()) { %>
            	<option   value ="<%=categorie.getNo_categorie()%>"><%=categorie.getLibelle()%></option>
             <% } %>
          </select></td>
        </tr>
      
<!--         <div class="">
          <label for="file">Photo de l'article :</label>
          <div class="input"> 
            <input type="file" name="file" id="file" accept="image/*">
            <input type="submit">
          </div>
        </div> -->
       
        <tr>
              <td for="prixBase">Mise à prix :</td>
             <td> <input class="input" type="number" name="prixBase" id="prixBase" 
              step="1" max= "10000"  value="${param.prixBase}" required></td>
        </tr><br>

        <tr>
            <td for="dateDebutEnchere">Début de l'enchère :</td>
            <td><input class="input" type="date" name="dateDebutEnchere" id="dateDebutEnchere"  value="${param.dateDebutEnchere}"  required></td> 
        </tr><br>

        <tr>
            <td for="dateFinEnchere">Fin de l'enchère :</td>
           <td> <input class= "input" type="date" name="dateFinEnchere" id="dateFinEnchere" value="${param.dateFinEnchere}" required></td> 
        </tr><br>

    <!-- Retrait-->
    <div class="">
      <tr>
          <td for="rue">Rue :</td>
          <td> <input class="input" type="text" name="rue" id="rue" maxlength="100" value="<%=user.getRue() %>" required></td> 
      </tr><br>

       <tr>
         <td for="codePostal">Code Postal :</td>
        <td> <input class="input" type="text" name="codePostal" id="cp" 
          step="1000" min="0" maxlength="5" value="<%=user.getCode_postal()%>" required></td>
      </tr> <br>

      <tr>
         <td for="ville">Ville :</td>
		<td><input class="input" type="text" name="ville" id="ville" value="<%=user.getVille()%>" required></td>

      </tr><br>
    </div>
</table>
        <div class="boutonsEnregistrerAnnuler">
          <button class="btn-enregistrer" type="submit" >Vendre</button>
        </div><br>

       
      </form>
      	<form class="boutonsEnregistrerAnnuler" action="connexionutilisateur">
	<button class="btn-retour">Annuler</button>
	</form>
    </section>

</body>
</html>
