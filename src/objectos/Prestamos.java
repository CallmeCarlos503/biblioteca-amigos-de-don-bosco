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
    private int ID;
    private int ID_Libro;
    private String Carnet;
    private int ID_Estado;
    private String Fecha;
    private int Mora;

    public Prestamos() {
    }

    public Prestamos(int ID, int ID_Libro, String Carnet, int ID_Estado, String Fecha, int Mora) {
        this.ID = ID;
        this.ID_Libro = ID_Libro;
        this.Carnet = Carnet;
        this.ID_Estado = ID_Estado;
        this.Fecha = Fecha;
        this.Mora = Mora;
    }

    public int getMora() {
        return Mora;
    }

    public void setMora(int Mora) {
        this.Mora = Mora;
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
    

       
}
