<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
<a href="<%="/encheres/consulteraccueilconnexion"%>"><img class="ico"  alt="Coup CHI" src="<%=getServletContext().getContextPath()%>/images/icone.png"></a>

	<%
      if (session != null) {
         if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            out.print("Hello, " + name + "  Welcome to ur Profile");
         } else {
            response.sendRedirect("/WEB-INF/jsp/AccountUtil.jsp");
         }
      }
   %>
	</br>
	</br>
	<form action="/encheres/Logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>
l>
