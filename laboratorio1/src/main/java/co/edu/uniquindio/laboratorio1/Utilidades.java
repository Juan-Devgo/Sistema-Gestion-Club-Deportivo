package co.edu.uniquindio.laboratorio1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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

    //Obtener instancia utilidades

    public static Utilidades getInstancia(){
        if(instancia == null){
            instancia = new Utilidades();
        }
        return instancia;
    }

    //Métodos para los ResourceBundles

    public void EstablecerRutaBundle(String ruta){
        bundle = ResourceBundle.getBundle(ruta, App.getIdioma());
    }

    public String mostrarMensajeBundle(String key){
        return bundle.getString(key);
    }

    //Método para escribir logs

    @SuppressWarnings("exports")
    public void escribirLog(Level level, String mensaje) throws IOException{
        FileHandler archivo;
        archivo = new FileHandler("C:/Users/Angie/Programación/Programación 3/Sistema-Gestion-Club-Deportivo/laboratorio1/src/main/resources/Logs/MyLog.txt",true);
        archivo.setFormatter(new SimpleFormatter());  
        LOGGER.addHandler(archivo);
        LOGGER.setUseParentHandlers(false);
        LOGGER.log(level, mensaje);
        archivo.close(); 

    }

    //Métodos de manejo de txt

    public void imprimirPersonas(LinkedList<Persona> personas) throws IOException{
        BufferedWriter bufferPersonas = new BufferedWriter(new FileWriter("C:/Users/Angie/Programación/Programación 3/Sistema-Gestion-Club-Deportivo/laboratorio1/src/main/resources/Archivostxt/personas.txt"));
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
        BufferedWriter bufferSesiones = new BufferedWriter(new FileWriter("C:/Users/Angie/Programación/Programación 3/Sistema-Gestion-Club-Deportivo/laboratorio1/src/main/resources/Archivostxt/sesiones.txt"));
        
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

    //Métodos para serializar

    public void serializarObjetoDat(String nombre, Object objeto) throws IOException {

        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("C:/Users/Angie/Programación/Programación 3/Sistema-Gestion-Club-Deportivo/laboratorio1/src/main/resources/ArchivosSerializados/" + nombre));
        salida.writeObject(objeto);
        salida.close();

    }

    public void serializarObjetoXML(String nombre, Object objeto) throws IOException {

        XMLEncoder codificador = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("C:/Users/Angie/Programación/Programación 3/Sistema-Gestion-Club-Deportivo/laboratorio1/src/main/resources/ArchivosSerializados/" + nombre)));
        codificador.writeObject(objeto);
        codificador.close();

    }

    //Métodos para deserializar

    public Object deserializarObjetoDat(String nombre) throws Exception {

        Object objeto;

        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("C:/Users/Angie/Programación/Programación 3/Sistema-Gestion-Club-Deportivo/laboratorio1/src/main/resources/ArchivosSerializados/" + nombre));
        objeto = entrada.readObject();
        entrada.close();

        return objeto;

    }

    public Object deserializarObjetoXML(String nombre) throws IOException {

        Object objeto;

        XMLDecoder decodificador = new XMLDecoder(new BufferedInputStream(new FileInputStream("C:/Users/Angie/Programación/Programación 3/Sistema-Gestion-Club-Deportivo/laboratorio1/src/main/resources/ArchivosSerializados/" + nombre)));
        objeto = decodificador.readObject();
        decodificador.close();

        return objeto;
    }
}