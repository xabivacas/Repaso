package modelo.bean;

import java.util.Comparator;

public class ComparadorCaballero implements Comparator<Caballero> {

	private String funcion;

	public ComparadorCaballero(String funcion) {
		this.funcion = funcion;
	}

	public int nombreAsc(Caballero o1, Caballero o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

	public int nombreDesc(Caballero o1, Caballero o2) {
		return o2.getNombre().compareTo(o1.getNombre());
	}

	public int idAsc(Caballero o1, Caballero o2) {
		return Integer.compare(o1.getId(), o2.getId());
	}

	public int idDesc(Caballero o1, Caballero o2) {
		return Integer.compare(o2.getId(), o1.getId());
	}
	public int fuerzaAsc(Caballero o1, Caballero o2) {
		return Integer.compare(o1.getFuerza(), o2.getFuerza());
	}
	public int fuerzaDesc(Caballero o1, Caballero o2) {
		return Integer.compare(o2.getFuerza(), o1.getFuerza());
	}

	@Override
	public int compare(Caballero o1, Caballero o2) {
		if (funcion == null) {
			funcion = "idAsc";
		}
		switch (funcion) {

		case "nAsc":
			return nombreAsc(o1, o2);

		case "nDesc":
			return nombreDesc(o1, o2);

		case "idAsc":
			return idAsc(o1, o2);

		case "idDesc":
			return idDesc(o1, o2);
			
		case "fuerzaAsc":
			return fuerzaAsc(o1,o2);
			
		case "fuerzaDesc":
			return fuerzaDesc(o1, o2);

		default:
			return 0;
		}

	}

}
