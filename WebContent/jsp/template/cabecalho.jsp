<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.unirn.exemplos.dominio.Usuario"%>
<%
	Usuario cabecalho_usuario = (Usuario) session.getAttribute("usuarioLogado");
	String cabecalho_usuarioId = String.valueOf( cabecalho_usuario.getId() );
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<div class="topo">
		<div class="topo-central">
			<div class="left">
				<ul>
					<li><a href="/twitterUNIRN/TimelineServlet" class="active"
						title="Início"><img src="/twitterUNIRN/img/icon-home.png" /> Início</a></li>
<!--  
					<li>
					<a href="#" title="Descobrir"><img
							src="/twitterUNIRN/img/icon-user.png" /> Buscar Usuario</a>
							</li>
-->							
					<!-- <li><a href="#" title="Conta"><img
							src="/twitterUNIRN/img/icon-user.png" /> Conta</a></li> -->
				</ul>
			</div>
			<!-- .left -->
			<div class="right">
				<ul>
					<li>
						<form action="/twitterUNIRN/UsuarioServlet" method="post">
						<input type="hidden" name="operacao" value="buscarUsuario">
						<input type="hidden" name="usuario_id" value="<%=cabecalho_usuarioId%>">
							<input type="text" name="texto" value="Buscar usuário"
							onclick="this.value='';"
							onblur="javascript:if (this.value=='') {this.value='Buscar usuário'};" />
						</form>
					</li>
					<li><a href="/twitterUNIRN/LoginServlet?operacao=logout" title="Sair"><img
							src="/twitterUNIRN/img/icon-exit.png" /> Sair</a></li>
				</ul>
			</div>
			<!-- .right -->
		</div>
		<!-- .topo-central -->
	</div>
	<!-- .topo -->

</body>
</html>