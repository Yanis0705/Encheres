<%@page import="fr.eni.zylim.encheres.bo.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.zylim.encheres.bll.CategorieManager"%>
<%@page import="fr.eni.zylim.encheres.bo.Utilisateur"%>
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

        <title>Nouvelle Vente</title>
    </head>
<body>

<h3>
<a href="/WEB-INF/jsp/Utilisateur.jsp">Troc-enchères.org</a>
</h3>
<h4>Nouvelle Vente</h4>

 <!-- Formulaire Vendre un article-->
 
    <section class="vente-form">
    	<% Utilisateur user = (Utilisateur) session.getAttribute("user"); 
    	%>    
      <form class="paveArticle" action="<%=request.getContextPath() %>/vendrearticle" method="post"> <!-- change methode to POST to get results on server, i used GET to show the result in html file-->
      
        <div class="input-field">
          <label for="article">Article :</label>
          <input class="input" type="text" name="article" id="article"  placeholder="Article" required>
        </div>

        <div class="input-field">
          <label for="description">Description :</label>
          <textarea class="input"name="description" id="description" placeholder="Entrez une description de l'article"></textarea>
        </div>

        <div class="input-field">
          <label for="categorie">Catégorie :</label>
<!--            <select name="categories" id="categories">
        	 <option value="informatique">Informatique</option>
			<option value="ameublement">Ameublement</option>
			<option value="vetement">Vetement</option>
			<option value="sport">Sport</option>
			<option value="loisirs">Loisirs</option>
		</select>  -->
            <select name="categorie" class="input" id="categorie">
          <% for(Categorie categorie : CategorieManager.selectionnerToutesLesCategories()) { %>
            <option  value ="<%=categorie.getNo_categorie()%>"><%=categorie.getLibelle()%></option>
             <% } %>
          </select>
        </div>
      
<!--         <div class="input-field">
          <label for="file">Photo de l'article :</label>
          <div class="input"> 
            <input type="file" name="file" id="file" accept="image/*">
            <input type="submit">
          </div>
        </div> -->
       
        <div class="input-field">
              <label for="mPrix">Mise à prix :</label>
              <input class="input" type="number" name="mPrix" id="mPrix" 
              step="1" max= "10000" required>
        </div>

        <div class="input-field">
            <label for="dEnchere">Début de l'enchère :</label>
            <input class="input" type="date" name="dEnchere" id="dEnchere" required> 
        </div>

        <div class="input-field">
            <label for="fEnchere">Fin de l'enchère :</label>
            <input class= "input" type="date" name="fEnchere" id="fEnchere" required> 
        </div>

    <!-- Retrait-->
    <div class="retrait">
      <h1>Retrait de l'objet</h1>
      <div class="input-field">
          <label for="rue">Rue :</label>
          <input class="input" type="text" name="rue" id="rue" maxlength="100" value="<%=user.getRue() %>" required>
      </div>

       <div class="input-field">
          <label for="cp">Code Postale :</label>
          <input class="input" type="text" name="codePostal" id="cp" 
          step="1000" min="0" maxlength="5" value="<%=user.getCode_postal()%>" required>
      </div> 

      <div class="input-field">
          <label for="ville">Ville :</label>
          <input class="input" type="text" name="ville" id="ville" value="<%=user.getVille()%>" required>
      </div>
    </div>

        <div class="boutonsEnregistrerAnnuler">
          <button class="btn-enregistrer" type="submit" >Vendre</button>
        </div>
	<form class="boutonsEnregistrerAnnuler" action="connexionutilisateur">
	<button class="btn-retour">Annuler</button>
	</form>
       
      </form>
    </section>

</body>
</html>
