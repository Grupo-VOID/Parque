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
        <h1>Tipos de Atracciones</h1>
        <hr>
        
        <div class="container" style="padding: 1cm;">
        	<div class="mb-3">
		    	<a href="/Parque/views/modificaciones/crear.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nuevo Tipo de Atraccion </a>
	        </div>
        	<table class="table table-bordered table-hover" style="text-align: justify;">
	            <thead>
	                <tr style="text-align: center;">
	                    <th scope="col">id</th>
	                    <th scope="col">Tematica</th>
	                    <th scope="col">Acciones</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${tematica}" var="tematica"> 
	            		<tr style="text-align:center">
	            			<td><c:out value="${tematica.id}"></c:out></td>
	            			<td><strong><c:out value="${tematica.tematica}"></c:out></strong></td>
	            			<td>
	            				<a href="/Parque/views/modificaciones/editar.do?id=${tematica.id}"
									lass="btn btn-light rounded-0" role="button"><i class="fas fa-pencil-alt"></i></a>
								<!--  <a href="/Parque/views/modificaciones/eliminar.do?id=${tematica.id}"
									class="btn btn-danger rounded" role="button"><i class="fas fa-trash-alt"></i></a></td> -->
	            		</tr>
	            	</c:forEach>
	            </tbody>
	        </table>
        </div>
        </div>
      <footer class="container secciones">
        <jsp:include page="/partials/footer.jsp"></jsp:include>
      </footer>
    </body>
    </html>