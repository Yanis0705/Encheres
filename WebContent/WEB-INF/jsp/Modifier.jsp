<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="fr.eni.zylim.encheres.bo.Utilisateur"%>
	
<%@page import="fr.eni.zylim.encheres.bll.UtilisateurManager"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style>
<%@ include file="/style/Modifier.css"%>
</style>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<title>Modifier</title>


</head>
<body>

	<h3>
		<a href="/WEB-INF/jsp/Utilisateur.jsp">Troc-enchères.org</a>
	</h3>
	<h4>Modifier Profil</h4>
<a href="<%="/encheres/consulteraccueilconnexion"%>"><img class="ico" src="<%=getServletContext().getContextPath()%>/images/icone.png"></a>
	<div class=Inscription>
		
		<form action="<c:url value="/UpdateUtilisateur" />" method="post">
			<div class="formulaire">

				<table align=center cellspacing=10>

					<tr>
						<td class="column1">Pseudo:</td>
						<td><input type="text" placeholder="${userlogin.pseudo}" name="pseudo"></td>
					</tr>


					<tr>
						<td class="column1">Nom:</td>
						<td><input type="text" placeholder="${userlogin.nom}" name="nom"></td>
					</tr>


					<tr>
						<td class="column1">Prenom:</td>
						<td><input type="text" placeholder="${userlogin.prenom}" name="prenom"></td>
					</tr>


					<tr>
						<td class="column1">Email :</td>
						<td><input type="text" placeholder="${userlogin.email}" name="email"></td>
					</tr>


					<tr>
						<td class="column1">Téléphone :</td>
						<td><input type="text" placeholder="${userlogin.telephone}"
							name="telephone"></td>
					</tr>


					<tr>
						<td class="column1">Rue :</td>
						<td><input type="text" placeholder="${userlogin.rue}" name="rue"></td>
					</tr>


					<tr>
						<td class="column1">Code Postal:</td>
						<td><input type="text" placeholder="${userlogin.code_postal}"
							name="code_postal"></td>
					</tr>


					<tr>
						<td class="column1">Ville :</td>
						<td><input type="text" placeholder="${userlogin.ville}" name="ville"></td>
					</tr>


					<tr>
						<td class="column1">Mot de passe :</td>
						<td><input type="password" placeholder="${userlogin.mot_de_passe}"
							name="mot_de_passe"></td>
					</tr>


					<tr>
						<td class="column1">Confirmation :</td>
						<td><input type="password" placeholder="${userlogin.mot_de_passe}"
							name="mot_de_passe"></td>
					</tr>
					<tr>
						<td class="column1"></td>
						<td><input type="hidden" placeholder="${userlogin.no_utilisateur}"
							name="no_utilisateur"></td>
					</tr>
					<tr>
					<td class="column1">credit :</td>
					<td><p${userlogin.credit} name="credit"> </td>
				</tr>
				</table>
				
			</div>
			
				<button type="submit" class="btn-enregistrer">Enregistrer</button>
		</form>


		<div class="boutonsEnregistreSupprimerrAnnuler">
			<form action="<c:url value="/supprimerutilisateur" />" method="post">	
			
			<input type="submit" value="delete" onclick="return confirm('Êtes-vous sûr de vouloir supprimer votre compte')" />
			</form>
			<form class="boutonsEnregistreSupprimerrAnnuler"
				action="connexionutilisateur">
				<button class="btn-retour">Retour</button>
			</form>

		</div>



	</div>



</body>
</html>