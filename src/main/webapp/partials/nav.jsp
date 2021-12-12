<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<nav class="navbar fixed-top navbar-expand-md navbar-dark bg-dark mb-4">
            <div class="container">
                <a class="navbar-brand" href="#">Turismo en la Tierra Media</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item active">
                            <a class="nav-link" href="/Parque/index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Parque/views/atracciones/index.jsp">Atracciones</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Pricing</a>
                        </li>
                    </ul>
                    <c:choose>
                        <c:when test="${usuario != null}">
                            <a href="logout" class="btn btn-primary" role="button">Logout</a>
                        </c:when>
                        <c:otherwise>
                            <a href="login.jsp" class="btn btn-primary" role="button">Login</a>
                        </c:otherwise>
                    </c:choose>
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                <c:out value="${usuario.nombre}"></c:out>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Monedas disponibles</a>
                                <a class="dropdown-item" href="#">Tiempo Disponible</a>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>