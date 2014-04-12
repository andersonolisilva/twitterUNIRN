<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WEB I - Vetor</title>
<link rel="stylesheet" type="text/css"
	href="/twitterUNIRN/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div class="centralizar">
			<h1>Exercício JSTL - Vetor</h1>
			<c:set var="soma" value="0" />
			<c:forEach var="valor" items="${listaVetor}" varStatus="status">
  item ${status.index}: ${valor} <br />
				<c:set var="soma" value="${soma+valor}" />
			</c:forEach>
			<br> O valor total é:
			<fmt:formatNumber value="${soma}" pattern="R$ #,000.00#" />
			<br />
			<c:choose>
				<c:when test="${soma > 100}">
    O valor <fmt:formatNumber value="${soma}" pattern="R$ #,000.00#" /> é maior que 100.
  </c:when>
				<c:otherwise>
    O valor <fmt:formatNumber value="${soma}" pattern="R$ #,000.00#" /> é menor ou igual a 100.
  </c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>