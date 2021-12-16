<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <jsp:include page="/partials/head.jsp"></jsp:include>
      
      <script type="text/javascript">
	      var alertPlaceholder = document.getElementById('liveAlertPlaceholder')
	      var alertTrigger = document.getElementById('liveAlertBtn')
	
	      function alert(message, type) {
	        var wrapper = document.createElement('div')
	        wrapper.innerHTML = '<div class="alert alert-' + type + ' alert-dismissible" role="alert">' + message + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>'
	
	        alertPlaceholder.append(wrapper)
	      }
	
	      if (alertTrigger) {
	        alertTrigger.addEventListener('click', function () {
	          alert('Nice, you triggered this alert message!', 'success')
	        })
	      }
      </script>
      
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
					<c:if test="${errores != null}">
						<ul>
							<c:forEach items="${errores}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>
        <hr>
        <h1>Tipos de Atracciones</h1>
        <hr>
        
        <div class="container" style="padding: 1cm;">
        	<div class="mb-3">
		    	<a href="/Parque/views/modificaciones/crear.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nuevo Tipo de Atraccion </a>
	        </div>
        	<table class="table table-bordered table-hover" style="text-align: justify;">
	            <thead>
	                <tr style="text-align: center;">
	                    <th scope="col">id</th>
	                    <th scope="col">Tematica</th>
	                    <th scope="col">Acciones</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${tematica}" var="tematica"> 
	            		<tr style="text-align:center">
	            			<td><c:out value="${tematica.id}"></c:out></td>
	            			<td><strong><c:out value="${tematica.tematica}"></c:out></strong></td>
	            			<td>
	            				<a href="/Parque/views/modificaciones/editar.do?id=${tematica.id}"
									class="btn btn-light rounded-0" role="button"><i class="fas fa-pencil-alt"></i></a>
								<!--  <a href="/Parque/views/modificaciones/eliminar.do?id=${tematica.id}"
									class="btn btn-danger rounded" role="button"><i class="fas fa-trash-alt"></i></a></td> -->
	            		</tr>
	            	</c:forEach>
	            </tbody>
	        </table>
        </div>
        
        <hr>
        <h1>Atracciones</h1>
        <hr>
        
        <div class="container" style="padding: 1cm;">
        	<div class="mb-3">
		    	<a href="/Parque/views/atracciones/crear.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nueva Atraccion </a>
	        </div>
        	<table class="table table-bordered table-hover" style="text-align: justify;">
	            <thead>
	                <tr style="text-align: center;">
	                    <th scope="col">id</th>
	                    <th scope="col">Nombre</th>
	                    <th scope="col">Tematica</th>
	                    <th scope="col">Costo</th>
	                    <th scope="col">Duracion</th>
	                    <th scope="col">Cupo</th>
	                    <th scope="col">Descripcion</th>
	                    <th scope="col">Imagen</th>
	                    <th scope="col">Acciones</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${atraccion}" var="atraccion"> 
	            		<tr style="text-align:center">
	            			<td><c:out value="${atraccion.id}"></c:out></td>
	            			<td><strong><c:out value="${atraccion.nombre}"></c:out></strong></td>
	            			<td><c:out value="${atraccion.tematica}"></c:out></td>
	            			<td><c:out value="${atraccion.costo}"></c:out></td>
	            			<td><c:out value="${atraccion.tiempo}"></c:out></td>
	            			<td><c:out value="${atraccion.cupoMaximo}"></c:out></td>
	            			<td><c:out value="${atraccion.descripcion}"></c:out></td>
	            			<td><c:out value="${atraccion.imagen}"></c:out></td>
	            			<td>
	            				<a href="/Parque/views/atracciones/editar.do?id=${atraccion.id}"
									class="btn btn-light rounded-0" role="button"><i class="fas fa-pencil-alt"></i></a>
								<a href="/Parque/views/atracciones/borrar.do?id=${atraccion.id}"
									class="btn btn-danger rounded" role="button"><i class="fas fa-trash-alt"></i></a></td>
	            		</tr>
	            	</c:forEach>
	            </tbody>
	        </table>
        </div>
        
        <hr>
        <h1>Promociones</h1>
        <hr>
        
        <div class="container" style="padding: 1cm;">
        	<div class="mb-3">
		    	<a href="/Parque/views/promociones/crear.do" class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i> Nueva Promocion </a>
	        </div>
        	<table class="table table-bordered table-hover" style="text-align: justify;">
	            <thead>
	                <tr style="text-align: center;">
	                    <th scope="col">id</th>
	                    <th scope="col">Tipo de Promocion</th>
	                    <th scope="col">Tematica</th>
	                    <th scope="col">Atraccion 1</th>
	                    <th scope="col">Atraccion 2</th>
	                    <th scope="col">Atraccion Gratis</th>
	                    <th scope="col">Parametro</th>
	                    <th scope="col">Descripcion</th>
	                    <th scope="col">Imagen</th>
	                    <th scope="col">Acciones</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${promocion}" var="promocion"> 
	            		<tr style="text-align:center">
	            			<td><c:out value="${promocion.id}"></c:out></td>
	            			<td><strong><c:out value="${promocion.getTipoPromocion()}"></c:out></strong></td>
	            			<td><c:out value="${promocion.tematica}"></c:out></td>
	            			<c:forEach items="${promocion.atraccionesIncluidas()}" var="promocionInc"> 
	            				<td><c:out value="${promocionInc.nombre}"></c:out></td>
	            			</c:forEach>
	            			<c:choose>
	            				<c:when test="${promocion.getTipoPromocion()=='AXB'}">
	            					<td></td>
	            				</c:when>
	            				<c:otherwise>
	            					<td></td>
	            					<td><c:out value="${promocion.getParametro()}"></c:out></td>
	            				</c:otherwise>
	            			</c:choose>
	            			<td><c:out value="${promocion.descripcion}"></c:out></td>
	            			<td><c:out value="${promocion.imagen}"></c:out></td>
	            			<td>
	            				<button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#exampleModal">
								  <i class="fas fa-pencil-alt"></i>
								</button>
	            				<!--  <a href="/Parque/views/promociones/editar.do?id=${promocion.id}"
									class="btn btn-light rounded-0" role="button"><i class="fas fa-pencil-alt"></i></a>-->
								<a href="/Parque/views/promociones/borrar.do?id=${promocion.id}"
									class="btn btn-danger rounded" role="button"><i class="fas fa-trash-alt"></i></a></td>
	            		</tr>
	            		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Atención</h5>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body" style="text-align:center;">
							        <h1> Función en desarrollo </h1>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
							      </div>
							    </div>
							  </div>
							</div>
	            	</c:forEach>
	            </tbody>
	        </table>
        </div>
        </div>
      <footer class="container secciones">
        <jsp:include page="/partials/footer.jsp"></jsp:include>
      </footer>
    </body>
    </html>