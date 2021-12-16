<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <jsp:include page="/partials/head.jsp"></jsp:include>
</head>

<body>
    <header>
        <jsp:include page="/partials/nav.jsp"></jsp:include>
    </header>

	<main style="position: inherit; margin: 6rem 1.5rem;">

		<c:if test="${adquribles != null}">
			<h2>
				<c:out value="${usuario.nombre}"></c:out>, estas son las compras que realizaste</h2>
			<table class="table table-stripped table-hover">
				<thead>
					<th>Atracci&oacute;n</th>
					<th>Descripci&oacute;n</th>
					<th>Tem&aacute;tica</th>
					<th>Duraci&oacute;n</th>
					<th>Costo</th>
				</thead>
				<tbody>
					<c:forEach items="${adquribles}" var="adq">
						<tr>
							<td><c:out value="${adq.nombre}"></c:out></td>
							<td>Lorem ipsum dolor sit, amet consectetur adipisicing
								elit. Corrupti consequuntur dignissimos in et, magnam mollitia,
								voluptatibus nesciunt sapiente obcaecati consectetur.</td>
							<td><c:out value="${adq.tematica}"></c:out></td>
							<td><c:out value="${adq.tiempo}"></c:out></td>
							<td><c:out value="${adq.costo}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</main>

	<footer class="container secciones">
        <jsp:include page="/partials/footer.jsp"></jsp:include>
    </footer>
</body>

</html>