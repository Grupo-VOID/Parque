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
        <hr>
        <h1>Promociones</h1>
        <hr>
        <c:if test="${usuario.esAdministrador()}">
          <div class="mb-3">
            <a href="/Parque/views/create.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nueva
              Promocion
            </a>
          </div>
        </c:if>
      </div>

      <div class="container-fluid content-row" style="padding-top: 2cm">
        <hr>
        <h1>Atracciones</h1>
        <hr>
        <c:if test="${usuario.esAdministrador()}">
          <div class="mb-3">
            <a href="/Parque/views/create.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nueva
              Atraccion
            </a>
          </div>
        </c:if>

        <div class="container">
        	<div class="row card-group">
            	<div class="col-sm-10 col-lg-3">
        	      <c:forEach items="${atraccion}" var="atraccion">
    	            <div class="card">
	                  <img src="/Parque/assets/images/atracciones/<c:out value="${atraccion.imagen}"></c:out>" class="card-img-top" alt="...">
                	  <div class="card-body" style="padding: 5mm">
            	        <h5 class="card-title">
        	              <c:out value="${atraccion.nombre}"></c:out>
    	                </h5>
	                    <div style="height: 120px; text-overflow: ellipsis; overflow: hidden;text-align: justify;">
                    	  <c:out value="${atraccion.descripcion}"></c:out>
                	    </div>
            	        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#atraccion<c:out value="${atraccion.id}"></c:out>">Ver detalles</button>
        	          </div>
    	              <div class="modal fade bd-example-modal-lg" id="atraccion<c:out value="${atraccion.id}"></c:out>" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"aria-hidden="true">
	                    <div class="modal-dialog modal-lg" role="document">
                	      <div class="modal-content">
            	            <div class="modal-header">
        	                  	<h5 class="modal-title" id="exampleModalLongTitle">Atraccion</h5>
                          		<button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                        	</div>
                    	    <div class="modal-body row col-md-12">
                	          <div class="col-md-6">
            	                <img src="/Parque/assets/images/atracciones/<c:out value="${atraccion.imagen}"></c:out>" class="img-thumbnail" alt="...">
    	                      </div>
	                          <div class="col-md-6">
                        	    <h2>
                    	          <c:out value="${atraccion.nombre}"></c:out>
                	            </h2>
            	                <div style="overflow-y: scroll; height:200px">
        	                      <c:out value="${atraccion.descripcion}"></c:out>
    	                        </div>
    	                        <div style="padding-top:20px">
    	                        	<i class="fas fa-coins"></i> Costo: <c:out value="${atraccion.costo}"></c:out> &nbsp;&nbsp; <i class="fas fa-clock"></i>Duracion: <c:out value="${atraccion.tiempo}"></c:out> &nbsp;&nbsp; <i class="fas fa-users"></i> Cupo: <c:out value="${atraccion.cupoMaximo}"></c:out>
        	                  	</div>
	                          </div>
                        	</div>
	                        <div class="modal-footer">
                          	<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        	  <button type="button" class="btn btn-primary">Comprar</button>
                    	    </div>
                	      </div>
            	        </div>
        	          </div>
    	            </div>
  	
            	  </c:forEach>
        	    </div>
    	      </div>
	        </div>
        </div>

      <footer class="container secciones">
        <jsp:include page="/partials/footer.jsp"></jsp:include>
      </footer>
    </body>

    </html>