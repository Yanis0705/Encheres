<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style media="screen">
body{
 background-color:#6E6E6E;
 font-family:roboto;
}
body p{
 text-align:center;
 margin-top:30px;
 font-size:40px;
 color:#E6E6E6;
}
table{
 border-radius:3px;
 box-shadow:0px 0px 10px 0px;
 padding:10px;
 background-color:#848484;
}
table td{
 font-size:20px;
 color:#E6E6E6;
}
table th{
 visibility:hidden;
 display:none;
}
input[type="text"]{
 width:200px;
 height:35px;
 border:1px solid silver;
 border-radius:3px;
 font-size:17px;
 padding:5px;
}
This style is for screen size having minimum width of 180px and maximum width of 679px.

@media only screen and (min-width:180px) and (max-width:679px)
{
table{
 width:100%;
}
table .column1{
 visibility:hidden;
 display:none;
}
table th{
 visibility:visible;
 display:block;
 font-size:20px;
 color:#E6E6E6;
}
input[type="text"]{
 width:80%;
 margin-left:10%;
}

boutonsModifier{
	display : flex;
	justify-content:center;
	margin: 20px, 0;
}

h4{
	display:flex;
	justify-content: center;
}
}

</style>
</head>
<body>
  
  <h3>Troc-enchères.org</h3>
  
   <h4>Mon Profil</h4>
   
  <form action="AjouterUtilisateurServlet.java" method="POST">
<table align=center cellspacing=10>

 <tr>
  <td class="column1">Pseudo:</td>
  <td><input type="text" placeholder="Pseudo" name="pseudo"></td>
 </tr>

 
 <tr>
  <td class="column1">Nom:</td>
  <td><input type="text" placeholder="Nom" name="nom"></td>
 </tr>


 <tr>
  <td class="column1">Prenom:</td>
  <td><input type="text" placeholder="Prénom" name="prenom"></td>
 </tr>


 <tr>
  <td class="column1">Email :</td>
  <td><input type="text" placeholder="Email" name="email"></td>
 </tr>


 <tr>
  <td class="column1">Téléphone :</td>
  <td><input type="text" placeholder="Téléphone" name="telephone"></td>
 </tr>


 <tr>
  <td class="column1">Rue :</td>
  <td><input type="text" placeholder="Rue" name="rue"></td>
 </tr>


 <tr>
  <td class="column1">Code Postal:</td>
  <td><input type="text" placeholder="Code Postal" name="code_postal"></td>
 </tr>
 

 <tr>
  <td class="column1">Ville :</td>
  <td><input type="text" placeholder="Ville" name="ville"></td>
 </tr>
 

 <tr>
  <td class="column1">Mot de passe :</td>
  <td><input type="password" placeholder="Mot de passe" name="mot_de_passe"></td>
 </tr>
 

 <tr>
  <td class="column1">Confirmation :</td>
  <td><input type="password" placeholder="Confirmation" name="mot_de_passe"></td>
 </tr>
 
</table>

<div class="boutonsModifier">
	<div>
		<a href="<%=getServletContext().getContextPath()%>/Utilisateur.jsp">
			<button type="submit"  >Enregistrer</button>
		</a>
	</div>
	
	<div>
		<a href="<%=getServletContext().getContextPath()%>/Connexion.jsp">
			<button type="submit"  >Supprimer mon compte</button>
		</a>
	</div>
	<div>
		<a href="<%=getServletContext().getContextPath()%>/Utilisateur.jsp">
			<button type="submit"  >Retour</button>
		</a>
	</div>
</div>
</form>
</body>
</html>