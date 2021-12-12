<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>

<body>
	<header>
		<jsp:include page="partials/nav.jsp"></jsp:include>
	</header>

	<div class="container">
		<hr>
		<jsp:include page="partials/tarjetas.jsp"></jsp:include>
	</div>
	<footer class="container secciones">
		<jsp:include page="partials/footer.jsp"></jsp:include>
	</footer>
</body>
</html>