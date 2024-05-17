/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.*;
import objectos.Libros;
import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Carlo
 */
public class LibrosDAO {

    public List<Libros> obtenerLibros() {
        List<Libros> Libro = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT*FROM LIBROS")) {
            while (rs.next()) {
                int ID=rs.getInt("ID");
                String NOMBRE = rs.getString("NOMBRE");
                int Estado = rs.getInt("ID_ESTADO");
                int ID_Categoria = rs.getInt("ID_CATEGORIA");
                int Cantidad = rs.getInt("CANTIDAD_DISPONIBLE");
                Libros lb = new Libros(ID,NOMBRE, Estado, ID_Categoria, Cantidad);
                Libro.add(lb);
            }
        } catch (Exception ex) {

        }
        return Libro;
    }

    public void insertar_Libros(String Nombre, int Estado, int Categoria, int Cantidad) {
        String query = "INSERT INTO LIBROS(NOMBRE,ID_ESTADO,ID_CATEGORIA,CANTIDAD_DISPONIBLE) VALUES (?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, Nombre);
            statement.setInt(2, Estado);
            statement.setInt(3, Categoria);
            statement.setInt(4, Cantidad);
            statement.executeUpdate();

        } catch (Exception ex) {

        }
    }

    public Libros busqueda_Libros(int ID) {
        String Query = "SELECT * FROM libros where ID=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(Query)) {
            statement.setInt(1, ID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int ID2= resultSet.getInt("ID");
                    String Nombre = resultSet.getString("NOMBRE");
                    int Estado = resultSet.getInt("ID_ESTADO");
                    int Categoria = resultSet.getInt("ID_CATEGORIA");

                    int Cantidad_Disponible = resultSet.getInt("CANTIDAD_DISPONIBLE");
                    Libros Libros = new Libros(ID2,Nombre, Estado, Categoria, Cantidad_Disponible);
                    return Libros;
                }
            }
        } catch (Exception ex) {

        }
        return null;
    }
    
    public void Actualizar_Books(String Nombre,int Estado,int Categoria,int Cantidad,int ID){
        String Query="UPDATE libros set NOMBRE=?,ID_ESTADO=?,ID_CATEGORIA=?,CANTIDAD_DISPONIBLE=? WHERE ID=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(Query)) {
            statement.setString(1, Nombre);
            statement.setInt(2, Estado);
            statement.setInt(3, Categoria);
            statement.setInt(4, Cantidad);
            statement.setInt(5, ID);
            
            statement.executeUpdate();
        }catch(Exception ex){
            
        }
    }
    public void Eliminacion_Books(int ID){
        String Query="DELETE FROM libros WHERE ID=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(Query)) {
            statement.setInt(1, ID);
            
            statement.executeUpdate();
        }catch(Exception ex){
            
        }
    }
    
    
}
