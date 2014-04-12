<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.unirn.exemplos.dominio.Usuario" %>	
<% Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
String nome = usuario.getNome();
String login = usuario.getLogin();
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEB I - <%= nome%></title>
<link rel="stylesheet" type="text/css" href="/ExemplosUNIRN/css/interno.css">
</head>
<body>

	<%@include file="/jsp/template/cabecalho.jsp" %>

	<div class="wrapper">
		<div class="side-left">
			<div class="box">
				<a href="#">
					<div class="top">
						<img src="/exemplosUNIRN/img/icon-big-user.png" width="50" />
						<div class="nome"><%=nome %></div>
						<!-- .nome -->
					</div> <!-- .top -->
				</a>
				<div class="detalhe"></div>
				<!-- .detalhe -->
				<div class="publicacao">
					<form action="/ExemplosUNIRN/TimelineServlet" method="post">
						<input type="hidden" name="operacao" value="postar">
						<textarea name="post" title="Postar aqui" maxlength="150" id="texto"
							onclick="this.value='';" onkeyup="limitaTextarea(this.value)"
							onblur="javascript:if (this.value=='') {this.value='Publique aqui'};"></textarea>
						<div class="caracteres">
							Caracteres restantes: <span id="cont">150</span>
						</div>
						
						<input type="submit" value="Postar" id="postar" />
					</form>
				</div>
				<!-- .publicacao -->
			</div>
			<!-- .box -->
			<div class="box2"></div>
			<!-- .box2 -->
		</div>
		<!-- .side-left -->
		<div class="side-right">
			<form action="TimelineServlet" method="post">
				<div class="titulo">Tweets</div>
			</form>
		</div>
		<!-- .side-right -->

		<%@include file="/jsp/template/rodape.jsp" %>

	</div>
	<!-- .wrapper -->

</body>
</html>