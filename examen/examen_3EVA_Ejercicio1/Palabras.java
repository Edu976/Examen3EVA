package examen_3EVA_Ejercicio1;

public class Palabras {

	public String letra;
	public String palabra;

	public Palabras() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Palabras(String linesep, String palabra) {
		super();
		this.letra = linesep;
		this.palabra = palabra;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

}
