<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="mb-3">
    <label for="username" class="col-form-label">Username</label>
    <input type="text" class="form-control" id="username" aria-describedby="username" name="username" required value="${usuarioTemp.username}">
  </div>
  <div class="mb-3">
    <label for="password" class='col-form-label ${usuarioTemp.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña</label>
    <input type="password" class="form-control" id="password" aria-describedby="password" name="password" required value="${usuarioTemp.password}">
  </div>
  <div class="mb-3">
    <label for="nombre" class='col-form-label ${usuarioTemp.errors.get("nombre") != null ? "is-invalid" : "" }'>Nombre</label>
    <input type="text" class="form-control" id="nombre" aria-describedby="nombre" name="nombre" required value="${usuarioTemp.nombre}">
  </div>
  <label for="monedas" class='col-form-label ${usuarioTemp.errors.get("monedasDisponibles") != null ? "is-invalid" : "" }'>Monedas Disponibles</label>
  <div class="input-group mb-3">
    <span class="input-group-text">$</span>
    <input type="number" class="form-control" id="monedas" aria-describedby="monedas" name="monedas" required value="${usuarioTemp.monedasDisponible}">
  </div>
  <div class="mb-3">
    <label for="tiempo" class='col-form-label ${usuarioTemp.errors.get("tiempoDisponible") != null ? "is-invalid" : "" }'>Tiempo</label>
    <input type="number" class="form-control" id="tiempo" aria-describedby="tiempo" name="tiempo" required value="${usuarioTemp.tiempoDisponible}">
  </div>
  
  
  <div style="padding-top:1cm">
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
  </div>