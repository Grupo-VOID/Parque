package controlador.atracciones;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.AtraccionServicio;

@WebServlet("/views/atracciones/borrar.do")
public class BorrarAtraccionesServlet extends HttpServlet {

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
		atraccionServicio.borrar(id);

		resp.sendRedirect("/Parque/views/atracciones/index.do");
	}


}
