package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.bean.Arma;

public class ModeloArma {

	private Conector conector;

	public Arma getArma(int id) {
		Arma a = new Arma();
		String sql = "SELECT * FROM ARMAS WHERE ID=?";
		
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);;
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			a.setId(rs.getInt("id"));
			a.setNombre(rs.getString("nombre"));
			a.setCapacidad_danio(rs.getInt("capacidad_danio"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}
	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
}
