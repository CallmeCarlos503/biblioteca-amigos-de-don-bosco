/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import DAO.UsuarioDAO;
import java.util.List;
import objectos.Usuario;

import DAO.UsuarioDAO;
import objectos.Usuario;

import java.util.List;

public class Listar_Usuarios {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();

        for (Usuario usuario : usuarios) {
            
            System.out.println("Carnet: " + usuario.getCARNET());
            System.out.println("Contraseña: " + usuario.getPASSWORD());
            System.out.println("Nombre: " + usuario.getNOMBRE());
            System.out.println("---------------------------");
        }
    }
}