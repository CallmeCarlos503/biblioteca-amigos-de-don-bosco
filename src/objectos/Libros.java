/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectos;

/**
 *
 * @author Carlo
 */
public class Libros {
    String Nombre;
    int Estado;
    int ID;
    int ID_Categoria;
    int Cantidad_Disponible;

    public Libros() {
    }

    public Libros(String Nombre, int Estado, int ID_Categoria, int Cantidad_Disponible) {
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.ID_Categoria = ID_Categoria;
        this.Cantidad_Disponible = Cantidad_Disponible;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCantidad_Disponible() {
        return Cantidad_Disponible;
    }

    public void setCantidad_Disponible(int Cantidad_Disponible) {
        this.Cantidad_Disponible = Cantidad_Disponible;
    }

   

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }
    
}
