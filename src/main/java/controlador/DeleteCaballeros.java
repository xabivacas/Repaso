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
 * Servlet implementation class DeleteCaballeros
 */
@WebServlet("/DeleteCaballeros")
public class DeleteCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener caballeros 
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		ArrayList<Caballero> caballeros = mc.getAll();
		
		//Para el while de alante
		int cont = 0;
		
		//Conseguir los ids y al arraylist donde mas adelante se meten los ids
		String ids = request.getParameter("eliminador");
		ArrayList<Integer> idsDelete = new ArrayList<>();
		
		//Pasar los id a int
		for(String s : ids.split(",")) {
			idsDelete.add(Integer.parseInt(s));
		}
		
		//Boolean si el delete es valido
		boolean valido=true;
		
		while(cont<idsDelete.size()&&valido) {
			valido=Validador.deleteValido(idsDelete.get(cont), caballeros);
			cont++;
		}
		if(valido) {
			for(int id : idsDelete) {
				mc.delete(id);
			}
		}

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
