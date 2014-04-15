<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ page import="br.unirn.exemplos.dominio.Usuario" %>	
<% Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
String nome = usuario.getNome();
String login = usuario.getLogin();
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@include file="/jsp/template/head.jsp" %>

<body>

	<%@include file="/jsp/template/cabecalho.jsp" %>

	<div class="wrapper">
		<div class="side-left">
			<div class="box">
				<a href="#">
					<div class="top">
						<img src="/twitterUNIRN/img/icon-big-user.png" width="50" />
						<div class="nome"><%= nome %></div>
						<div class="login">@<%= login %></div>
						<!-- .nome -->
					</div> <!-- .top -->
				</a>
				<div class="detalhe">
					<div class="titulo">
						tweets
					</div>
					<div class="numeracao">
						2
					</div>
				</div>
				<!-- .detalhe -->
				<div class="publicacao">
					<form action="/twitterUNIRN/TimelineServlet" method="post">
						<input type="hidden" name="operacao" value="postar">
						<textarea name="post" title="Postar aqui" maxlength="150" id="texto"
							onclick="this.value='';" onkeyup="limitaTextarea(this.value)"
							onblur="javascript:if (this.value=='') {this.value='Publique um novo Tweet...'};"></textarea>
						
						<div class="caracteres">
							Caracteres restantes: <span id="cont">150</span> <!-- Total de caracteres -->
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
				<c:forEach var="valor" items="${listaPost}">
					<div class="conteudo">
						<div class="usuario">
							<b>${valor.usuario.nome }</b>
							<span style="font-size: 12px; color: #CCC;">
								@${valor.usuario.login }
								- <fmt:formatDate value="${valor.dataCadastro }" pattern="dd/MM/yyyy HH:mm:ss"/>
							</span>
						</div>
						
						${valor.mensagem }
					</div>
				</c:forEach>
			</form>
		</div>
		<!-- .side-right -->

		<%@include file="/jsp/template/rodape.jsp" %>

	</div>
	<!-- .wrapper -->

</body>
</html>