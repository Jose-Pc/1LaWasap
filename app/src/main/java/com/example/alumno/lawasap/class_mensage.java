package com.example.alumno.lawasap;

import java.util.Date;

/**
 * Created by alumno on 5/10/17.
 */

public class class_mensage {
    protected String contenido=null;
    protected Date fecha;
    protected String remintente;

    public class_mensage(String contenido, Date fecha, String remintente) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.remintente = remintente;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
       // fecha = fecha.
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRemintente() {
        return remintente;
    }

    public void setRemintente(String remintente) {
        this.remintente = remintente;
    }
}
