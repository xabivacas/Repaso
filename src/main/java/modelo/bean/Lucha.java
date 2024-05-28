package modelo.bean;

public class Lucha {

	private Caballero luchador1;
	private Caballero luchador2;
	private Caballero ganador;
	
	public Caballero getLuchador1() {
		return luchador1;
	}
	public void setLuchador1(Caballero luchador1) {
		this.luchador1 = luchador1;
	}
	public Caballero getLuchador2() {
		return luchador2;
	}
	public void setLuchador2(Caballero luchador2) {
		this.luchador2 = luchador2;
	}
	public Caballero getGanador() {
		return ganador;
	}
	public void setGanador() {
		int stats1 = luchador1.getFuerza()+luchador1.getArma().getCapacidad_danio()-luchador2.getEscudo().getCapacidad_defensa();
		int stats2 = luchador2.getFuerza()+luchador2.getArma().getCapacidad_danio()-luchador1.getEscudo().getCapacidad_defensa();
		
		if(stats1>stats2) {
			this.ganador=luchador1;
		}else {
			this.ganador=luchador2;
		}
		
	}
	
	
}
