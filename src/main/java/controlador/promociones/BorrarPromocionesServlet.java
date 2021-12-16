package controlador.promociones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.PromocionServicio;

@WebServlet("/views/promociones/borrar.do")
public class BorrarPromocionesServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private PromocionServicio promocionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionServicio = new PromocionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		promocionServicio.borrar(id);

		resp.sendRedirect("/Parque/views/modificaciones/index.do");
	}

}
