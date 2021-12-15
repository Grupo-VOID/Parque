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
		  	<h1 style="padding-top:1cm;padding-bottom:1cm">Crear atraccion</h1>
		  	<c:if test="${atraccion != null && !atraccion.esValida()}">
				<div class="alert alert-danger">
					<p>Se encontraron errores al actualizar la atracción.</p>
				</div>
			</c:if>
		  
		  	<form action="/Parque/views/atracciones/crear.do" method="post">
				<jsp:include page="/views/atracciones/formulario.jsp"></jsp:include>
			</form>
		  </div>	
	      <footer class="container secciones">
	        <jsp:include page="/partials/footer.jsp"></jsp:include>
	      </footer>
	    </body>
    </html>