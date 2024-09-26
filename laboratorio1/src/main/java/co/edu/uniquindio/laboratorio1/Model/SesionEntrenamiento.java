package co.edu.uniquindio.laboratorio1.Model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

import java.io.Serializable;

public class SesionEntrenamiento implements Serializable{

    private String codigo;
    private LocalDateTime fechaYHora;
    private Duration duracion;
    private boolean completada;
    private Entrenador entrenador;
    private Deporte deporte;
    private LinkedList<Miembro> miembros;

    public SesionEntrenamiento(String codigo, LocalDateTime fechaYHora, Duration duracion, Entrenador entrenador, Deporte deporte){

        this.codigo = codigo;
        this.fechaYHora = fechaYHora;
        this.duracion = duracion;
        this.entrenador = entrenador;
        this.completada = false;
        this.deporte = deporte;
        this.miembros = new LinkedList<>();

        entrenador.agregarSesionEntrenamiento(this);

    }

    public SesionEntrenamiento(){}

    public void asignarMiembro(Miembro miembro){
        assert miembro != null;
        miembros.add(miembro);
    }

    public String getCodigo(){
        return codigo;
    }
    public Duration getDuracion(){
        return duracion;
    }
    public LocalDateTime getFechaYHora(){
        return fechaYHora;
    }
    public boolean getCompletada(){
        return completada;
    }
    public Entrenador getEntrenador(){
        return entrenador; 		
	}
    public Deporte getDeporte(){
        return deporte;
    }
    public LinkedList<Miembro> getMiembros() {
        return miembros;
    }
    public void setDuracion(Duration duracion){
        this.duracion = duracion;
    }
    public void setFechaYHora(LocalDateTime fechaYHora){
        this.fechaYHora = fechaYHora;
    }
    public void completar(){
        this.completada = LocalDateTime.now().isAfter(fechaYHora);
    }

    public String toString() {
        String mensaje = "Fecha y Hora: " + fechaYHora + '\n' + "Entrenador: " + entrenador.getNombre() + ". Identificación: " + entrenador.getIdentificacion() + 
        '\n' + "Duración: " + duracion + '\n' + "Deporte: " + deporte.getNombre() + ". Descripción: " + deporte.getDescripcion() + '\n' + "Miembros: ";

        for (Miembro miembro : miembros) {
            mensaje += miembro.getNombre() + ". Identificacion: " + miembro.getIdentificacion() + '\n';
        }
        
        return mensaje;
    }

}
