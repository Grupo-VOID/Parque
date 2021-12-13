package controlador.usuario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import servicios.UsuarioServicio;

@WebServlet("/users/index.do")
public class ListUsersServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private UsuarioServicio usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Usuario> users = usuarioService.list();
		req.setAttribute("usuarios", users);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/users/index.jsp");
		dispatcher.forward(req, resp);

	}

}
