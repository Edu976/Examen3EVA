package examen_3EVA_Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * pre:--- 
 * post: En esta clase de java vamos a leer un fichero, del cual vamos a
 * sacar una lista de palabras que empiezan o acaban por una letra que le
 * indicamos y la linea en la que se encuentran, por último las añadiremos a una
 * base de datos
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		AccesoBBDDExamen dao = new AccesoBBDDExamen();
		String letraElegida = "a";
		String fichero = "C:\\Users\\Gestor\\eclipse-workspace\\Programacion\\src\\examen_3EVA_Ejercicio1\\HablanosDelDon.txt";
		ArrayList<Palabras> palabras = new ArrayList<Palabras>();
		ArrayList<Palabras> palabras2 = new ArrayList<Palabras>();

		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			// bucle para recorrer el fichero de texto
			while (f.hasNextLine()) {

				// String linea = f.next(); 	// lee palabra por palabra
				String linea = f.nextLine(); 	// para leer linea por linea
				// Limpieza de linea
				linea = linea.replaceAll("\\.", "");
				linea = linea.replaceAll(",", "");

				String[] linesep = linea.split(" ");


				for (int i = 0; i < linesep.length; i++) {
					// System.out.println(palabras.get(i));
					palabras.add(new Palabras(null, linesep[i]));
					// System.out.println(palabras.get(i));
				}

			}
			for (int i = 0; i < palabras.size(); i++) {
				if (palabras.get(i).getPalabra().substring(0, 1).equalsIgnoreCase(letraElegida)) {
					palabras2.add(new Palabras(null, palabras.get(i).getPalabra()));
				}

				else if (palabras.get(i).getPalabra().substring(palabras.get(i).getPalabra().length() - 1)
						.equalsIgnoreCase(letraElegida)) {
					palabras2.add(new Palabras(null, palabras.get(i).getPalabra()));
				}
			}
			f.close();

			for (int i = 0; i < palabras2.size(); i++) {
				System.out.println(palabras2.get(i).getPalabra());
			}
			/**
			 * No consigo añadir a la base de datos
			 */
			//añadirBBDD(palabras2, letraElegida);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser abierto.");
		}
	}

	public static void añadirBBDD(ArrayList<Palabras> palabras2, String letraElegida) throws Exception {
		AccesoBBDDExamen.conectarBD();
		for (int i = 0; i < palabras2.size(); i++) {
			int id = palabras2.size();
			AccesoBBDDExamen.insertarPalabra(id, letraElegida, palabras2.get(i).getPalabra());
		}
		AccesoBBDDExamen.cerrarBD();
	}
}
