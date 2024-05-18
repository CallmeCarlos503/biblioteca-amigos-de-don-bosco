/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import objectos.Prestamos;

/**
 *
 * @author Carlo
 */
public class PedidosDAO {
     public List<Prestamos> obtenerLibros(String Carnet) {
        List<Prestamos> Prestamo = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT CONCAT(usuario.NOMBRE,' ',usuario.APELLIDO) AS 'Nombre_usuario',usuario.CARNET AS 'Carnet_usuario', libros.NOMBRE AS 'Nombre_libro', if(prestamos.MORA   =1,'Sin Mora','Mora pendiente') AS 'Estado_de_mora' FROM usuario,libros,prestamos WHERE prestamos.CARNET_USUARIO='"+Carnet+"' AND libros.ID=prestamos.ID_LIBRO;")) {
            
            while (rs.next()) {
                int ID=rs.getInt("ID");
                String Nombre_Usuario=rs.getString("Nombre_usuario");
                String Carnet_Usuario=rs.getString("Carnet_usuario");
                String Nombre_libro=rs.getString("Nombre_Libro");
                String Estado_de_mora=rs.getString("Estado_de_mora");
                
                //int ID, int ID_Libro, String Carnet, int ID_Estado, String Fecha, int Mora, String Nombre_Usuario, String Carnet_Usuario, String Nombre_Libro, String Estado_de_mora
                
                Prestamos Pre= new Prestamos(1,1,"",1,"",1,Nombre_Usuario,Carnet_Usuario,Nombre_libro,Estado_de_mora);
                
                
                Prestamo.add(Pre);
            }
        } catch (Exception ex) {

        }
        return Prestamo;
    }
   public  List<Prestamos> busqueda_Carnet(String Carnet) { 
        String Query = "";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(Query)) {
            statement.setString(1, Carnet);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int ID2= resultSet.getInt("ID");
                    int ID_LIBRO=resultSet.getInt("ID_LIBRO");
                    int ID_ESTADO=resultSet.getInt("ID_ESTADO");
                    String Fecha= resultSet.getString("FECHA_DE_PRESTAMO");
                    int MORA=resultSet.getInt("MORA");
                    String Nombre= resultSet.getString("Nombre_usuario");
                    String Carnet_usuario= resultSet.getString("Carnet_usaurio");
                    String Nombre_Libro=resultSet.getString("Nombre_libro");
                    String Estado_Mora=resultSet.getString("Estado_de_mora");
                    Prestamos pre= new Prestamos(ID2,ID_LIBRO,Carnet,ID_ESTADO,Fecha,MORA,Nombre,Carnet_usuario,Nombre_Libro,Estado_Mora);
                    
                }
            }
        } catch (Exception ex) {

        }
        return null;
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
