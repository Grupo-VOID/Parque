package controlador.modificaciones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.TipoAtraccion;
import servicios.TipoAtraccionServicio;

@WebServlet("/views/modificaciones/index.do")
public class ListarTodo extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private TipoAtraccionServicio tipoAtraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionServicio = new TipoAtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TipoAtraccion> tipoAtraccion = tipoAtraccionServicio.list();
		req.setAttribute("tematica", tipoAtraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modificaciones/index.jsp");
		dispatcher.forward(req, resp);
	}
}
