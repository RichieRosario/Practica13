package pucmm.practica13.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Mensaje")
@Table(name = "Mensaje")
@Where(clause = "deleted = 0")
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private long id;

    @Column(name = "fechaCreacion")
    public String fechaCreacion;

    @Column(name = "idDispositivo")
    public int idDispositivo;

    @Column(name = "temperatura")
    public double temperatura;

    @Column(name = "humedad")
    public double humedad;



    private boolean deleted = false;

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public Mensaje() {
    }

    public Mensaje(String fechaCreacion, int idDispositivo, double temperatura, double humedad) {
        this.fechaCreacion = fechaCreacion;
        this.idDispositivo = idDispositivo;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id + '\'' +
                "fechaCreacion='" + fechaCreacion + '\'' +
                ", idDispositivo='" + idDispositivo + '\'' +
                ", temperatura=" + temperatura +
                ", humedad=" + humedad +
                '}';
    }
}
