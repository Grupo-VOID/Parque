<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="mb-3">
    <label for="nombre" class="form-label">Nombre</label>
    <input type="text" class="form-control" id="nombre" aria-describedby="nombre" name="nombre" required value="${atraccion.nombre}">
  </div>
  <div class="mb-3">
    <label for="tematica" class="form-label">Tematica</label>
    <input type="text" class="form-control" id="tematica" aria-describedby="tematica" name="tematica" required value="${atraccion.tematica}">
  </div>
  <label for="costo" class="form-label">Costo</label>
  <div class="input-group mb-3">
    <span class="input-group-text">$</span>
    <input type="number" class="form-control" id="costo" aria-describedby="costo" name="costo" required value="${atraccion.costo}">
  </div>
  <div class="mb-3">
    <label for="duracion" class="form-label">Duración</label>
    <input type="number" class="form-control" id="duracion" aria-describedby="duracion" name="duracion" required value="${atraccion.tiempo}">
  </div>
  <div class="mb-3">
    <label for="cupo" class="form-label">Cupo</label>
    <input type="number" class="form-control" id="cupo" aria-describedby="cupo" name="cupo" required value="${atraccion.cupoMaximo}">
  </div>
  <div class="mb-3">
    <label for="descripcion" class="form-label">Descripción</label>
    <input type="text" class="form-control" id="descripcion" aria-describedby="descripcion" name="descripcion" required value="${atraccion.descripcion}">
  </div>
  <div class="mb-3">
    <label for="imagen" class="form-label">Imagen</label>
    <input type="text" class="form-control" id="imagen" aria-describedby="imagen" name="imagen" required value="${atraccion.imagen}">
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