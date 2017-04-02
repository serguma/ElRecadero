package serguma.elrecadero;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by sergu on 02/04/2017.
 */

public class Recado implements Comparable<Recado>, Serializable {

    private String fecha_hora;
    private String nombre_cliente;
    private String telefono;
    private String direccion_recogida;
    private String direccion_entrega;
    private String descripcion;
    private String fecha_hora_maxima;
    private boolean completado;

    public Recado(String fecha_hora, String nombre_cliente, String telefono, String direccion_recogida, String direccion_entrega, String descripcion, String fecha_hora_maxima) throws ParseException {

        this.fecha_hora = fecha_hora;
        this.nombre_cliente = nombre_cliente;
        this.telefono = telefono;
        this.direccion_recogida = direccion_recogida;
        this.direccion_entrega = direccion_entrega;
        this.descripcion = descripcion;
        this.fecha_hora_maxima = fecha_hora_maxima;
        this.completado = false;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion_recogida() {
        return direccion_recogida;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha_hora_maxima() {
        return fecha_hora_maxima;
    }

    @Override
    public int compareTo(@NonNull Recado o) {
        return this.getFecha_hora().compareTo(o.getFecha_hora());
    }
}
