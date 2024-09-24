package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.*;
import co.edu.uniquindio.laboratorio1.Model.*;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import java.util.logging.Level;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aceptarbt;

    @FXML
    private TextField identificaciontxt;

    @FXML
    private TextField usuariotxt;

    @FXML
    private Label titulolb;

    @FXML
    private ChoiceBox<String> idioma;

    private String[] idiomas = {"Español", "English"};

    @FXML
    void initialize() throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Inicializando LoginController...");
        Utilidades.getInstancia().EstablecerRutaBundle("resources/login");
        this.idioma.getItems().addAll(idiomas);
        titulolb.setText(Utilidades.getInstancia().mostrarMensajeBundle("titulolb"));
        usuariotxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombre"));
        identificaciontxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptIdentificacion"));
        aceptarbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("aceptarbt"));
        Utilidades.getInstancia().escribirLog(Level.INFO, "LoginController inicializado");
    }

    @FXML
    void loggear(ActionEvent event) throws IOException{
        String nombre = usuariotxt.getText();
        String identificacion = identificaciontxt.getText();

        if((nombre != null && !nombre.isBlank()) && (identificacion != null && !identificacion.isBlank())){
            App.getClub().setAdministrador(new Administrador(nombre, identificacion));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Administrador creado");
            cambiarIdioma();
            Utilidades.getInstancia().escribirLog(Level.INFO, "Cambiando a principal...");
            App.setRoot("principal");
            Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a principal");
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroDatosNulos"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error datos nulos");
        }
    }

    private void cambiarIdioma() throws IOException{

        switch (idioma.getValue()) {
            case "English":
                App.setIdioma(new Locale("en", "US"));
                Utilidades.getInstancia().escribirLog(Level.INFO, "Idioma cambiado a inglés Estados Unidos");
                break;
            case "Español":
                App.setIdioma(new Locale("es", "CO"));
                Utilidades.getInstancia().escribirLog(Level.INFO, "Idioma cambiado a Español Colombia");
                break;
            default:
                App.setIdioma(new Locale("es", "CO"));
                Utilidades.getInstancia().escribirLog(Level.INFO, "Idioma predeterminado Español Colombia");
                break;
        }

    }

}