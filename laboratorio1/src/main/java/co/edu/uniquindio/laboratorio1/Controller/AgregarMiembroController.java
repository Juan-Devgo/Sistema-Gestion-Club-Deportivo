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
import javafx.scene.control.TextField;

public class AgregarMiembroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> TipoMiembroChoice;

    @FXML
    private Button aceptarBt;

    @FXML
    private TextField correotxt;

    @FXML
    private TextField deportetxt;

    @FXML
    private TextField identificaciontxt;

    @FXML
    private TextField nombretxt;

    @FXML
    private Label titulolb;

    @FXML
    private Label tipoMiembrolb;

    @FXML
    private Button volverbt;

    @FXML
    void initialize() throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Inicializando AgregarMiembroController...");
        Utilidades.getInstancia().EstablecerRutaBundle("resources/miembro");
        String[] tipoMiembro = {Utilidades.getInstancia().mostrarMensajeBundle("tipoMiembroJoven"), 
                                Utilidades.getInstancia().mostrarMensajeBundle("tipoMiembroAdulto")};
        TipoMiembroChoice.getItems().addAll(tipoMiembro);
        titulolb.setText(Utilidades.getInstancia().mostrarMensajeBundle("titulolb"));
        nombretxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptNombre"));
        identificaciontxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptIdentificacion"));
        correotxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptCorreo"));
        deportetxt.setPromptText(Utilidades.getInstancia().mostrarMensajeBundle("promptDeporte"));
        aceptarBt.setText(Utilidades.getInstancia().mostrarMensajeBundle("aceptarbt"));
        tipoMiembrolb.setText(Utilidades.getInstancia().mostrarMensajeBundle("tipoMiembrolb"));
        volverbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("volverbt"));
        Utilidades.getInstancia().escribirLog(Level.INFO, "AgregarMiembroController inicializado");
    }
    @FXML
    void volverAPrincipal(ActionEvent event) throws IOException{
        Utilidades.getInstancia().escribirLog(Level.INFO, "Volviendo a principal...");
        App.setRoot("principal");
        Utilidades.getInstancia().escribirLog(Level.INFO, "Escena cambiada a principal");
    }
    
    @FXML
    void registrarMiembro(ActionEvent event) throws IOException{
        String nombre = nombretxt.getText();
        String identificacion = identificaciontxt.getText();
        String correo = correotxt.getText();
        String deporteNombre = deportetxt.getText();
        String tipoMiembroNombre = TipoMiembroChoice.getValue();
        
        if((deporteNombre != null && !deporteNombre.isBlank()) && (tipoMiembroNombre != null && !tipoMiembroNombre.isBlank()) && 
        (nombre != null && !nombre.isBlank()) && (identificacion != null && !identificacion.isBlank()) && (correo != null && !correo.isBlank())){

            Deporte deporte = registrarDeporte(deporteNombre);
            TipoMiembro tipoMiembro = registrarTipoMiembro(tipoMiembroNombre);

            if((deporte != null) && (tipoMiembro != null)){

                if(!(App.getClub().buscarMiembroPorNombre(nombre).isPresent())){

                    if((tipoMiembro == TipoMiembro.JOVEN) && (deporte.getDificultad() == Dificultad.ALTO)){
                        JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorTipoMiembro"));
                        Utilidades.getInstancia().escribirLog(Level.WARNING, "Error tipo miembro jóven en deporte con dificultad alta");
                    }else{
                        App.getClub().agregarMiembro(new Miembro(nombre.toLowerCase(), identificacion, correo, tipoMiembro, deporte)); 
                        validarRegistro(nombre); 
                        nombretxt.setText(""); identificaciontxt.setText(""); correotxt.setText(""); deportetxt.setText("");
                    } 
        
                }else{
                    JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroMiembroExistente"));
                    Utilidades.getInstancia().escribirLog(Level.WARNING, "Error miembro existente");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroDatosNulos"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error datos nulos");
        }
    }

    private void validarRegistro(String nombre) throws IOException{
        if(App.getClub().buscarPersonaPorNombre(nombre).isPresent()){
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeRegistroSatisfactorio"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Miembro registrado");
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorEnElRegistro"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Incapaz de registrar miembro");
        }
	}

     private TipoMiembro registrarTipoMiembro(String tipo) throws IOException{

        TipoMiembro tipoMiembro = null;


        switch (tipo){
        case "JOVEN":
            tipoMiembro = TipoMiembro.JOVEN;
            break;
        case "TEEN":
            tipoMiembro = TipoMiembro.JOVEN;
            break;
        case "ADULTO":
            tipoMiembro = TipoMiembro.ADULTO;
            break;
        case "ADULT":
            tipoMiembro = TipoMiembro.ADULTO;
            break;
        default:
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorInesperado"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Incapaz de registrar miembro");
        }

        return tipoMiembro;
    }

    private Deporte registrarDeporte(String nombre) throws IOException{
        
        Deporte deporte = null; var resultadoBusqueda = App.getClub().buscarDeportePorNombre(deportetxt.getText());
        
        if(resultadoBusqueda.isPresent()){
            deporte = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeDeporteNulo"));
            Utilidades.getInstancia().escribirLog(Level.WARNING, "Error deporte no encontrado");
        }

        return deporte;
    }
}



       

