package controlador.atracciones;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import persistencia.comunes.DAOFactory;
import servicios.ComprarAtraccionServicio;

@WebServlet("/views/atracciones/comprar.do")
public class ComprarAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private ComprarAtraccionServicio comprarAtraccionesServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarAtraccionesServicio = new ComprarAtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer atraccionId = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Map<String, String> errores = comprarAtraccionesServicio.comprar(usuario.getId(), atraccionId);
		
		Usuario usuario2 = DAOFactory.getUsuarioDAO().buscarPorId(usuario.getId());
		req.getSession().setAttribute("usuario", usuario2);
		
		if (errores.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errores", errores);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/sugerencia.do");
		dispatcher.forward(req, resp);
	}
}
