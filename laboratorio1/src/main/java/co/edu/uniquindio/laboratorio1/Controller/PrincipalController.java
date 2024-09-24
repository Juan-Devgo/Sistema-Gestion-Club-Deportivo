package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.Model.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;

import co.edu.uniquindio.laboratorio1.App;
import co.edu.uniquindio.laboratorio1.Utilidades;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class PrincipalController {

    @FXML
    private Button aceptarentrenadorbt;

    @FXML
    private Button aceptarmiembrobt;

    @FXML
    private Label infolb;

    @FXML
    private TextField codigosesiontxt;

    @FXML
    private TextField codigotxt;

    @FXML
    private TextField nombredeportetxt;

    @FXML
    private TextField nombreentrenadortxt;

    @FXML
    private TextField nombremiembrotxt;

    @FXML
    private Button programarsesionbt;

    @FXML
    private Button registrardeportebt;

    @FXML
    private Button registrarentrenadorbt;

    @FXML
    private Button registrarmiembrobt;

    @FXML
    private Button listaPersonasbt;

    @FXML
    private Button listaSesionesbt;

    @FXML
    private TextArea infotxt;

    @FXML
    private Button volverbt;

    @FXML
    private Label titulolb;

    @FXML
    private Label asignarMiembrolb;

    @FXML
    private Label asignarEntrenadorlb;

    @FXML
    private Label consultalb;

    @FXML
    private Button consultarbt;

    @FXML
    private Tab registrotab;

    @FXML
    private Tab asignaciontab;
    
    @FXML
    private Tab consultatab;

    @FXML
    private Tab generarListastab;
    
    @FXML
    void cambiarLogin(ActionEvent event) throws IOException {
        Utilidades.getInstancia().escribirLog(Level.INFO, "Volviendo a login...");
        App.setRoot("login");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a login");
    }

    @FXML
    void cambiarAgregarMiembro(ActionEvent event) throws IOException {
        Utilidades.getInstancia().escribirLog(Level.INFO, "Cambiando a AgregarMiembro");
        App.setRoot("agregarMiembro");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a AgregarMiembro");
    }

    @FXML
    void cambiarAgregarEntrenador(ActionEvent event) throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Cambiando a AgregarEntrenador");
        App.setRoot("agregarEntrenador");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a AgregarEntrenador");
    }

    @FXML
    void cambiarProgramarSesionEntrenamiento(ActionEvent event) throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Cambiando a ProgramarSesionEntrenamiento");
        App.setRoot("programarSesionEntrenamiento");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a ProgramarSesionEntrenamiento");
    }

    @FXML
    void cambiarAgregarDeporte(ActionEvent event) throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Cambiando a AgregarDeporte");
        App.setRoot("agregarDeporte");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a AgregarDeporte");
    }

    @FXML
    void initialize() throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Inicializando PrincipalController...");
        Utilidades.getInstancia().EstablecerRutaBundle("resources/principal");
        titulolb.setText(Utilidades.getInstancia().mostrarMensajeBundle("titulolb"));
        registrotab.setText(Utilidades.getInstancia().mostrarMensajeBundle("registrotab"));
        asignaciontab.setText(Utilidades.getInstancia().mostrarMensajeBundle("asignaciontab"));
        generarListastab.setText(Utilidades.getInstancia().mostrarMensajeBundle("generarListastab"));
        consultatab.setText(Utilidades.getInstancia().mostrarMensajeBundle("consultatab"));
        registrardeportebt.setText(Utilidades.getInstancia().mostrarMensajeBundle("registrarDeportebt"));
        registrarmiembrobt.setText(Utilidades.getInstancia().mostrarMensajeBundle("registrarMiembrobt"));
        registrarentrenadorbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("registrarEntrenadorbt"));
        programarsesionbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("programarSesionbt"));
        listaPersonasbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("listaPersonasbt"));
        listaSesionesbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("listaSesionesbt"));
        asignarMiembrolb.setText(Utilidades.getInstancia().mostrarMensajeBundle("asignarMiembrolb"));
        nombremiembrotxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombreMiembro"));
        codigosesiontxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptCodigoSesion"));
        asignarEntrenadorlb.setText(Utilidades.getInstancia().mostrarMensajeBundle("asignarEntrenadorlb"));
        nombreentrenadortxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombreEntrenador"));
        nombredeportetxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombreDeporte"));
        consultalb.setText(Utilidades.getInstancia().mostrarMensajeBundle("consultalb"));
        codigotxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptCodigoSesion"));
        consultarbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("consultarbt"));
        volverbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("volverbt"));
        aceptarmiembrobt.setText(Utilidades.getInstancia().mostrarMensajeBundle("aceptarbt"));
        aceptarentrenadorbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("aceptarbt"));
        Utilidades.getInstancia().escribirLog(Level.INFO, "PrincipalController inicializado");
    }

    @FXML
    void asignarEntrenadorDeporte(ActionEvent event) throws IOException{
        String deporteNombre = nombredeportetxt.getText().toLowerCase();
        String entrenadorNombre = nombreentrenadortxt.getText().toLowerCase();

        if(deporteNombre != null && !deporteNombre.isBlank() && entrenadorNombre != null && !entrenadorNombre.isBlank()){
            
            Deporte deporte = registrarDeporte(deporteNombre); 
            Entrenador entrenador = registrarEntrenador(entrenadorNombre);
            if(entrenador != null && deporte != null){
                App.getClub().asignarEntrenadorADeporte(entrenador, deporte);
                validarEntrenadorDeporte(entrenador, deporte);
                nombredeportetxt.setText(""); nombreentrenadortxt.setText("");
            }
        }else{
                JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroDatosNulos"));
                Utilidades.getInstancia().escribirLog(Level.WARNING, "Error datos nulos");
            }
        
    }
    
    private void validarEntrenadorDeporte(Entrenador entrenador, Deporte deporte) throws IOException{
        if(entrenador.getEspecialidad() == deporte.getNombre()){
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeAsignacionExitosa"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Entrenador asignado a deporte");
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorAsignacion"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Incapaz de realizar la asignacion de entrenador");
        }
    }

    private Deporte registrarDeporte(String nombre)throws IOException {
        
        Deporte deporte = null; var resultadoBusqueda = App.getClub().buscarDeportePorNombre(nombre);
        
        if(resultadoBusqueda.isPresent()){
            deporte = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeDeporteNulo"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error deporte no encontrado");
        }

        return deporte;
    }

    private Entrenador registrarEntrenador(String nombre) throws IOException{
        
        Entrenador entrenador = null; var resultadoBusqueda = App.getClub().buscarEntrenadorPorNombre(nombre);
        
        if(resultadoBusqueda.isPresent()){
            entrenador = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeEntrenadorNulo"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error entrenador no encontrado");
            
        }

        return entrenador;
    }

    @FXML
    void asignarMiembroSesion(ActionEvent event)throws IOException {
        String miembroNombre = nombremiembrotxt.getText().toLowerCase();
        String sesionCodigo = codigosesiontxt.getText();

        if(miembroNombre != null && !miembroNombre.isBlank() && sesionCodigo != null && !sesionCodigo.isBlank()){
            
            Miembro miembro = registrarMiembro(miembroNombre);
            SesionEntrenamiento sesionEntrenamiento = registrarEntrenamiento(sesionCodigo);
            if((miembro != null) && (sesionEntrenamiento != null)){

                App.getClub().asignarMiembroASesion(miembro, sesionEntrenamiento);
                validarMiembroSesion(sesionEntrenamiento, miembro);
                nombremiembrotxt.setText(""); codigosesiontxt.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroDatosNulos"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error datos nulos");
        }
    }

    private Miembro registrarMiembro(String nombre) throws IOException{
        
        Miembro miembro = null; var resultadoBusqueda = App.getClub().buscarMiembroPorNombre(nombre);

            if(resultadoBusqueda.isPresent()){
                miembro = resultadoBusqueda.get();
            }else{
                JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeMiembroNulo"));
                Utilidades.getInstancia().escribirLog(Level.WARNING, "Error miembro no encontrado");
            }
        return miembro;
    }

    private SesionEntrenamiento registrarEntrenamiento(String codigo)throws IOException{

        SesionEntrenamiento sesionEntrenamiento = null; var resultadoBusqueda = App.getClub().buscarEntrenamientoPorCodigo(codigo);
                
        if(resultadoBusqueda.isPresent()){
            sesionEntrenamiento = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeSesionNula"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error sesión no encontrada");
        }
        return sesionEntrenamiento;
    }
    
    private void validarMiembroSesion(SesionEntrenamiento sesionEntrenamiento, Miembro miembro) throws IOException{
        if(sesionEntrenamiento.getMiembros().contains(miembro)){
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeAsignacionExitosa"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Miembro asignado a sesión");
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorEnElRegistro"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Incapaz de realizar la asignación de miembro");
        }
	}

    @FXML
    void consultarEstadoSesionEntrenamiento(ActionEvent event) throws IOException{
        SesionEntrenamiento sesionEntrenamiento = registrarEntrenamiento(codigotxt.getText());

        if(sesionEntrenamiento != null){
            sesionEntrenamiento.completar();
            infolb.setText(sesionEntrenamiento.toString());

            if(sesionEntrenamiento.getCompletada() == true){
                JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeSesionCompletada"));
            }
            else{
                JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeSesionPendiente"));
            }

            Utilidades.getInstancia().escribirLog(Level.INFO, "Estado de sesión consultado");
        }
    }

    @FXML
    void GenerarListaPersonas(ActionEvent event) throws IOException{
        LinkedList<Persona> personas = new LinkedList<>();
        personas.addAll(App.getClub().getMiembros());
        personas.addAll(App.getClub().getEntrenadores());

        Utilidades.getInstancia().imprimirPersonas(personas);

        JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeListaPersonasImpresa"));
        Utilidades.getInstancia().escribirLog(Level.INFO, "Lista de personas impresa");
    }

    @FXML
    void GenerarListaSesiones(ActionEvent event) throws IOException{
        LinkedList<SesionEntrenamiento> sesionEntrenamientos = new LinkedList<>(); 
        sesionEntrenamientos.addAll(App.getClub().getSesionesEntrenamiento());

        Utilidades.getInstancia().imprimirSesiones(sesionEntrenamientos); 

        JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeListaSesionesImpresa"));
        Utilidades.getInstancia().escribirLog(Level.INFO, "Lista de sesiones impresa");
    }
}