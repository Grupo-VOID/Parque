package controlador.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Atraccion;
import modelo.TipoAtraccion;
import persistencia.TipoAtraccionDAO;
import persistencia.comunes.DAOFactory;
import servicios.AtraccionServicio;

@WebServlet("/atraccion/crear.do")
public class CrearAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private AtraccionServicio atraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionServicio = new AtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String tipoAtraccion = req.getParameter("tematica");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double duracion = Double.parseDouble(req.getParameter("duracion"));
		int cupo = Integer.parseInt(req.getParameter("cupo"));
		
		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tematica = tipoAtraccionDAO.encontrarTipoAtraccion(tipoAtraccion);

		Atraccion atraccion = atraccionServicio.crear(nombre, tematica, costo, duracion, cupo);
		if (atraccion.esValida()) {
			resp.sendRedirect("/parque/atraccion/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/vistas/atraccion/crear.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
