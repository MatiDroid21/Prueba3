/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Mati Droid
 */
public class Venta {
    private int idVenta;
    private String codVenta;
    private String cliente;
    private String libro;
    private int cantidad;
    private String fechaVenta;
    private int neto;
    private int total;

    public Venta() {
    }

    public Venta(int idVenta, String codVenta, String cliente, String libro, int cantidad, String fechaVenta, int neto, int total) {
        this.idVenta = idVenta;
        this.codVenta = codVenta;
        this.cliente = cliente;
        this.libro = libro;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.neto = neto;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getNeto() {
        return neto;
    }

    public void setNeto(int neto) {
        this.neto = neto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    
}
