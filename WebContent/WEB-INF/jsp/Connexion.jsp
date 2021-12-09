<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<html>
<head>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style><%@include file="/style/responsive_style.css"%></style>

<title>Page connexion</title>
</head>
<body>

    <div class="background">
        <div class="shape"></div>
        <div class="shape"></div>
    </div>
    <form action="ConnexionUtilisateurServlet.java" method="POST">
        <h3>ENI-Enchéres</h3>

        <label for="username">Identifiant</label>
        <input type="text" placeholder="Email or Phone" id="username">

        <label for="password">Mot de passe</label>
        <input type="password" placeholder="Password" id="password">
		<div>
  
  
 
<label class="container">Se souvenir de moi
  <input type="checkbox" checked="checked">
  <span class="checkmark"></span>
</label>
<a href="Motdepasseoublié.html">Mot de passe oublié</a>
 <input type="submit" value="Connexion"/>
       
		 <button>Crée un compte</button>
       
    </form>

</body>
</html>
<!-- partial -->


