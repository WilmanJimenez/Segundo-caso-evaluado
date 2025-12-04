/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundo.caso.evaluado;

/**
 *
 * @author Wilman
 */
public class Asientos {
    private Disponibilidad disponibilidad;
    private String letra;
    private String codigoAsiento;
    private String clase;
    private double precio;
    private String nombreCliente;
    private String numeroPasaporteCliente;
    private String nacionalidadlCiente;

    public Asientos(Disponibilidad disponibilidad, String letra, String codigoAsiento, String clase, double precio) {
        this.disponibilidad = disponibilidad;
        this.letra = letra;
        this.codigoAsiento = codigoAsiento;
        this.clase = clase;
        this.precio = precio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroPasaporteCliente() {
        return numeroPasaporteCliente;
    }

    public void setNumeroPasaporteCliente(String numeroPasaporteCliente) {
        this.numeroPasaporteCliente = numeroPasaporteCliente;
    }

    public String getNacionalidadlCiente() {
        return nacionalidadlCiente;
    }

    public void setNacionalidadlCiente(String nacionalidadlCiente) {
        this.nacionalidadlCiente = nacionalidadlCiente;
    }
    

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getCodigoAsiento() {
        return codigoAsiento;
    }

    public void setCodigoAsiento(String codigoAsiento) {
        this.codigoAsiento = codigoAsiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
