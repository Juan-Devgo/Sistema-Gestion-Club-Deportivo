package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.App;
import co.edu.uniquindio.laboratorio1.Utilidades;
import co.edu.uniquindio.laboratorio1.Model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProgramarSesionEntrenamientoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aceptarbt;

    @FXML
    private TextField codigotxt;

    @FXML
    private TextField deportetxt;

    @FXML
    private TextField duraciontxt;

    @FXML
    private DatePicker fechapicker;

    @FXML
    private TextField horatxt;

    @FXML
    private TextField nombreentrenadortxt;

    @FXML
    private Button volverbt;

    @FXML
    private Label titulolb;

    @FXML
    void cambiarPrincipal(ActionEvent event) throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Volviendo a principal...");
        App.setRoot("principal");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a principal");
    }

    @FXML
    void initialize() throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Inicializando ProgramarSesionEntrenamientoController...");
        Utilidades.getInstancia().EstablecerRutaBundle("resources/sesionEntrenamiento");
        fechapicker.setValue(LocalDate.now());
        titulolb.setText(Utilidades.getInstancia().mostrarMensajeBundle("titulolb"));
        codigotxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptCodigoSesion"));
        fechapicker.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptFecha"));
        horatxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptHora"));
        duraciontxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptDuracion"));
        deportetxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombreDeporte"));
        nombreentrenadortxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombreEntrenador"));
        aceptarbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("aceptarbt"));
        volverbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("volverbt"));
        Utilidades.getInstancia().escribirLog(Level.INFO, "ProgramarSesionEntrenamientoController Inicializado");
    }

    @FXML
    void programarSesion(ActionEvent event) throws IOException{
        String codigo = codigotxt.getText();
        LocalDate fecha = fechapicker.getValue(); LocalTime hora = null;

        try{
            hora = LocalTime.parse(horatxt.getText());
        }catch(DateTimeException e){
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorFormatoHoraInvalido"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error formato hora inválido");
        }

        Duration duracion = Duration.ofMinutes(Long.parseLong(duraciontxt.getText()));
        String entrenadorNombre = nombreentrenadortxt.getText();
        String deporteNombre = deportetxt.getText();

        if((codigo != null && !codigo.isBlank()) && (fecha != null) && (duracion != null)
        && (entrenadorNombre != null && !entrenadorNombre.isBlank()) && (deporteNombre != null && !deporteNombre.isBlank())){

            Entrenador entrenador = registrarEntrenador(entrenadorNombre.toLowerCase());
            Deporte deporte = registrarDeporte(deporteNombre.toLowerCase());
            if((entrenador != null) && (deporte != null) && (hora != null)){

                LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);

                if(!App.getClub().buscarEntrenamientoPorCodigo(codigo).isPresent()){
                
                    if(!(buscarMismaFechaYHora(entrenador, fechaYHora).isPresent())){
                        App.getClub().agregarSesionEntrenamiento(new SesionEntrenamiento(codigo, fechaYHora, duracion, entrenador, deporte));
                        validarRegistro(codigo);
                        codigotxt.setText(""); fechapicker.setValue(LocalDate.now()); horatxt.setText(""); duraciontxt.setText(""); nombreentrenadortxt.setText(""); deportetxt.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorHoraProgramada"));
                        Utilidades.getInstancia().escribirLog(Level.WARNING, "Error hora programada repetida");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorCodigoSesion"));
                    Utilidades.getInstancia().escribirLog(Level.WARNING, "Error codigo sesión ya usado");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroDatosNulos"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error datos nulos");
        }
    }

    private Optional<SesionEntrenamiento> buscarMismaFechaYHora(Entrenador entrenador, LocalDateTime fechaYHora) {
        Predicate<SesionEntrenamiento> condicion = sesion -> sesion.getFechaYHora().equals(fechaYHora);
        return entrenador.getSesionesEntrenamientos().stream().filter(condicion).findAny();
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

    private Deporte registrarDeporte(String nombre)throws IOException{
        
        Deporte deporte = null; var resultadoBusqueda = App.getClub().buscarDeportePorNombre(nombre);
        
            if(resultadoBusqueda.isPresent()){
                deporte = resultadoBusqueda.get();
            }else{
                JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeDeporteNulo"));
                Utilidades.getInstancia().escribirLog(Level.WARNING, "Error deporte no encontrado");
            }

        return deporte;
    }

    private void validarRegistro(String codigo) throws IOException{
        if(App.getClub().buscarEntrenamientoPorCodigo(codigo).isPresent()){
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroSatisfactorio"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Sesión registrada");
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorEnElRegistro"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Error en el registro"); 
        }
    }
}