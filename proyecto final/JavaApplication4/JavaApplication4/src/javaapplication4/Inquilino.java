package javaapplication4;

import java.io.Serializable;

public class Inquilino implements Serializable {

    private String nombre;
    private String Direccion;
    private Integer cedula;
    private Float telefono;

    public Inquilino (String nombre, String Direccion, Integer cedula, Float telefono) {
        this.nombre = nombre;
        this.Direccion = Direccion;
        this.cedula = cedula;
        this.telefono= telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Integer getCantidad() {
        return cedula;
    }

    public void setCantidad(Integer cantidad) {
        this.cedula = cantidad;
    }

    public Float getValor() {
        return telefono;
    }

    public void setValor(Float valor) {
        this.telefono = valor;
    }

    @Override
    public String toString() {
        return "Propietario [" + nombre + ", " + Direccion + ", cedula=" + cedula + ", telefono="
                + telefono + "]";
    }

    void setcedula(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void settelefono(float parseFloat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
