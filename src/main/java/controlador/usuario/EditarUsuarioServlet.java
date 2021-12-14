package controlador.usuario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.TipoAtraccion;
import modelo.Usuario;
import persistencia.TipoAtraccionDAO;
import persistencia.comunes.DAOFactory;
import servicios.UsuarioServicio;

@WebServlet("/usuarios/editar.do")
public class EditarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private UsuarioServicio usuarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioServicio = new UsuarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Usuario usuario = usuarioServicio.buscar(id);
		req.setAttribute("usuario", usuario);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistas/usuarios/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String nombre = req.getParameter("nombre");
		String tipoAtraccion = req.getParameter("tematica");
		Double monedas = Double.parseDouble(req.getParameter("monedasDisponibles"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempoDisponilbe"));

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tematica = tipoAtraccionDAO.encontrarTipoAtraccion(tipoAtraccion);
		
		Usuario usuario = usuarioServicio.crear(username, password, nombre, tematica, monedas, tiempo, false);

		if (usuario.esValido()) {
			resp.sendRedirect("/parque/usuarios/index.do");
		} else {
			req.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistas/usuarios/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
