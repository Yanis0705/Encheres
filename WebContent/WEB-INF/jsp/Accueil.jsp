<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style>
<%@ include file ="/style/Accueil.css"%></style>
<style><%@ include file="/style/responsive_style.css"%></style>

<title>Accueil</title>
</head>
<body>

	<div id="wrapper">

		<div class="form_div">
			<p class="form_label">Troc-enchères</p>
			<a href=/encheres/ajouterutilisateur>S'inscrire</a>
			</li> <a href=/encheres/connexionutilisateur>Se connecter</a>
			</li>
			<p class="le_filtre">Filtres</p>
			<form method="post" action="*******">
				<div id="input_container">
					<div class="barre_de_recherche">
						<input type="text" id="input_search"
							value="Le nom de l'article contient"> <img
							src=/encheres/images/icon_search.jfif id="input_img">
					</div>





				</div>
				<!-- <p class="les_categories">Catégories</p> -->

				<p>
					<label for="categories">Catégories</label><br /> <select
						name="categories" id="categories">
						<option value="informatique">Informatique</option>
						<option value="ameublement">Ameublement</option>
						<option value="vetement">Vetement</option>
						<option value="sport">Sport</option>
						<option value="loisirs">Loisirs</option>

					</select>
				</p>
				<input type="submit" value="Rechercher">
			</form>


			<div class="tous_les_articles">

				<div class=un_article>

					<img src="url" /> <a href="/encheres/detailachatservlet"><p
							class="nom_article">afficher le nom de l'article</p></a>
					<p class="prix_initial">afficher le prix_initial de l'article</p>
					<p class="date_fin_encheres">afficher la date de fin de
						l'encheres article</p>
					<p class="retrait">afficher l'adresse de retrait</p>
					<p class="pseudo_vendeur">afficher le pseudo de vendeur</p>


				</div>

			</div>



			<!-- <p><input type="text" placeholder="Enter Email"></p>
<p><input type="password" placeholder="**********"></p>

 <div><input type="checkbox" checked="checked">
  <span class="checkmark">se souvenir de moi</span>
  </div>

  <div class="container column">
<div class="item"><p><input type="submit" value="connexion"></p></div>

</div>
</form>

    <DIV class="item" "><form name="main0" action="ajouterutilisateur" method="get">
        <input type="submit" value="cree un compte">
    </form></DIV>
 -->
</body>
</html>