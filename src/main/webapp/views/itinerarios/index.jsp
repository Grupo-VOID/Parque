<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <jsp:include page="/partials/head.jsp"></jsp:include>
  <link rel="stylesheet" href="/Parque/assets/css/itinerario.css">
</head>

<body>
    <header>
        <jsp:include page="/partials/nav.jsp"></jsp:include>
    </header>

	<main>
 		<c:choose>
			<c:when test="${adquribles != null}">
				<h2>
					<c:out value="${usuario.nombre}"></c:out>, estas son las compras que realizaste</h2>
				<table class="table table-stripped table-hover">
					<thead>
						<th>Atracci&oacute;n</th>
						<th>Tem&aacute;tica</th>
						<th>Duraci&oacute;n</th>
						<th>Costo</th>
					</thead>
					<tbody>
						<c:forEach items="${adquribles}" var="adq">
							<tr>
								<td><c:out value="${adq.nombre}"></c:out></td>
								<td><c:out value="${adq.tematica}"></c:out></td>
								<td><c:out value="${adq.tiempo}"></c:out></td>
								<td><c:out value="${adq.costo}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			
			<c:otherwise>
				<div class="contenedor">
					<h2><c:out value="${usuario.nombre}"></c:out>, a&uacute;n no has realizado ninguna compra.</h2>
					<h4><a href="/Parque/views/sugerencia.do">Ve a la pestaña Atracciones</a>
							para agregarlas al itinerario.</h4>
				</div>
			</c:otherwise>
		</c:choose>
	</main>

	<footer class="container secciones">
        <jsp:include page="/partials/footer.jsp"></jsp:include>
    </footer>
</body>

</html>