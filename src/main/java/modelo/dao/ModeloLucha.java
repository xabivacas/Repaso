package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.bean.Lucha;

public class ModeloLucha {

	private Conector conector;
	
	public boolean storeLucha(Lucha l) {
		String sql = "INSERT INTO LUCHAS(FECHA,CABALLERO1_ID,CABALLERO2_ID,GANADOR_ID) VALUES (?,?,?,?)";
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
			pst.setInt(2, l.getLuchador1().getId());
			pst.setInt(3, l.getLuchador2().getId());
			pst.setInt(4, l.getGanador().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
}
