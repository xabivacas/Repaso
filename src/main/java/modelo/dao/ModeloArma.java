package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.bean.Arma;
import modelo.bean.Escudo;

public class ModeloArma {

	private Conector conector;

	public ArrayList<Arma> getAll(){
		ArrayList<Arma> armas = new ArrayList<>();
		String sql = "SELECT * FROM armas";
		try {
			Statement st = conector.getConexion().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Arma a = new Arma();
				a.setId(rs.getInt("id"));
				a.setNombre(rs.getString("nombre"));
				a.setCapacidad_danio(rs.getInt("capacidad_danio"));
				
				armas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return armas;
		
	}
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
			return a;
			
		} catch (SQLException e) {
			return null;
		}
	}
	
	public Arma getArma(String id) {
		Arma a = new Arma();
		String sql = "SELECT * FROM ARMAS WHERE ID=?";
		
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);;
			
			pst.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			a.setId(rs.getInt("id"));
			a.setNombre(rs.getString("nombre"));
			a.setCapacidad_danio(rs.getInt("capacidad_danio"));
			return a;
			
		} catch (SQLException e) {
			return null;
		}
	}
	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
}
