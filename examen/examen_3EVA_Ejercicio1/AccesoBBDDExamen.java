package examen_3EVA_Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * pre:--- 
 * post: En esta clase de java vamos a añadir las palabras a una base de
 * datos con el fin de no perder la lista de palabras cada vez que cerremos la
 * aplicacion
 *
 */

public class AccesoBBDDExamen {
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	final private static String host = "jdbc:mysql://localhost:3306/examenProgramacion"; 
	final private static String user = "root"; // cambiar el usuario
	final private static String passwd = "1234"; // cambiar la contrase�a

	/**
	 * pre: 
	 * post: Establecemos la conexion a la base de datos del juego
	 */
	public static void conectarBD() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(host, user, passwd);
			statement = connect.createStatement();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void insertarPalabra(int id_registro, String letra, String palabra) {

		try {

			preparedStatement = connect.prepareStatement(
					"insert into examenProgramacion.registro" + "(id_registro, letra, palabra, values (?, ?, ?)");
			preparedStatement.setInt(1, id_registro);
			preparedStatement.setString(2, letra);
			preparedStatement.setString(3, palabra);
			preparedStatement.executeUpdate();
			System.out.println("Palabra a�adido con exito");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido a�adir la palabra a la base de datos");
			e.printStackTrace();
		} finally {
			cerrarBD();
		}
	}

	public static void cerrarBD() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}

}
