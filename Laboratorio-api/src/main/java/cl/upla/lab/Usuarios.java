package cl.upla.lab;

public class Usuarios {
	
	private String rut;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private int nivel;
	
	public Usuarios(){
		
	}
	
	public Usuarios(String rut, String nombre, String ap_paterno,
			String ap_materno, int nivel) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.ap_paterno = ap_paterno;
		this.ap_materno = ap_materno;
		this.nivel = nivel;
	}
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp_paterno() {
		return ap_paterno;
	}
	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}
	public String getAp_materno() {
		return ap_materno;
	}
	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
