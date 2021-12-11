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

@WebServlet("/atraccion/editar.do")
public class EditarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionServicio atraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionServicio = new AtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion atraccion = atraccionServicio.buscar(id);
		req.setAttribute("atraccion", atraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		String tipoAtraccion = req.getParameter("tematica");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
		Double duracion = Double.parseDouble(req.getParameter("duracion"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		
		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tematica = tipoAtraccionDAO.encontrarTipoAtraccion(tipoAtraccion);

		Atraccion atraccion = atraccionServicio.update(id, nombre, tematica, costo, duracion, cupo);

		if (atraccion.esValida()) {
			resp.sendRedirect("/parque/atraccion/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistas/atraccion/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
