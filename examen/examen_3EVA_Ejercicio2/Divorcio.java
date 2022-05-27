package examen_3EVA_Ejercicio2;

public class Divorcio implements Comparable {
	
	public String ciudad;
	public int contador;
	
	public Divorcio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Divorcio(String ciudad, int contador) {
		super();
		this.ciudad = ciudad;
		this.contador = contador;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
