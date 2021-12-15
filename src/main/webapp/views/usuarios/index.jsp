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

      <div class="container-fluid content-row" style="padding-top: 2cm">
      
      	<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errores != null}">
						<ul>
							<c:forEach items="${errores}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>
        <hr>
        <h1>Usuarios</h1>
        <hr>
        <div class="container" style="padding: 2cm;">
        	<div class="mb-3">
		    	<a href="/Parque/views/usuarios/crear.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario </a>
	        </div>
        	<table class="table table-bordered table-hover" style="text-align: justify;">
	            <thead>
	                <tr style="text-align: center;">
	                    <th scope="col">id</th>
	                    <th scope="col">Nombre</th>
	                    <th scope="col">Tematica Favorita</th>
	                    <th scope="col">Monedas Disponibles</th>
	                    <th scope="col">Tiempo Disponible</th>
	                    <th scope="col">Rol</th>
	                    <th scope="col">Acciones</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${usuarios}" var="usuarioTemp"> 
	            		<tr style="text-align:center">
	            			<td><c:out value="${usuarioTemp.id}"></c:out></td>
	            			<td style="text-align:left"><strong><c:out value="${usuarioTemp.nombre}"></c:out></strong></td>
	            			<td><c:out value="${usuarioTemp.tematica}"></c:out></td>
	            			<td><c:out value="${usuarioTemp.monedasDisponibles}"></c:out></td>
	            			<td><c:out value="${usuarioTemp.tiempoDisponible}"></c:out></td>
	            			<td>
	            				<c:choose>
	            					<c:when test="${usuarioTemp.esAdministrador() != true}">
	            						Visitante
	            					</c:when>
	            					<c:otherwise>
	            						Administrador
	            					</c:otherwise>
	            				</c:choose>
	            			</td>
	            			<td>
	            				<c:if test="${usuario.esAdministrador() && (!usuarioTemp.esAdministrador() || usuarioTemp.id != usuario.id)}">
									<a href="/Parque/views/usuarios/editar.do?id=${usuarioTemp.id}"
										class="btn btn-light rounded-0" role="button"><i class="fas fa-pencil-alt"></i></a>
									<a href="/Parque/views/usuarios/eliminar.do?id=${usuarioTemp.id}"
										class="btn btn-danger rounded" role="button"><i class="fas fa-trash-alt"></i></a>
								</c:if>
	            			</td>
	            		</tr>
	            	</c:forEach>
	            </tbody>
	        </table>
        </div>
      <footer class="container secciones">
        <jsp:include page="/partials/footer.jsp"></jsp:include>
      </footer>
    </body>
    </html>