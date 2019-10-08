<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Recuperar senha</title>
</head>
<body>
    <p>Digite o e-mail do cadastro e a resposta inserida</p>
    <form action="recuperarSenha" method="post">
        <input type="text" name="filme" placeholder="Digite sua resposta de segurança" required>
        <input type="email" name="email" placeholder="digite seu email" required>
        <input type="password" name="novaSenha" placeholder="Digite sua nova senha" required>
        <button>Verificar</button>
    </form>
    
     	<c:if test="${not empty emailInexistente}">
	<%=request.getAttribute("emailInexistente") %>
	</c:if>
<c:choose>
	<c:when test="${valor != null }">
		<p>Digite sua nova senha</p>
		<form action="novaSenha" method="post">
        <input type="text" name="filme" placeholder="Digite sua resposta de segurança" required>
        <button>Verificar</button>
    </form>
	</c:when>
	<c:otherwise>
	 <%=request.getAttribute("erro")%>
	</c:otherwise>
</c:choose>
</body>
</html>