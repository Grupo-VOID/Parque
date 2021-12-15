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
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>
        <hr>
        <h1>Promociones y Atracciones</h1>
        <hr>
        <c:if test="${usuario.esAdministrador()}">
        	<div class="mb-3">
	            <a href="/Parque/views/create.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nueva
	              Promocion
	            </a>
          	</div>
          	<div class="mb-3">
	            <a href="/Parque/views/create.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nueva
	              Atraccion
	            </a>
          	</div>
        </c:if>

        <div class="container">
        	<div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 row-cols-xl-4 g-4" style="text-align:center">
        	   <c:forEach items="${atraccion}" var="atraccion">
        	      <div class="col">
    	            <div class="card" style="width: 18rem;">
	                  <img src="/Parque/assets/images/atracciones/<c:out value="${atraccion.imagen}"></c:out>" class="card-img-top" alt="...">
                	  <div class="card-body" style="padding: 5mm">
            	        <h5 class="card-title"><c:out value="${atraccion.nombre}"></c:out></h5>
	                    <p class="card-text" style="height: 120px; text-overflow: ellipsis; overflow: hidden;text-align: justify;">
                    	  <c:out value="${atraccion.descripcion}"></c:out>
                	    </p>
                	    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#atraccion<c:out value="${atraccion.id}"></c:out>">
						  	Ver detalles
						</button>
        	          </div>
    	              <div class="modal fade bd-example-modal-lg" id="atraccion<c:out value="${atraccion.id}"></c:out>" tabindex="-1" aria-labelledby="exampleModalLabel">
	                    <div class="modal-dialog modal-lg" role="document">
                	      <div class="modal-content">
            	            <div class="modal-header">
        	                  	<h5 class="modal-title" id="exampleModalLabel">Atraccion</h5>
                          		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        	</div>
                    	    <div class="modal-body row col-md-12">
                	          <div class="col-md-6">
            	                <img src="/Parque/assets/images/atracciones/<c:out value="${atraccion.imagen}"></c:out>" class="img-thumbnail" alt="...">
    	                      </div>
	                          <div class="col-md-6">
                        	    <h2>
                    	          <c:out value="${atraccion.nombre}"></c:out>
                	            </h2>
            	                <div style="overflow-y: scroll; height:180px">
        	                      <c:out value="${atraccion.descripcion}"></c:out>
    	                        </div>
    	                        <div style="padding-top:20px">
    	                        	<i class="fas fa-film"></i> Tematica: <c:out value="${atraccion.tematica}"></c:out> &nbsp;&nbsp;<i class="fas fa-coins"></i> Costo: <c:out value="${atraccion.costo}"></c:out>
        	                  	</div>
        	                  	<div>
    	                        	<i class="fas fa-clock"></i>Duracion: <c:out value="${atraccion.tiempo}"></c:out> &nbsp;&nbsp; <i class="fas fa-users"></i> Cupo: <c:out value="${atraccion.cupoMaximo}"></c:out>
        	                  	</div>
	                          </div>
                        	</div>
	                        <div class="modal-footer">
                          		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        						<c:choose>
								<c:when
									test="${usuario.chequearDinero(atraccion) && usuario.chequearTiempo(atraccion) && atraccion.tieneCupo(1)}">
									<a href="/Parque/views/atracciones/comprar.do?id=${atraccion.id}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled" role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
                    	    </div>
                	      </div>
            	        </div>
        	          </div>
    	              </div>
    	            </div>
            	</c:forEach>
        	    
    	      </div>
	        </div>
        </div>

      <footer class="container secciones">
        <jsp:include page="/partials/footer.jsp"></jsp:include>
      </footer>
    </body>

    </html>