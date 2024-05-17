/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import objectos.Usuario;

/**
 *
 * @author Carlo
 */
public class UsuarioDAO {
    public static int Permanencia;
    public static  String Carnet_permanencia;
    public  void insertarUsuario(Usuario usuario) {
        String query = "INSERT INTO USUARIO (NOMBRE, APELLIDO, CARNET,PASSWORD, ID_ROL, ID_ESTADO,LIMITES) VALUES (?, ?, ?, ?, ?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, usuario.getNOMBRE());
            statement.setString(2, usuario.getAPELLIDO());
            statement.setString(3, usuario.getCARNET());
            statement.setString(4, usuario.getPASSWORD());
            statement.setInt(5, usuario.getID_ROL());
            statement.setInt(6, usuario.getID_ESTADO());
            statement.setInt(7, usuario.getLimites_de_libros());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void restablecerContraseña(String carnet, String nuevaContraseña) {
        String query = "UPDATE USUARIO SET CONTRASEÑA = ? WHERE CARNET = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, nuevaContraseña);
            statement.setString(2, carnet);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Usuario iniciarSesion(String carnet, String contraseña) {
        String query = "SELECT * FROM USUARIO WHERE CARNET = ? AND PASSWORD = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, carnet);
            statement.setString(2, contraseña);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    
                    String nombre = resultSet.getString("NOMBRE");
                    String apellido = resultSet.getString("APELLIDO");
                    String Password = resultSet.getString("PASSWORD");
                    int rol = resultSet.getInt("ID_ROL");
                    int estado = resultSet.getInt("ID_ESTADO");
                    int Limites = resultSet.getInt("LIMITES");
                    Permanencia=resultSet.getInt("ID_ROL");
                    Carnet_permanencia=carnet;
                    Usuario us= new Usuario(nombre,apellido,carnet,Password,rol,estado,Limites);
                   
                    return us;
                }
               
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT*FROM USUARIO")) {

            while (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                String carnet = rs.getString("CARNET");
                int rol = rs.getInt("ID_ROL");
                int estado = rs.getInt("ID_ESTADO");
                int Limites = rs.getInt("LIMITES");
                String Password = rs.getString("PASSWORD");
                Usuario us= new Usuario(nombre,apellido,carnet,Password,rol,estado,Limites);
                usuarios.add(us);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
    
    
    public  Usuario Busqueda_usuario(String carnet) {
        String query = "SELECT * FROM USUARIO WHERE CARNET = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, carnet);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    
                    String nombre = resultSet.getString("NOMBRE");
                    String apellido = resultSet.getString("APELLIDO");
                    String Password = resultSet.getString("PASSWORD");
                    int rol = resultSet.getInt("ID_ROL");
                    
                    int estado = resultSet.getInt("ID_ESTADO");
                    int Limites = resultSet.getInt("LIMITES");
                    Usuario usuario= new Usuario(nombre,apellido,carnet,Password,rol,estado,Limites);
                    
                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public  void Actualizar_usuario(String Nombre,String Apellido,String Carnet,int ID_Rol,int ID_Estado,int Limites, String Password,String Carnet_Busco) {
        String query = "UPDATE USUARIO SET NOMBRE=?,APELLIDO=?,CARNET=?,ID_ROL=?,ID_ESTADO=?,LIMITES=?,PASSWORD=? WHERE CARNET = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, Nombre);
            statement.setString(2, Apellido);
            statement.setString(3, Carnet);
            statement.setInt(4, ID_Rol);
            statement.setInt(5, ID_Estado);
            statement.setInt(6, Limites);
            statement.setString(7, Password);
            statement.setString(8, Carnet_Busco);
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public  void Delete_User (String Carnet) {
        String query = "DELETE FROM USUARIO WHERE CARNET=?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, Carnet);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
