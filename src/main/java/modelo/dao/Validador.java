package modelo.dao;

import modelo.bean.Caballero;

public class Validador {

	public static boolean caballeroValido(Caballero c, Conector con) {
		boolean valido= false;
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(con);
		
		if(c.getNombre().isBlank()||c.getArma()==null||c.getEscudo()==null) {
			valido= false;
			return valido;
		}else {
			valido= true;
		}
		
		if(!(0<c.getFuerza()&&c.getFuerza()<100)) {
			valido= false;
			return valido;
		}else {
			valido= true;
		}
		
		if(mc.nombreRepe(c)) {
			valido=false;
			return valido;
		}else {
			valido= true;
		}
		
		return valido;
	}
}
