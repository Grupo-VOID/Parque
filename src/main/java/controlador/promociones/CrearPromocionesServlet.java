package controlador.promociones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Atraccion;
import modelo.Promocion;
import modelo.TipoAtraccion;
import persistencia.AtraccionDAO;
import persistencia.TipoAtraccionDAO;
import persistencia.comunes.DAOFactory;
import servicios.PromocionServicio;

@WebServlet("/views/promociones/crear.do")
public class CrearPromocionesServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private PromocionServicio promocionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionServicio = new PromocionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promociones/crear.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoPromocion = req.getParameter("tipoPromocion");
		String tipoAtraccion = req.getParameter("tematica");
		String atraccionUno = req.getParameter("atraccion1");
		String atraccionDos = req.getParameter("atraccion2");
		Double parametro = Double.parseDouble(req.getParameter("parametro"));
		String descripcion = req.getParameter("descripcion");
		String imagen = req.getParameter("imagen");
		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tematica = tipoAtraccionDAO.encontrarTipoAtraccion(tipoAtraccion);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion1 = atraccionDAO.buscarPorNombre(atraccionUno);
		Atraccion atraccion2 = atraccionDAO.buscarPorNombre(atraccionDos);

		if(tipoPromocion == "AxB") {
			String atraccionGratis = req.getParameter("atraccionGratis");
			Atraccion atraccion3 = atraccionDAO.buscarPorNombre(atraccionGratis);
			parametro = (double) atraccion3.getId();
		}
				
		Promocion promocion = promocionServicio.crear(tipoPromocion, tematica, atraccion1, atraccion2,
				parametro, descripcion, imagen);
		if (promocion.esValida()) {
			resp.sendRedirect("/Parque/views/atracciones/index.do");
		} else {
			req.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promociones/crear.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
