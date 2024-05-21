package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.bean.Arma;
import modelo.bean.Escudo;

public class ModeloEscudo {

	private Conector conector;

	public Escudo getEscudo(int id) {
		Escudo es = new Escudo();
		String sql = "SELECT * FROM ESCUDOS WHERE ID=?";
		
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);;
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			es.setId(rs.getInt("id"));
			es.setNombre(rs.getString("nombre"));
			es.setCapacidad_defensa(rs.getInt("capacidad_defensa"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return es;
	}
	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
}
