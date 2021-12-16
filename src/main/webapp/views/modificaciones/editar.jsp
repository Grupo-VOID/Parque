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
	
		  <div class="container" style="padding-top:1cm">
		  	<h1 style="padding-top:1cm;padding-bottom:1cm">Editar usuario</h1>
		  	<c:if test="${tematica == null}">
				<div class="alert alert-danger">
					<p>Se encontraron errores al actualizar el usuario.</p>
				</div>
			</c:if>
		  
		  	<form action="/Parque/views/modificaciones/editar.do" method="post">
				<input type="hidden" name="id" value="${tematica.id}">
				<jsp:include page="/views/modificaciones/formulario.jsp"></jsp:include>
			</form>
		  </div>	
	      <footer class="container secciones">
	        <jsp:include page="/partials/footer.jsp"></jsp:include>
	      </footer>
	    </body>
    </html>