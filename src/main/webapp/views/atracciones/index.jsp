<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<header>
        <jsp:include page="/partials/nav.jsp"></jsp:include>
    </header>
    
    <div class="container">
    	<hr>
    	<h1 style="padding-top:2cm"> Promociones </h1>
     	<hr>
    	<h1> Atracciones </h1>
     	<hr>
        <jsp:include page="/partials/tarjetas.jsp"></jsp:include>
    </div>
    
    <footer class="container secciones">
        <jsp:include page="/partials/footer.jsp"></jsp:include>
    </footer>
</body>
</html>