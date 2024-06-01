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
 * Servlet implementation class StoreCaballero
 */
@WebServlet("/StoreMasivoCaballero")
public class StoreMasivoCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreMasivoCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conector conector = new Conector();
		ModeloArma ma = new ModeloArma();
		ModeloEscudo me = new ModeloEscudo();
		ModeloCaballero mc = new ModeloCaballero();
		ArrayList<Caballero> caballeros = new ArrayList<>();
		
		ma.setConector(conector);
		me.setConector(conector);
		mc.setConector(conector);
		
		
		Caballero c;
		
		String listaInsertar = request.getParameter("listaInsertar");
		String[] lineas = listaInsertar.split("\r\n");
		String[] atributos;
		
		for(int i = 0 ; i<lineas.length ; i++) {
			atributos=lineas[i].split(",");
			
			c= new Caballero();
			c.setNombre(atributos[0]);
			c.setFuerza(Integer.parseInt(atributos[1]));
			c.setArma(ma.getArma(atributos[2]));
			c.setEscudo(me.getEscudo(atributos[3]));
			
			mc.store(c);
			
		}
		response.sendRedirect("IndexCaballeros");
	}

}
