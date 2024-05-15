/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.DatabaseConnection;

import java.sql.*;
import objectos.Usuario;

/**
 *
 * @author Carlo
 */
public class UsuarioDAO {

    public static void insertarUsuario(Usuario usuario) {
        String query = "INSERT INTO USUARIO (NOMBRE, APELLIDO, CARNET,PASSWORD, ID_ROL, ID_ESTADO) VALUES (?, ?, ?, ?, ?,?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, usuario.getNOMBRE());
            statement.setString(2, usuario.getAPELLIDO());
            statement.setString(3, usuario.getCARNET());
            statement.setString(4, usuario.getPASSWORD());
            statement.setInt(5, usuario.getID_ROL());
            statement.setInt(6, usuario.getID_ESTADO());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void restablecerContraseña(String carnet, String nuevaContraseña) {
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
                    int id = resultSet.getInt("ID");
                    String nombre = resultSet.getString("NOMBRE");
                    String apellido = resultSet.getString("APELLIDO");
                    String Password = resultSet.getString("PASSWORD");
                    int rol = resultSet.getInt("ID_ROL");
                    int estado = resultSet.getInt("ID_ESTADO");
                    Usuario usuario = new Usuario(id, nombre, apellido, Password, carnet, rol, estado);
                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
