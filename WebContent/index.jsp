<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>WEB I - Twitter</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>

	<div class="topo">
		<div class="topo-central">
			<div class="left">
				<a href="index.jsp" title="Página Inicial">Sistema</a>
			</div>
			<!-- .left -->

			<div class="right">@author Anderson Silva e Daniel Olinto</div>
			<!-- .right -->
		</div>
		<!-- .topo-central -->
	</div>
	<!-- .topo -->

	<div class="wrapper">

		<div class="side-left">
			<div class="titulo-principal">
				<h2>Bem-vindo ao Sistema.</h2>
				<p>Desenvolvido por Anderson Silva e Daniel Olinto para a
					disciplina de Desenvolvimento WEB 1.</p>
				<br>
				<h1>${mensagemCadastro }</h1>
			</div>
			<div class="imagem-principal">
				<img alt="logo" src="img/logo-uni.png" width="240" />
			</div>
		</div>
		<!-- .side-left -->
		<div class="side-right">
			<div class="side-right-top">
				<form action="LoginServlet" method="post">
					<input type="hidden" name="operacao" value="logar" />
					<div class="acesso">
						<input type="text" name="login" value="Nome de usuário"
							onclick="this.value='';"
							onblur="javascript:if (this.value=='') {this.value='Nome de usuário'};" />
						<input type="password" name="senha" value="Senha"
							onclick="this.value='';"
							onblur="javascript:if (this.value=='') {this.value='Senha'};" />

						<div class="acesso-left">
							<a href="#" title="Recupere sua senha">Esqueceu sua senha?</a>
						</div>
						<!-- .acesso-left -->
						<div class="acesso-right">
							<input type="submit" value="Entrar" />
						</div>
						<!-- .acesso-right -->
					</div>
					<!-- .acesso -->
				</form>
			</div>
			<form action="UsuarioServlet" method="post">
				<input type="hidden" name="operacao" value="cadastrar" />
				<!-- .side-right-top -->
				<div class="side-right-bottom">
					<div class="titulo">Novo no Sistema? Cadastra-se</div>
					<!-- .titulo -->
					<div class="cadastro">
						<input type="text" name="nome" value="Nome completo"
							onclick="this.value='';"
							onblur="javascript:if (this.value=='') {this.value='Nome completo'};" />
						<input type="text" name="descricao" value="Descrição pessoal"
							onclick="this.value='';"
							onblur="javascript:if (this.value=='') {this.value='Descrição pessoal'};" />
						<input type="text" name="login" value="Login"
							onclick="this.value='';"
							onblur="javascript:if (this.value=='') {this.value='Login'};" />
						<input type="password" name="senha" value="Senha"
							onclick="this.value='';"
							onblur="javascript:if (this.value=='') {this.value='Senha'};" />
						<input type="submit"
							value="Cadastre-se no Sistema" />
					</div>
					<!-- .cadastro -->
				</div>
				<!-- .side-right-bottom -->
			</form>
		</div>
		<!-- .side-right -->

	</div>
	<!-- .wrapper -->

	<div class="rodape">UNI-RN - Especialização em Desenvolvimento de
		Sistemas Corporativos - Desenvolvimento WEB I - Turma 08</div>
	<!-- ."rodape" -->

</body>
</html>