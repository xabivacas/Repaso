package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.*;
import modelo.dao.Conector;
import modelo.dao.ModeloCaballero;

/**
 * Servlet implementation class Index
 */
@WebServlet("/IndexCaballeros")
public class IndexCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		ArrayList<Caballero> caballeros = mc.getAll();
		ComparadorCaballero comp = new ComparadorCaballero(request.getParameter("orderBy"));
		
		caballeros.sort(comp);
		
		request.setAttribute("caballeros", caballeros);
		request.setAttribute("msg", request.getParameter("msg"));
		request.getRequestDispatcher("indexCaballeros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		ArrayList<Caballero> caballeros = mc.getAll();
		
		Iterator<Caballero> it = caballeros.iterator();
		
		String nombre = request.getParameter("buscador");
		

		while(it.hasNext()) {
			
			if(!(it.next().getNombre().equalsIgnoreCase(nombre))) {
				it.remove();
			}
		}
		
		request.setAttribute("caballeros", caballeros);
		request.getRequestDispatcher("indexCaballeros.jsp").forward(request, response);
	}

}
