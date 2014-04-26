<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<%@ page import="br.unirn.exemplos.dominio.Usuario"%>
<%@ page import="br.unirn.exemplos.dominio.Seguidor"%>
<%@ page import="br.unirn.exemplos.dao.SeguidorDao"%>
<%
	Usuario buscaUsuario = (Usuario) session
			.getAttribute("usuarioLogado");
	String usuarioId = String.valueOf(buscaUsuario.getId());
	String nome = buscaUsuario.getNome();
	String login = buscaUsuario.getLogin();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@include file="/jsp/template/head.jsp"%>

<body>

	<%@include file="/jsp/template/cabecalho.jsp"%>

	<div class="wrapper">
		<div class="side-left">
			<div class="box">
				<a href="#">
					<div class="top">
						<img src="/twitterUNIRN/img/icon-big-user.png" width="50" />
						<div class="nome"><%=nome%></div>
						<!-- .nome -->
						<div class="login">
							@<%=login%></div>
						<!-- .login -->
						<!-- .nome -->
					</div> <!-- .top -->
				</a>
				<div class="detalhe"></div>
				<!-- .detalhe -->
				<div class="publicacao">
					<form action="/twitterUNIRN/TimelineServlet" method="post">
						<input type="hidden" name="operacao" value="postar">
						<textarea name="post" title="Postar um novo Tweet..."
							maxlength="150" id="texto" onclick="this.value='';"
							onkeyup="limitaTextarea(this.value)"
							onblur="javascript:if (this.value=='') {this.value='Postar um novo Tweet...'};"></textarea>

						<div class="caracteres">
							Caracteres restantes: <span id="cont">150</span>
							<!-- Total de caracteres -->
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
			<div class="titulo">Pesquisa de usuários</div>
			<c:forEach var="usuario" items="${buscarUsuario}">
				<c:set var="teste" value="0"></c:set>
				<c:forEach var="seguidor" items="<%=buscaUsuario.getSeguidor() %>">
					<c:if test="${seguidor.seguido.id == usuario.id}">
						<c:set var="teste" value="1"></c:set>
					</c:if>
				</c:forEach>

				<a href="#">
					<div class="postagem">
						<div class="usuario">${usuario.nome }
							<span class="data">@${usuario.login}</span>
							<c:if test="${teste==0}">
								<form action="SeguidorServlet" method="post">
									<input type="hidden" name="operacao" value="follow" /> <input
										type="hidden" name="usuarioId" value="<%=usuarioId%>" /> <input
										type="hidden" name="followId" value="${usuario.id }" /> <input
										type="submit" value="follow" id="follow" />
								</form>
							</c:if>
							<c:if test="${teste==1}">
								<form action="SeguidorServlet" method="post">
									<input type="hidden" name="operacao" value="unfollow">
									<input type="hidden" name="usuarioId" value="<%=usuarioId%>" />
									<input type="hidden" name="followId" value="${usuario.id }" />
									<input type="submit" value="unfollow" id="unfollow" />
								</form>
							</c:if>
						</div>
						<!-- .usuario -->
					</div> <!-- .postagem -->
				</a>
			</c:forEach>

		</div>
		<!-- .side-right -->

		<%@include file="/jsp/template/rodape.jsp"%>

	</div>
	<!-- .wrapper -->

</body>
</html>