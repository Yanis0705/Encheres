<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style>
<%@ include file ="/style/responsive_style_marion.css"%></style>

<title>Detail Achat</title>
</head>
<body>
	<div id="wrapper">

		<div class="form_div">
			<p class="form_label">
				<a href="#">Troc-enchères</a>
			</p>
			<form method="post" action="">
			<a href="<%="/encheres/consulteraccueilconnexion"%>"><img class="ico"  src="<%=getServletContext().getContextPath()%>/images/icone.png"></a>
				<div class="title">
					<p>Détail vente</p>
				</div>

				<p>
					<img src="/*****" class="picture" alt="<%= request.getAttribute("NomArticle")%>">
				</p>
				<table style="width: 100%">
					<tbody>
						<tr>
							<th scope="row">Description :</th>
							<td><%= request.getAttribute("Description")%></td>
						</tr>
						<tr>
							<th scope="row">Catégorie :</th>
							<td><%= request.getAttribute("Categorie")%></td>
						</tr>
						<tr>
							<th scope="row">Meilleure offre :</th>
							<td>210 points par Bob</td>
						</tr>
						<tr>
							<th scope="row">Mise à prix :</th>
							<td><%= request.getAttribute("MiseAPrix")%> points</td>
						</tr>
						<tr>
							<th scope="row">Fin de l'enchère :</th>
							<td><%= request.getAttribute("DateFinEnchere")%></td>
						</tr>
						<tr>
							<th scope="row">Retrait :</th>
							<td><%= request.getAttribute("RueRetrait")%><br><%= request.getAttribute("CodePostalRetrait")%> <%= request.getAttribute("VilleRetrait")%>
							</td>
						</tr>
						<tr>
							<th scope="row">Vendeur :</th>
							<td><%= request.getAttribute("PseudoVendeur")%></td>
						</tr>
						<%
						if(request.getAttribute("NoUtilisateurActuel") != request.getAttribute("NoUtilisateurVendeur")) {
						%>
							<tr>
								<th scope="row">Ma proposition :</th>
								<td><input name="NouveauMontantEnchere"  type="number" min="0" max="100000"></td>
							</tr>
						</tbody>
					</table>
					<div class="container column">
						<div class="item">
						<p>
							<a href ="/EncherirVente" class="nounderline">
							<input type="submit" value="Enchérir" >
							</a>
						</p>
					<% } else   { %>
				</tbody>
				</table>
				<div class="container column">
					<div class="item">
					<p>
						<a href ="/SupprimerVente" class="nounderline">
						<input type="button" value="Annuler la vente">
						</a>
					</p>
					<p>
					<% } %>
						<a href ="/WEB-INF/jsp/Utilisateur.jsp" class="nounderline">
						<input type="button" value="Retour" >
						</a>
					</p>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>