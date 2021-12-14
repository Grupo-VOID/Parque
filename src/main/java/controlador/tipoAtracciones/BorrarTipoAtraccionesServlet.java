package controlador.tipoAtracciones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.TipoAtraccionDAO;
import persistencia.comunes.DAOFactory;
import servicios.TipoAtraccionServicio;

@WebServlet("/tematicas/borrar.do")
public class BorrarTipoAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private TipoAtraccionServicio tipoAtraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionServicio = new TipoAtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		tipoAtraccionDAO.encontrarTipoAtraccion(id);

		tipoAtraccionServicio.borrar(tipoAtraccionDAO.encontrarTipoAtraccion(id));

		resp.sendRedirect("/parque/tematicas/index.do");
	}
}
