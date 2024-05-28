package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Caballero;
import modelo.dao.Conector;
import modelo.dao.ModeloCaballero;

/**
 * Servlet implementation class IndexLucha
 */
@WebServlet("/IndexLucha")
public class IndexLucha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexLucha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		
		request.setAttribute("destino", "IndexLucha");
		request.setAttribute("metodo", "post");
		
		request.setAttribute("caballeros", mc.getAll());
		
		request.getRequestDispatcher("indexLucha.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		ArrayList<Caballero> caballeros = mc.getAll();
		Iterator<Caballero> it = caballeros.iterator();
		
		int id = Integer.parseInt(request.getParameter("luchador"));
		request.setAttribute("luchador1", id);
		request.setAttribute("destino", "Luchar");
		request.setAttribute("metodo", "get");
		
		while(it.hasNext()) {
			
			if(it.next().getId()==id) {
				it.remove();
			}
		}
		
		request.setAttribute("caballeros", caballeros);
		request.getRequestDispatcher("indexLucha.jsp").forward(request, response);
	}

}
