package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.*;
import modelo.dao.*;

/**
 * Servlet implementation class EditCaballeros
 */
@WebServlet("/EditCaballeros")
public class EditCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conector cn = new Conector();
		ModeloCaballero mc= new ModeloCaballero();
		ModeloArma ma = new ModeloArma();
		ModeloEscudo me = new ModeloEscudo();
		
		mc.setConector(cn);
		ma.setConector(cn);
		me.setConector(cn);
		
		ArrayList<Arma> armas = ma.getAll();
		ArrayList<Escudo> escudos = me.getAll();
		Caballero caballero = mc.getUno(request.getParameter("id"));
		
		request.setAttribute("caballero", caballero);
		request.setAttribute("armas", armas);
		request.setAttribute("escudos", escudos);
		
		request.getRequestDispatcher("editCaballeros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
