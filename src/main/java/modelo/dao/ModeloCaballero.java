package modelo.dao;

import java.sql.*;
import java.util.ArrayList;

import modelo.bean.Caballero;

public class ModeloCaballero {

	private Conector conector;

	
	public ArrayList<Caballero> getAll(){
		ArrayList<Caballero> caballeros = new ArrayList<>();
		String sql = "Select * from caballeros";
		
		ModeloArma ma = new ModeloArma();
		ModeloEscudo me = new ModeloEscudo();
		ma.setConector(conector);
		me.setConector(conector);
		try {			
			Statement st = this.conector.getConexion().createStatement();
			ResultSet rs = st.executeQuery(sql);		
			while(rs.next()) {
				Caballero c = new Caballero();
				c.setId(rs.getInt("id"));
				c.setNombre(rs.getString("nombre"));
				c.setExperiencia(rs.getInt("experiencia"));
				c.setFuerza(rs.getInt("fuerza"));
				c.setFoto(rs.getString("foto"));
				c.setArma(ma.getArma(rs.getInt("arma_id")));
				c.setEscudo(me.getEscudo(rs.getInt("escudo_id")));
				caballeros.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return caballeros;
	}

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
}
