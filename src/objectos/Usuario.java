/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectos;

/**
 *
 * @author Carlo
 */
public class Usuario {

    String NOMBRE, APELLIDO, CARNET,PASSWORD;
    int ID_ROL, ID_ESTADO,Limites_de_libros;
    int ID;

    public Usuario() {
    }

    public Usuario(String NOMBRE, String APELLIDO, String CARNET, String PASSWORD, int ID_ROL, int ID_ESTADO, int Limites_de_libros) {
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.CARNET = CARNET;
        this.PASSWORD = PASSWORD;
        this.ID_ROL = ID_ROL;
        this.ID_ESTADO = ID_ESTADO;
        this.Limites_de_libros = Limites_de_libros;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getCARNET() {
        return CARNET;
    }

    public void setCARNET(String CARNET) {
        this.CARNET = CARNET;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public int getID_ROL() {
        return ID_ROL;
    }

    public void setID_ROL(int ID_ROL) {
        this.ID_ROL = ID_ROL;
    }

    public int getID_ESTADO() {
        return ID_ESTADO;
    }

    public void setID_ESTADO(int ID_ESTADO) {
        this.ID_ESTADO = ID_ESTADO;
    }

    public int getLimites_de_libros() {
        return Limites_de_libros;
    }

    public void setLimites_de_libros(int Limites_de_libros) {
        this.Limites_de_libros = Limites_de_libros;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
      
}