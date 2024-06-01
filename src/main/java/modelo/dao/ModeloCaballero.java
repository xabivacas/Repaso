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
	
	public boolean nombreRepe(Caballero c) {
		String sql = "SELECT * FROM CABALLEROs WHERE NOMBRE=?";
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			pst.setString(1, c.getNombre());
			ResultSet rs =pst.executeQuery();
			
			return rs.next();
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public Caballero getUno(String id_caballero) {
		String sql = "SELECT * FROM CABALLEROS WHERE id=?";
		int id = Integer.parseInt(id_caballero);
		ModeloArma ma = new ModeloArma();
		ModeloEscudo me = new ModeloEscudo();
		ma.setConector(conector);
		me.setConector(conector);
		
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs =pst.executeQuery();
			
			rs.next();
			
			Caballero c = new Caballero();
			c.setId(rs.getInt("id"));
			c.setNombre(rs.getString("nombre"));
			c.setExperiencia(rs.getInt("experiencia"));
			c.setFuerza(rs.getInt("fuerza"));
			c.setFoto(rs.getString("foto"));
			c.setArma(ma.getArma(rs.getInt("arma_id")));
			c.setEscudo(me.getEscudo(rs.getInt("escudo_id")));
			
			return c;
		} catch (SQLException e) {
			return null;
		}
		
	}
	public boolean store(Caballero c) {
		String sql = "INSERT INTO CABALLEROS (NOMBRE,FUERZA,ARMA_ID,ESCUDO_ID,EXPERIENCIA) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			pst.setString(1, c.getNombre());
			pst.setInt(2, c.getFuerza());
			pst.setInt(3, c.getArma().getId());
			pst.setInt(4, c.getEscudo().getId());
			pst.setInt(5, 0);
			
			pst.execute();
			return true;
			
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public boolean delete(int id) {
		String sql = "DELETE FROM CABALLEROS WHERE ID=?";
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public boolean update(Caballero c) {
		String sql = "UPDATE CABALLEROS SET NOMBRE=?, FUERZA=?, EXPERIENCIA=?, ARMA_ID=?, ESCUDO_ID=? WHERE ID=?";
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			
			pst.setString(1, c.getNombre());
			pst.setInt(2, c.getFuerza());
			pst.setInt(3, c.getExperiencia());
			pst.setInt(4, c.getArma().getId());
			pst.setInt(5, c.getEscudo().getId());
			pst.setInt(6, c.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
