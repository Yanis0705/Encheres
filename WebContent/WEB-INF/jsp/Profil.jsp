<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="fr.eni.zylim.encheres.bo.Utilisateur"%>

<%@page import="fr.eni.zylim.encheres.bll.UtilisateurManager"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style><%@include file="/style/Profil.css"%></style>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<title>Profil</title>
<a href="<%="/encheres/consulteraccueilconnexion"%>"><img
	class="ico"
	src="<%=getServletContext().getContextPath()%>/images/icone.png"></a>
</head>
<%
	Utilisateur utilisateur;
%>
<body>


	<h3>
		<a href="/WEB-INF/jsp/Inscription.jsp">Troc-encheres.org</a>
	</h3>

	<h4>votre profile</h4>
	<br>
	<%
		Utilisateur user = (Utilisateur) request.getAttribute("userprofile");
	%>



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

	</br>
	</br>



	<form>


		<div class="Profil">


			<table align=center cellspacing=10>

				<tr>
					<td class="column1">Pseudo:</td>
					<td>${userlogin.pseudo}</td>
				</tr>


				<tr>
					<td class="column1">Nom:</td>
					<td>${userlogin.nom}</td>
				</tr>


				<tr>
					<td class="column1">Prenom:</td>
					<td>${userlogin.prenom}</td>
				</tr>


				<tr>
					<td class="column1">Email :</td>
					<td>${userlogin.email}</td>
				</tr>


				<tr>
					<td class="column1">Telephone :</td>
					<td>${userlogin.telephone}</td>
				</tr>


				<tr>
					<td class="column1">Rue :</td>
					<td>${userlogin.rue}</td>
				</tr>


				<tr>
					<td class="column1">Code Postal:</td>
					<td>${userlogin.code_postal}</td>
				</tr>


				<tr>
					<td class="column1">Ville :</td>
					<td>${userlogin.ville}</td>
				</tr>

			</table>
		</div>

		<div></div>

		<DIV>
			<form action="modifierutilisateur" action="post">
				<button class="btn-enregistrer">Modifier</button>
			</form>
			<form name="main0" action="modifierutilisateur" method="post">
				<input type="submit" value="Modifierr">
			</form>

		</DIV>
</body>
</html>