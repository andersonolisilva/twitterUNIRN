<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.unirn.exemplos.dominio.Usuario" %>	
<% Usuario usuarioHead = (Usuario)session.getAttribute("usuarioLogado");
String nomeHead = usuarioHead.getNome();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEB I - <%= nomeHead %></title>
<link rel="stylesheet" type="text/css" href="/twitterUNIRN/css/interno.css">

<!-- Contador de caracteres da postagem -->
<script type="text/javascript">
function limitaTextarea(valor) {
	quant = 150; /* Total de caracteres */
	total = valor.length;

	if(total <= quant) {
		resto = quant - total;
		document.getElementById('cont').innerHTML = resto;
	} else {
		document.getElementById('texto').value = valor.substr(0,quant);
	}
}
</script>
</head>

</html>