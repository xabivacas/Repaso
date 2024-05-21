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
 * Servlet implementation class InsertCaballeros
 */
@WebServlet("/CreateCaballeros")
public class CreateCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloArma ma = new ModeloArma();
		ModeloEscudo me = new ModeloEscudo();
		Conector conector = new Conector();
		ma.setConector(conector);
		me.setConector(conector);
		
		ArrayList<Arma> armas = ma.getAll();
		ArrayList<Escudo> escudos = me.getAll();
		request.setAttribute("armas", armas);
		request.setAttribute("escudos", escudos);
		request.getRequestDispatcher("createCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
