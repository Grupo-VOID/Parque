<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="mb-3">
    <label for="parametro" class="form-label">Parametro</label>
    <input type="text" class="form-control" id="parametro" aria-describedby="parametro" name="parametro" required value="${catalogo.imagen}">
  </div>
  <div class="mb-3">
    <label for="descripcion" class="form-label">Descripción</label>
    <input type="text" class="form-control" id="descripcion" aria-describedby="descripcion" name="descripcion" required value="${catago.descripcion}">
  </div>
  <div class="mb-3">
    <label for="imagen" class="form-label">Imagen</label>
    <input type="text" class="form-control" id="imagen" aria-describedby="imagen" name="imagen" required value="${catalogo.imagen}">
  </div>
  <!--<div class="mb-3">
	  <label for="imagen" class="form-label">Imagen</label>
	  <input class="form-control" type="file" id="imagen" accept="image/*" required value="${atraccion.imagen}">
  </div>-->
  <div style="padding-top:1cm">
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
  </div>
  
  <th scope="col">Tipo de Promocion</th>
	                    <th scope="col">Tematica</th>
	                    <th scope="col">Atraccion 1</th>
	                    <th scope="col">atraccion2</th>
	                    <th scope="col">atraccionGratis</th>
	                    <th scope="col">parametro</th>
	                    <th scope="col">Descripcion</th>
	                    <th scope="col">Imagen</th>