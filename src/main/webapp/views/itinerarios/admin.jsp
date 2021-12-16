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

	<main style="position: inherit; margin: 6rem 1.5rem;">
		<c:choose>
			<c:when test="${usuarios != null}">
				<h2>Itinerarios de todos los usuarios</h2>
				<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<th>Id</th>
						<th>Username</th>
						<th>Dinero disponible</th>
						<th>Tiempo disponible</th>
						<th>Tem&aacute;tica</th>
						<th>Rol</th>
					</thead>
					<tbody>
						
						<c:forEach items="${usuarios}" var="user">
							<tr>
								<td><c:out value="${user.id}"></c:out></td>
								<td><c:out value="${user.username}"></c:out></td>
								<td><c:out value="${user.monedasDisponibles}"></c:out></td>
								<td><c:out value="${user.tiempoDisponible}"></c:out></td>
								<td><c:out value="${user.tematica}"></c:out></td>
								<td>
									<c:choose>
		            					<c:when test="${user.esAdministrador() != true}">
		            						Visitante
		            					</c:when>
		            					<c:otherwise>
		            						Administrador
		            					</c:otherwise>
		            				</c:choose>
								</td>
							</tr>
							
							<c:choose>
							<c:when test="${user.getListaAdquiribles().isEmpty()}"></c:when>
							<c:otherwise>
								<tr>
								<td colspan="6">
								<div class="table-responsive">
								<table class="table table-sm">
									<thead>
										<th>Atracci&oacute;n</th>
										<th>Tem&aacute;tica</th>
										<th>Duraci&oacute;n</th>
										<th>Costo</th>
									</thead>
									<tbody>
										<c:forEach items="${user.getListaAdquiribles()}" var="adq">
											<tr class="table-info">
												<td><c:out value="${adq.nombre}"></c:out></td>
												<td><c:out value="${adq.tematica}"></c:out></td>
												<td><c:out value="${adq.tiempo}"></c:out></td>
												<td><c:out value="${adq.costo}"></c:out></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								</div>
								</td>
								</tr>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</tbody>
				</table>
				</div>
			</c:when>
		
			<c:otherwise>
				<h4>No hay itinerarios</h4>
			</c:otherwise>
		</c:choose>
		
		


	</main>

	<footer class="container secciones">
		<jsp:include page="/partials/footer.jsp"></jsp:include>
	</footer>
</body>

</html>