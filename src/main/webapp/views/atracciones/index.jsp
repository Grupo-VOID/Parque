<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    	<c:if test="${usuario.esAdministrador()}">
			<div class="mb-3">
				<a href="/Parque/views/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Promocion
				</a>
			</div>
		</c:if>
		
     	<hr>
    	<h1> Atracciones </h1>
     	<hr>
        <c:if test="${usuario.esAdministrador()}">
			<div class="mb-3">
				<a href="/Parque/views/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Atraccion
				</a>
			</div>
		</c:if>
        <div class="container">
			<div class="row card-group">
                <c:forEach items="${atracciones}" var="atraccion">
                	<div class="col-4 tarjeta">
                			<div class="card" style="width: 100%;">
                	    	<img src="/Parque/assets/images/atracciones/<c:out value="${atraccion.imagen}"></c:out>" class="img-fluid" alt="...">
	        	            <div class="containerTarjeta" style="padding: 5mm">
        	                	<h5 class="card-title"><c:out value="${atraccion.nombre}"></c:out></h5>
		                        <div style="height: 120px; text-overflow: ellipsis;overflow:hidden;padding-top:5mm">
		                        	<c:out value="${atraccion.descripcion}"></c:out>
		                        </div>
		                        <button type="button" class="btn btn-primary" data-toggle="modal"
    	                        	data-target="#atraccion<c:out value="${atraccion.ID}"></c:out>">
            	            	    Ver detalles
        	            	    </button>
    	                	</div>
	                	</div>
	                </div>
	                <div class="modal fade bd-example-modal-lg" id="atraccion<c:out value="${atraccion.ID}"></c:out>" tabindex="-1" role="dialog"
                	  	        aria-labelledby="myLargeModalLabel" aria-hidden="true">
            	    	<div class="modal-dialog modal-lg" role="document">
        	                  	    <div class="modal-content">
    	                           	    <div class="modal-header">
	                                   	    <h5 class="modal-title" id="exampleModalLongTitle">Atraccion</h5>
                                       		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                       	    	<span aria-hidden="true">&times;</span>
	                               	        </button>
	                               	        
    	                       	        </div>
        	               	            <div class="modal-body">
            	       	                    <div class="container-fluid">
                	                            <div class="row">
                	   	                            <div class="col-md-6">
            	           	                            <img src="images/atracciones/<c:out value="${atraccion.imagen}"></c:out>"
        	                   	                            class="img-thumbnail" alt="...">
   	                    	                        </div>
       	            	                            <div class="col-md-6">
           	    	                                    <h2>Breaking Bad</h2>
               		                                    <p>
           	        	                                </p>
       	                	                        </div>
   	                        	                </div>
                                	        </div>
                                   		</div>
                                	    <div class="modal-footer">
   	                        	            <button type="button" class="btn btn-secondary"
       	                	                    data-dismiss="modal">Cerrar</button>
           	        	                    <button type="button" class="btn btn-primary">Comprar</button>
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