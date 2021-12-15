package controlador.adquirible;

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
import servicios.SugerenciaService;

@WebServlet("/views/sugerencia.do")
public class ListAdquiribleServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 4982174968092494531L;
	private SugerenciaService adquiribleService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.adquiribleService = new SugerenciaService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		List<Adquirible> catalogo = adquiribleService.ordenar(usuario);
		
		req.setAttribute("catalogo", catalogo);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/sugerencia.jsp");
		dispatcher.forward(req, resp);
	}

}
