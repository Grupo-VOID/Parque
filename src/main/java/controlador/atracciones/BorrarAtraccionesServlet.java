package controlador.atracciones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.AtraccionDAO;
import persistencia.comunes.DAOFactory;
import servicios.AtraccionServicio;

@WebServlet("/atraccion/borrar.do")
public class BorrarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private AtraccionServicio atraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionServicio = new AtraccionServicio();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		AtraccionDAO atracionDAO = DAOFactory.getAtraccionDAO();
		atracionDAO.buscarPorId(id);

		atraccionServicio.borrar(atracionDAO.buscarPorId(id));

		resp.sendRedirect("/turismo/atraccion/index.do");
	}


}
