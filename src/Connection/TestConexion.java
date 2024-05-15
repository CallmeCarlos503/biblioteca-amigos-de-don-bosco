import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String contraseña = "";

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);

            // Si se establece la conexión sin errores, muestra un mensaje de éxito
            System.out.println("Conexión exitosa a la base de datos.");

            // Cerrar la conexión
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de la base de datos.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión a la base de datos.");
            e.printStackTrace();
        }
    }
}