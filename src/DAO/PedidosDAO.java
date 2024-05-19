/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.DatabaseConnection;
import static Connection.DatabaseConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import objectos.Prestamos;

/**
 *
 * @author Carlo
 */
public class PedidosDAO {
     public List<Map<String, Object>> obtenerInfoPrestamos(String carnetUsuario) {
    List<Map<String, Object>> resultados = new ArrayList<>();
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(
             "SELECT CONCAT(usuario.NOMBRE,' ',usuario.APELLIDO) AS 'Nombre_usuario', "
             + "usuario.CARNET AS 'Carnet_usuario', "
             + "libros.NOMBRE AS 'Nombre_libro', "
             + "IF(prestamos.MORA = 1, 'Sin Mora', 'Mora pendiente') AS 'Estado_de_mora' "
             + "FROM usuario, libros, prestamos "
             + "WHERE usuario.CARNET = ? "
             + "AND libros.ID = prestamos.ID_LIBRO")) {
        stmt.setString(1, carnetUsuario);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Map<String, Object> fila = new HashMap<>();
                fila.put("Nombre_usuario", rs.getString("Nombre_usuario"));
                fila.put("Carnet_usuario", rs.getString("Carnet_usuario"));
                fila.put("Nombre_libro", rs.getString("Nombre_libro"));
                fila.put("Estado_de_mora", rs.getString("Estado_de_mora"));
                resultados.add(fila);
            }
        }
    } catch (Exception ex) {
        // Manejar excepción
    }
    return resultados;
}
    public void insertar_Libros(int ID_Libro, String Carnet, int estado, String fecha, int Mora) {
        String query = "INSERT INTO prestamos(ID_LIBRO,CARNET_USUARIO,ID_ESTADO,FECHA_DE_PRESTAMO,MORA) VALUES (?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, ID_Libro);
            statement.setString(2, Carnet);
            statement.setInt(3, estado);
            statement.setString(4, fecha);
            statement.setInt(5, Mora);
            statement.executeUpdate();

        } catch (Exception ex) {

        }
    }
}
