package co.edu.uniquindio.laboratorio1.Model;

import java.io.Serializable;

public abstract class Persona implements Serializable{

    //Atributo de versión de serialización en XML
    private static final long serialVersionUID = 1L;
    
    protected String nombre;
    protected String identificacion;

    public Persona(){}

    public Persona(String nombre, String identificacion){
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre(){
        return nombre;
    }

    public String getIdentificacion(){
        return identificacion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }
}
