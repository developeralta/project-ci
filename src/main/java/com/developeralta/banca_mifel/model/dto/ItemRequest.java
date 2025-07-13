package com.developeralta.banca_mifel.model.dto;

public class ItemRequest {

    private String nombre;
    private String descrip;
    private Integer cantidad;

    public ItemRequest() {
    }

    public ItemRequest(String nombre, String descrip, Integer cantidad) {
        this.nombre = nombre;
        this.descrip = descrip;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "ItemRequest [nombre=" + nombre + ", descrip=" + descrip + ", cantidad=" + cantidad + "]";
    }

}
