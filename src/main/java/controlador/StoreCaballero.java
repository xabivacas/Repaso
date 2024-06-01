package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.bean.*;
import modelo.dao.*;

/**
 * Servlet implementation class StoreCaballero
 */
@WebServlet("/StoreCaballero")
public class StoreCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final String UPLOAD_DIR = "fotos";
    private static final String APLICATIN_LOCAL_PATH = "C:\\Users\\plaiaundi\\eclipse-workspace-21\\SubirFotos\\src\\main\\webapp";
       
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
		
		 // Obtener la parte del formulario con el archivo
        Part filePart = request.getPart("foto");
        
        // Comprobar si se ha seleccionado un archivo
        if (filePart != null && filePart.getSize() > 0) {
            // Obtener el nombre del archivo
            String fileName = getFileName(filePart);
            
            // Obtener la ruta completa de la carpeta de fotos
//            String applicationPath = request.getServletContext().getRealPath("");
//            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            String uploadFilePath = APLICATIN_LOCAL_PATH + File.separator + UPLOAD_DIR;
            
            // Crear la carpeta de destino si no existe
            File uploadDir = new File(uploadFilePath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            
            // Ruta completa del archivo a guardar
            String filePath = uploadFilePath + File.separator + fileName;
            
            // Guardar el archivo en la ruta especificada
            try (InputStream inputStream = filePart.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(filePath)) {
                
                int read;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            }
        }
		if(Validador.caballeroValido(c, conector)) {
			mc.store(c);
			response.sendRedirect("IndexCaballeros?msg=insertOk");
		}else {
			response.sendRedirect("CreateCaballeros?msg=insertError");
		}
        // Redireccionar a una página de éxito o mostrar un mensaje adecuado
        response.getWriter().println("Archivo subido con éxito!");
    }

    // Método para obtener el nombre del archivo
    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
