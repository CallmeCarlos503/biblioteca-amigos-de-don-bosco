/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectos;

import java.time.LocalDate;

/**
 *
 * @author Carlo
 */
public class Prestamos {
    int ID;
    int ID_Libro;
    String Carnet;
    int ID_Estado;
    String Fecha;
    int Mora;
    String Nombre_Usuario;
    String Carnet_Usuario;
    String Nombre_Libro;
    String Estado_de_mora;

    public Prestamos() {
    }

    public Prestamos(int ID, int ID_Libro, String Carnet, int ID_Estado, String Fecha, int Mora, String Nombre_Usuario, String Carnet_Usuario, String Nombre_Libro, String Estado_de_mora) {
        this.ID = ID;
        this.ID_Libro = ID_Libro;
        this.Carnet = Carnet;
        this.ID_Estado = ID_Estado;
        this.Fecha = Fecha;
        this.Mora = Mora;
        this.Nombre_Usuario = Nombre_Usuario;
        this.Carnet_Usuario = Carnet_Usuario;
        this.Nombre_Libro = Nombre_Libro;
        this.Estado_de_mora = Estado_de_mora;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getCarnet_Usuario() {
        return Carnet_Usuario;
    }

    public void setCarnet_Usuario(String Carnet_Usuario) {
        this.Carnet_Usuario = Carnet_Usuario;
    }

    public String getNombre_Libro() {
        return Nombre_Libro;
    }

    public void setNombre_Libro(String Nombre_Libro) {
        this.Nombre_Libro = Nombre_Libro;
    }

    public String getEstado_de_mora() {
        return Estado_de_mora;
    }

    public void setEstado_de_mora(String Estado_de_mora) {
        this.Estado_de_mora = Estado_de_mora;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Libro() {
        return ID_Libro;
    }

    public void setID_Libro(int ID_Libro) {
        this.ID_Libro = ID_Libro;
    }

    public String getCarnet() {
        return Carnet;
    }

    public void setCarnet(String Carnet) {
        this.Carnet = Carnet;
    }

    public int getID_Estado() {
        return ID_Estado;
    }

    public void setID_Estado(int ID_Estado) {
        this.ID_Estado = ID_Estado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getMora() {
        return Mora;
    }

    public void setMora(int Mora) {
        this.Mora = Mora;
    }
    
}
