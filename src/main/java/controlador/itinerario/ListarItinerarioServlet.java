package controlador.itinerario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Adquirible;
import modelo.Usuario;
import servicios.ItinerarioServicio;

@WebServlet("/views/itinerarios/index.do")
public class ListarItinerarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private ItinerarioServicio itinerarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioServicio = new ItinerarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		List<Adquirible> adquiribles = itinerarioServicio.list(usuario);
		req.setAttribute("adquribles", adquiribles);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/itinerarios/index.jsp");
		dispatcher.forward(req, resp);
	}
}
