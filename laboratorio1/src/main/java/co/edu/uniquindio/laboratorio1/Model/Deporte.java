package co.edu.uniquindio.laboratorio1.Model;

import java.util.LinkedList;

import java.io.Serializable;

public class Deporte implements Serializable{

    //Atributo de versión de serialización en XML
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String descripcion;
    private Dificultad dificultad;
    private LinkedList<Entrenador> entrenadores;
    
    public Deporte(String nombre, String descripcion, Dificultad dificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.entrenadores = new LinkedList<>();
    }

    public void agregarEntrenador(Entrenador entrenador) {

        entrenadores.add(entrenador);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LinkedList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
