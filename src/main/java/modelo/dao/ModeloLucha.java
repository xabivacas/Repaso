package modelo.dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<Lucha> getAll(){
		String sql = "SELECT * FROM LUCHAS";
		
		ArrayList<Lucha> luchas = new ArrayList<>();
		
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(conector);
		
		try {
			Statement st = conector.getConexion().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Lucha l = new Lucha();
				l.setId(rs.getInt("id"));
				l.setLuchador1(mc.getUno(rs.getInt("caballero1_id")+""));
				l.setLuchador2(mc.getUno(rs.getInt("caballero2_id")+""));
				l.setGanador(mc.getUno(rs.getInt("ganador_id")+""));
				l.setFecha(rs.getDate("fecha"));
				luchas.add(l);
				
			}
			return luchas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
