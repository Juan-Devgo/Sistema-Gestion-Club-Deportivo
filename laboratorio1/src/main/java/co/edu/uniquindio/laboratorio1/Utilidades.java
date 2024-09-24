package co.edu.uniquindio.laboratorio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.uniquindio.laboratorio1.Model.Administrador;
import co.edu.uniquindio.laboratorio1.Model.Entrenador;
import co.edu.uniquindio.laboratorio1.Model.Miembro;
import co.edu.uniquindio.laboratorio1.Model.Persona;
import co.edu.uniquindio.laboratorio1.Model.SesionEntrenamiento;

public class Utilidades {
    
    private static Utilidades instancia;

    private ResourceBundle bundle;

    private static final Logger LOGGER = Logger.getLogger(Utilidades.class.getName());
    
    private Utilidades(){}

    public static Utilidades getInstancia(){
        if(instancia == null){
            instancia = new Utilidades();
        }
        return instancia;
    }

    public void EstablecerRutaBundle(String ruta){
        bundle = ResourceBundle.getBundle(ruta, App.getIdioma());
    }

    public String mostrarMensajeBundle(String key){
        return bundle.getString(key);
    }

    @SuppressWarnings("exports")
    public void escribirLog(Level level, String mensaje) throws IOException{
        FileHandler archivo = null;
        archivo = new FileHandler("MyLog.txt");
        LOGGER.addHandler(archivo);
        LOGGER.log(level, mensaje);
    }

    public void imprimirPersonas(LinkedList<Persona> personas) throws IOException{
        BufferedWriter bufferPersonas = new BufferedWriter(new FileWriter("personas.txt"));
        Administrador admin = App.getClub().getAdministrador();
        ArrayList<String> administrador = new ArrayList<>(); ArrayList<String> miembros = new ArrayList<>(); ArrayList<String> entrenadores = new ArrayList<>();
        administrador.add("Administrador: \n" ); administrador.add(admin.getNombre() + ", ID: " + admin.getIdentificacion() + "\n");
        miembros.add("Miembros: \n"); entrenadores.add("Entrenadores: \n");
        for (int i = 0; i < personas.size(); i++) {
            if(validarEsMiembro(personas.get(i))){
                Miembro miembro = (Miembro)personas.get(i);
                miembros.add(miembro.getNombre() + ", Correo: " + miembro.getCorreo() +", ID: " + miembro.getIdentificacion() + ", Tipo miembro: " + miembro.getTipoMiembro() + "\n");
            }else{
                Entrenador entrenador = (Entrenador)personas.get(i);
                entrenadores.add(entrenador.getNombre() + ", ID: " + entrenador.getIdentificacion() + ", Especialidad: " + entrenador.getEspecialidad() + "\n");
            }
        }

        int i = 0;

        for (String linea : administrador) {
            if(i < 10){
                bufferPersonas.flush();
            }
            bufferPersonas.write(linea);
            i++;
        }

        if(i < 10){
            bufferPersonas.flush();
        }
        bufferPersonas.write("\n");
        i++;

        for (String linea : miembros) {
            if(i < 10){
                bufferPersonas.flush();
            }
            bufferPersonas.write(linea);
            i++;
        }

        if(i < 10){
            bufferPersonas.flush();
        }
        bufferPersonas.write("\n");
        i++;

        for (String linea : entrenadores) {
            if(i < 10){
                bufferPersonas.flush();
            }
            bufferPersonas.write(linea);
            i++;
        }

        if(i < 10){
            bufferPersonas.flush();
        }
        bufferPersonas.write("\n");
        i++;

        bufferPersonas.flush();
        bufferPersonas.close();
        
    }

    public void imprimirSesiones(LinkedList<SesionEntrenamiento> sesiones) throws IOException {
        BufferedWriter bufferSesiones = new BufferedWriter(new FileWriter("sesiones.txt"));
        
        int i = 0;

        for (SesionEntrenamiento sesionEntrenamiento : sesiones) {
            if(i < 10){
                bufferSesiones.flush();
            }
            bufferSesiones.write(sesionEntrenamiento.toString());
            i += 4 + sesionEntrenamiento.getMiembros().size();

            if(i < 10){
                bufferSesiones.flush();
            }
            bufferSesiones.write("\n");
        }

        bufferSesiones.flush();
        bufferSesiones.close();
    }

    private boolean validarEsMiembro(Persona persona){
        boolean esMiembro = true;
        if (App.getClub().buscarEntrenadorPorNombre(persona.getNombre()).isPresent()){
            esMiembro = false;
        }
        return esMiembro; 
    } 
}