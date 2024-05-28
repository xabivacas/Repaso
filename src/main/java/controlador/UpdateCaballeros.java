package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.*;
import modelo.bean.*;

/**
 * Servlet implementation class UpdateCaballeros
 */
@WebServlet("/UpdateCaballeros")
public class UpdateCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conector cn = new Conector();
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(cn);
		
		Caballero c = new Caballero();
		c.setId(Integer.parseInt(request.getParameter("id")));
		c.setNombre(request.getParameter("nombre"));
		c.setFuerza(Integer.parseInt(request.getParameter("fuerza")));
		c.setExperiencia(Integer.parseInt(request.getParameter("exp")));
		c.setArma(new Arma());
		c.getArma().setId(Integer.parseInt(request.getParameter("arma")));
		c.setEscudo(new Escudo());
		c.getEscudo().setId(Integer.parseInt(request.getParameter("escudo")));
		
		mc.update(c);
		response.sendRedirect("IndexCaballeros");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
