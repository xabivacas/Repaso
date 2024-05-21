package modelo.dao;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.bean.Arma;
import modelo.bean.Escudo;

public class ModeloEscudo {

	private Conector conector;

	public ArrayList<Escudo> getAll(){
		ArrayList<Escudo> escudos = new ArrayList<>();
		String sql = "SELECT * FROM ESCUDOS";
		try {
			Statement st = conector.getConexion().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Escudo e = new Escudo();
				e.setId(rs.getInt("id"));
				e.setNombre(rs.getString("nombre"));
				e.setCapacidad_defensa(rs.getInt("capacidad_defensa"));
				
				escudos.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return escudos;
		
	}
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
