<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="mb-3">
    <label for="tematica" class="col-form-label">Tematica</label>
    <input type="text" class="form-control" id="tematica" aria-describedby="tematica" name="tematica" style="text-transform:uppercase" required value="${tematica.tematica}">
  </div>
  <div style="padding-top:1cm">
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
  </div>