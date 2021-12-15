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


@WebServlet("/views/usuarios/crear.do")
public class CrearUsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private UsuarioServicio servicioUsuario;

	@Override
	public void init() throws ServletException {
		super.init();
		this.servicioUsuario = new UsuarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/crear.jsp");
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
		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tematica = tipoAtraccionDAO.encontrarTipoAtraccion(tipoAtraccion);
		
		Usuario usuario = servicioUsuario.crear(username, password, nombre, tematica, monedas, tiempo, admin);
		
		if (usuario.esValido()) {
			req.setAttribute("flash", "Usuario editado con exito");
			resp.sendRedirect("/Parque/views/usuarios/index.do");
		} else {
			req.setAttribute("usuario", usuario);
			req.setAttribute("flash", "No se ha podido editar el usuario");
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuarios/crear.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
