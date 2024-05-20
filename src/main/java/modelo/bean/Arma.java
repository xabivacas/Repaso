package modelo.bean;

public class Arma {

	private int id;
	private int capacidad_danio;
	private String nombre;
	private String foto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidad_danio() {
		return capacidad_danio;
	}
	public void setCapacidad_danio(int capacidad_danio) {
		this.capacidad_danio = capacidad_danio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	@Override
	public String toString() {
		return "Arma [id=" + id + ", capacidad_danio=" + capacidad_danio + ", nombre=" + nombre + ", foto=" + foto
				+ "]";
	}
}
