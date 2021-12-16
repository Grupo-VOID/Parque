package controlador.promociones;

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
import servicios.ComprarPromocionServicio;

@WebServlet("/views/promociones/comprar.do")
public class ComprarPromocionesServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private ComprarPromocionServicio comprarPromocionesServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarPromocionesServicio = new ComprarPromocionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer promocionId = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("username");
		Map<String, String> errores = comprarPromocionesServicio.comprar(usuario.getId(), promocionId);

		Usuario usuario2 = DAOFactory.getUsuarioDAO().buscarPorId(usuario.getId());
		req.getSession().setAttribute("usuario", usuario2);

		if (errores.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errores", errores);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/sugerencia.do");
		dispatcher.forward(req, resp);
	}
}
