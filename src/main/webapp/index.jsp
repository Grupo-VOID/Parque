<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <jsp:include page="partials/head.jsp"></jsp:include>
</head>

<body>
    <header>
        <jsp:include page="partials/nav.jsp"></jsp:include>
    </header>
    <jsp:include page="partials/carousel.jsp"></jsp:include>
    
    <footer class="container secciones">
        <jsp:include page="partials/footer.jsp"></jsp:include>
    </footer>
</body>
</html>