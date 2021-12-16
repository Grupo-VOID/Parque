<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<nav class="navbar fixed-top navbar-expand-md navbar-dark bg-dark mb-4">
            <div class="container">
                <a class="navbar-brand" href="/Parque/index.jsp">VOID Experiencias Inmersivas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      					<span class="navbar-toggler-icon"></span>
    			</button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="/Parque/views/sugerencia.do">Atracciones</a>
                        </li>
<<<<<<< HEAD
                        <c:choose>
                        	<c:when test="${usuario.esAdministrador()}">
                        		<li class="nav-item"><a class="nav-link"
								href="/Parque/views/itinerarios/admin.do">Itinerarios</a></li>
                        	</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="/Parque/views/itinerarios/index.do">Mi itinerario</a></li>
						</c:otherwise>
						</c:choose>
=======
>>>>>>> b24d98f2b251bde343348abf0e4a7f241a716027
                        <c:if test="${usuario.esAdministrador()}">
							<li class="nav-item">
								<a class="nav-link" href="/Parque/views/usuarios/index.do">Usuarios</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/Parque/views/modificaciones/index.do">Modificar Atracciones</a>
							</li>
						</c:if>
                    </ul>
                    <ul class="navbar-nav">
                        <c:choose>
                        <c:when test="${usuario != null}">
                        	<li class="nav-item">
	                            <a class="nav-link" href="/Parque/views/itinerarios/index.do">Mi itinerario</a>
	                        </li>
                        	<li class="nav-item dropdown">
                        		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          							<c:out value="${usuario.nombre}"></c:out>
        						</a>
        						<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown" style="text-align: center;">
        							<li><a class="dropdown-item" href="#"><i class="fas fa-film"></i>  Tematica favorita: <c:out value="${usuario.tematica}"></c:out></a></li>
						            <li><a class="dropdown-item" href="#"><i class="fas fa-coins"></i>  Monedas disponibles: <c:out value="${usuario.monedasDisponibles}"></c:out></a></li>
						            <li><a class="dropdown-item" href="#"><i class="fas fa-clock"></i>  Tiempo Disponible: <c:out value="${usuario.tiempoDisponible}"></c:out></a></li>
						            <li><hr class="dropdown-divider"></li>
						            <li><a href="/Parque/logout" class="btn btn-primary" role="button">Logout</a></li>
          						</ul>
                        	</li>
                        </c:when>
                        <c:otherwise>
                            <a href="login.jsp" class="btn btn-primary" role="button">Login</a>
                        </c:otherwise>
                    </c:choose>
                    </ul>
                </div>
            </div>
        </nav>