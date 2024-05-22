package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.*;
import modelo.dao.*;

/**
 * Servlet implementation class StoreCaballero
 */
@WebServlet("/StoreCaballero")
public class StoreCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conector conector = new Conector();
		ModeloArma ma = new ModeloArma();
		ModeloEscudo me = new ModeloEscudo();
		ModeloCaballero mc = new ModeloCaballero();
		
		ma.setConector(conector);
		me.setConector(conector);
		mc.setConector(conector);
		
		
		Caballero c = new Caballero();
		
		c.setNombre(request.getParameter("nombre"));
		c.setFuerza(request.getParameter("fuerza"));
		c.setArma(ma.getArma(request.getParameter("arma")));
		c.setEscudo(me.getEscudo(request.getParameter("escudo")));
		
		if(Validador.caballeroValido(c, conector)) {
			mc.store(c);
			response.sendRedirect("IndexCaballeros?msg=insertOk");
		}else {
			response.sendRedirect("CreateCaballeros?msg=insertError");
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
