package controlador.tipoAtracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.TipoAtraccionServicio;

@WebServlet("/tematicas/crear.do")
public class CrearTipoAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private TipoAtraccionServicio tipoAtraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionServicio = new TipoAtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistas/tematicas/crear.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt("id");
		String tematica = req.getParameter("tematica");

		tipoAtraccionServicio.crear(id, tematica);

		resp.sendRedirect("/parque/tematicas/index.do");

	}
}
