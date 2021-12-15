package controlador.usuario;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.UsuarioServicio;

@WebServlet("/views/usuarios/eliminar.do")
public class BorrarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private UsuarioServicio usuarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioServicio = new UsuarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		usuarioServicio.borrar(id);

		resp.sendRedirect("/Parque/views/atracciones/index.do");
	}
}
