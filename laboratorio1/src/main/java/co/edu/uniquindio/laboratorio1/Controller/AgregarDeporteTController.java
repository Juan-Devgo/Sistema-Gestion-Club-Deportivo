package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.*;
import co.edu.uniquindio.laboratorio1.Model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.util.logging.Level;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AgregarDeporteTController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aceptarbt;

    @FXML
    private TextArea descripciontxt;

    @FXML
    private ChoiceBox<String> dificultadChoice;

    @FXML
    private TextField nombretxt;

    @FXML
    private Label titulolb;

    @FXML
    private Label dificultadlb;
    
    @FXML
    private Button volverbt;

    @FXML
    void initialize() throws IOException{
        Utilidades.getInstancia().EstablecerRutaBundle("resources/deporte");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Inicializando DeporteController...");
        String[] dificultad = {Utilidades.getInstancia().mostrarMensajeBundle("dificultadAlta"), 
                                Utilidades.getInstancia().mostrarMensajeBundle("dificultadMedia"), 
                                Utilidades.getInstancia().mostrarMensajeBundle("dificultadBaja")};
        dificultadChoice.getItems().addAll(dificultad);
        titulolb.setText(Utilidades.getInstancia().mostrarMensajeBundle("titulolb"));
        dificultadlb.setText(Utilidades.getInstancia().mostrarMensajeBundle("dificultadlb"));
        nombretxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombre"));
        descripciontxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptDescripcion"));
        aceptarbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("aceptarbt"));
        volverbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("volverbt"));
        Utilidades.getInstancia().escribirLog(Level.INFO, "DeporteController inicializado");
    }

    @FXML
    void registrarDeporte(ActionEvent event) throws IOException{
        String nombre = nombretxt.getText();
        String descripcion = descripciontxt.getText();
        String dificultadNombre = dificultadChoice.getValue();

        if((nombre != null && !nombre.isBlank()) && (descripcion != null && !descripcion.isBlank()) && (dificultadNombre != null && !dificultadNombre.isBlank())){

            Dificultad dificultad = registrarDificultad(dificultadChoice.getValue());
            if(dificultad != null){

                if(!(App.getClub().buscarDeportePorNombre(nombre.toLowerCase()).isPresent())){
                    App.getClub().agregarDeporte(new Deporte(nombre.toLowerCase(), descripcion, dificultad));
                    validarCondicion(nombre);
                    nombretxt.setText(""); descripciontxt.setText(""); dificultadChoice.setValue("");
                }else{
                JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroDeporteExistente"));
                Utilidades.getInstancia().escribirLog(Level.WARNING, "Error deporte existente");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroDatosNulos"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error datos nulos");
        }

    }

	private void validarCondicion(String nombre) throws IOException {
        if(App.getClub().buscarDeportePorNombre(nombre).isPresent()){
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroSatisfactorio"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Deporte registrado");
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorEnElRegistro"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Incapaz de registrar deporte");
        }
	}

	@FXML
    void volverAPrincipal(ActionEvent event) throws IOException {
        Utilidades.getInstancia().escribirLog(Level.INFO, "Volviendo a principal...");
        App.setRoot("principal");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a principal");
    }

    private Dificultad registrarDificultad(String txt) throws IOException{
        
        Dificultad dificultad = null;

        if(txt != null){

            switch (txt){
                case "ALTA":
                    dificultad = Dificultad.ALTO;
                    break;
                case "HIGH":
                    dificultad = Dificultad.ALTO;
                    break;
                case "MEDIA":
                    dificultad = Dificultad.MEDIO;
                    break;
                case "MEDIUM":
                    dificultad = Dificultad.MEDIO;
                    break;
                case "BAJA":
                    dificultad = Dificultad.BAJO;
                    break;
                case "LOW":
                    dificultad = Dificultad.BAJO;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorInesperado"));
                    Utilidades.getInstancia().escribirLog(Level.SEVERE, "Incapaz de obtener la dificultad");
            }
        }
        
        return dificultad;
	}
}