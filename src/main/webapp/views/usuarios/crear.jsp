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
		  	<h1 style="padding-top:1cm;padding-bottom:1cm">Crear usuario</h1>
		  	<c:if test="${usuarioTemp != null && !usuarioTemp.esValido()}">
				<div class="alert alert-danger">
					<p>Se encontraron errores al crear el usuario.</p>
				</div>
			</c:if>
		  
		  	<form action="/Parque/views/usuarios/crear.do" method="post">
				<jsp:include page="/views/usuarios/formulario.jsp"></jsp:include>
			</form>
		  </div>	
	      <footer class="container secciones">
	        <jsp:include page="/partials/footer.jsp"></jsp:include>
	      </footer>
	    </body>
    </html>