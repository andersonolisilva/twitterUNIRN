<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WEB I - Exercício EL</title>
<link rel="stylesheet" type="text/css"
	href="/twitterUNIRN/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div class="centralizar">
			<h1>Exercício EL</h1>

			<form action="/twitterUNIRN/ExercicioELServlet" method="post">
				Valor 01 : <input type="text" name="valor1" id="valor1" /><br />
				Valor 02 : <input type="text" name="valor2" id="valor2" /><br /> <br />
				<input type="submit" name="Calcular" value="Calcular" />
			</form>
		</div>
	</div>

	<c:choose>
		<c:when test="${valorA == ''}">
			<div id="wrapper">
				<div class="centralizar">
					<h1>Preencha pelo menos o valor 1 para exibir o cálculo.</h1>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div id="wrapper">
				<div class="centralizar">
					<h1>Resultado do processamento de dados</h1>
					Valor 01 : ${valorA}<br /> Valor 02 : ${valorB}<br /> <br />
					<br />
				</div>
				<c:set var="index" value="1" />
				<c:forEach var="valor" items="${listaVetor}">
					<c:choose>
						<c:when test="${index == 1}">
							<c:set var="v1" value="${valor}"></c:set>
						</c:when>
						<c:when test="${index == 2}">
							<c:set var="v2" value="${valor}"></c:set>
						</c:when>
						<c:when test="${index == 3}">
							<c:set var="v3" value="${valor}"></c:set>
						</c:when>
					</c:choose>
					<c:set var="index" value="${index+1}" />
				</c:forEach>

				<div class="centralizar">
					Na JSP, com EL: <br />
					<br /> -Exibir primeiro e segundo elementos do vetor;<br />
					Primeiro elemento:
					${v1}<br /> Segundo elemento: ${v2}<br /><br />
					
					-Somar os três valores do vetor: (${v1} + ${v2 } + ${v3 }) = ${v1+v2+v3}<br /><br /> 
					-Multiplicar os três valores do vetor: (${v1} x ${v2 } x ${v3 }) = ${v1*v2*v3}<br /><br />
					
					-Exibir o resultado da comparação se: <br />
					  -O primeiro valor ${v1 } é maior do que zero: 
					  <c:choose>
					   <c:when test="${v1>0 }">Sim</c:when>
					   <c:otherwise>Não</c:otherwise>
					  </c:choose> <br />
					  -O segundo valor ${v2 } é menor do que zero:
					   <c:choose>
					   <c:when test="${v2<0 }">Sim</c:when>
					   <c:otherwise>Não</c:otherwise>
					  </c:choose> <br /><br />
					  
					 -Exibir o resultado da comparação se: <br />
					  -O primeiro valor ${v1 } é maior do que zero: 
					  <c:choose>
					   <c:when test="${v1>0 }">Sim</c:when>
					   <c:otherwise>Não</c:otherwise>
					  </c:choose> <br /> 
					  -O segundo valor ${v2 } é maior do que zero: 
					  <c:choose>
					   <c:when test="${v2>0 }">Sim</c:when>
					   <c:otherwise>Não</c:otherwise>
					  </c:choose> <br /><br />

				</div>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>