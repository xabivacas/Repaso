package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Caballero;
import modelo.bean.Lucha;
import modelo.dao.Conector;
import modelo.dao.ModeloCaballero;
import modelo.dao.ModeloLucha;

/**
 * Servlet implementation class Luchar
 */
@WebServlet("/Luchar")
public class Luchar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Luchar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloCaballero mc = new ModeloCaballero();
		ModeloLucha ml = new ModeloLucha();
		Conector c = new Conector();
		mc.setConector(c);
		ml.setConector(c);
		
		Caballero luchador1=mc.getUno(request.getParameter("luchador1"));
		Caballero luchador2=mc.getUno(request.getParameter("luchador"));
		
		Lucha lucha = new Lucha();
		lucha.setLuchador1(luchador1);
		lucha.setLuchador2(luchador2);
		lucha.setGanador();
		ml.storeLucha(lucha);
		
		request.setAttribute("luchador1", luchador1);
		request.setAttribute("luchador2", luchador2);
		request.setAttribute("idGanador", lucha.getGanador().getId());
		request.setAttribute("msg", "datos");
		
		request.getRequestDispatcher("lucha.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		
		Caballero ganador=mc.getUno(request.getParameter("idGanador"));
		request.setAttribute("ganador", ganador);
		request.setAttribute("msg", "ganador");
		
		
		request.getRequestDispatcher("lucha.jsp").forward(request, response);
		
	}

}
