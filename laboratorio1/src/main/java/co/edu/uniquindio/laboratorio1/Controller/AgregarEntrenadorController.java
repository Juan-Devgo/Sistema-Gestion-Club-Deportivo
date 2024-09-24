package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.*;
import co.edu.uniquindio.laboratorio1.Model.*;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.util.logging.Level;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AgregarEntrenadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aceptarbt;

    @FXML
    private TextField identificaciontxt;

    @FXML
    private TextField nombretxt;

    @FXML
    private Button volverbt;

    @FXML
    private Label titulolb;

    @FXML
    void initialize() throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Inicializanco AgregarEntrenadorController...");
        Utilidades.getInstancia().EstablecerRutaBundle("resources/entrenador");
        titulolb.setText(Utilidades.getInstancia().mostrarMensajeBundle("titulolb"));
        nombretxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombre"));
        identificaciontxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptIdentificacion"));
        aceptarbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("aceptarbt"));
        volverbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("volverbt"));
        Utilidades.getInstancia().escribirLog(Level.INFO, "AgregarEntrenadorController inicializado");
    }

    @FXML
    void volverAPrincipal(ActionEvent event) throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Volviendo a principal...");
        App.setRoot("principal");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a principal");
    }

    @FXML
    void registrarEntrenador(ActionEvent event) throws IOException {
        
        String nombre = nombretxt.getText();
        String identificacion = identificaciontxt.getText();

        if((nombre!=null && !nombre.isBlank()) && (identificacion != null && !identificacion.isBlank())){

            if(!(App.getClub().buscarEntrenadorPorNombre(nombre.toLowerCase()).isPresent() || (App.getClub().buscarEntrenadorPorIdentificacion(identificacion).isPresent()))){
                App.getClub().agregarEntrenador(new Entrenador(nombre.toLowerCase(), identificacion));
                validarRegistro(identificacion);
                nombretxt.setText(""); identificaciontxt.setText("");
            }else{
                JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroEntrenadorExistente"));
                Utilidades.getInstancia().escribirLog(Level.WARNING, "Error entrenador existente");
            }
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroDatosNulos"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error datos nulo");
        }
    }

	private void validarRegistro(String identificacion) throws IOException{
        if(App.getClub().buscarEntrenadorPorIdentificacion(identificacion).isPresent()){
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroSatisfactorio"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Entrenador registrado");
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorEnELRegistro"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Incapaz de registrar entrenador");
        }
	}

}
