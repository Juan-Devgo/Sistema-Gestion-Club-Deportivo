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
    private Tab serializartab;

    @FXML
    private Button serializarListaEntrenadoresDatbt;

    @FXML
    private Button serializarListaEntrenadoresXmlbt;

    @FXML
    private Button serializarListaMiembrosDatbt;

    @FXML
    private Button serializarListaMiembrosXmlbt;

    @FXML
    private Button serializarListaSesionesDatbt;

    @FXML
    private Button serializarListaSesionesXmlbt;
    
    @FXML
    private Label serializardatlb;

    @FXML
    private Label serializarxmllb;

    @FXML
    private Button serializarclubbt;

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
        serializartab.setText(Utilidades.getInstancia().mostrarMensajeBundle("serializartab"));
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
        serializarListaEntrenadoresDatbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("serializarListaEntrenadoresDatbt"));
        serializarListaMiembrosDatbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("serializarListaMiembrosDatbt"));
        serializarListaSesionesDatbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("serializarListaSesionesDatbt"));
        serializarListaEntrenadoresXmlbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("serializarListaEntrenadoresXmlbt"));
        serializarListaSesionesXmlbt.setText(Utilidades.getInstancia().mostrarMensajeBundle("serializarListaSesionesXmlbt"));
        serializardatlb.setText(Utilidades.getInstancia().mostrarMensajeBundle("serializardatlb"));
        serializarxmllb.setText(Utilidades.getInstancia().mostrarMensajeBundle("serializarxmllb"));
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

    //Métodos para serializar a .Dat

    @FXML
    @SuppressWarnings("unchecked")
    void SerializarListaMiembrosADat(ActionEvent event) throws IOException {
        LinkedList<Miembro> miembros = App.getClub().getMiembros(); 

        try {
            Utilidades.getInstancia().serializarObjetoDat("miembros.dat",miembros);
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeMiembrosSerializadosDat"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Miembros serializados a Dat"); 
            
            LinkedList<Persona> nuevaListaMiembros = (LinkedList<Persona>) Utilidades.getInstancia().deserializarObjetoDat("miembros.dat");
            JOptionPane.showMessageDialog(null, imprimirNombres(nuevaListaMiembros));

            Utilidades.getInstancia().escribirLog(Level.INFO,"Miembros serializadas a Dat impresas");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorMiembrosSerializadosDat")); 
            Utilidades.getInstancia().escribirLog(Level.SEVERE,"Error al intentar serializar los miembros a Dat"); 
        }
    }

    @FXML
    @SuppressWarnings("unchecked")
    void SerializarListaPersonasADat(ActionEvent event) throws IOException{
        
        LinkedList<Persona> personas = new LinkedList<>();
        personas.add(App.getClub().getAdministrador()) ; personas.addAll(App.getClub().getMiembros()); 
        personas.addAll(App.getClub().getEntrenadores());

        try {
            Utilidades.getInstancia().serializarObjetoDat("personas.dat", personas);
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajePersonasSerializadasDat"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Personas serializadas a Dat");

            LinkedList<Persona> nuevaListaPersonas = (LinkedList<Persona>) Utilidades.getInstancia().deserializarObjetoDat("personas.dat");
            JOptionPane.showMessageDialog(null, imprimirNombres(nuevaListaPersonas)); 
            Utilidades.getInstancia().escribirLog(Level.INFO,"Personas serializadas a Dat impresas"); 

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorPersonasSerializadasDat"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Error al intentar serializar las personas a Dat");
        }

    }

    @FXML
    @SuppressWarnings("unchecked")
    void SerializarListaSesionesADat(ActionEvent event) throws IOException{
        
        LinkedList<SesionEntrenamiento> sesiones = App.getClub().getSesionesEntrenamiento();

        try {
            Utilidades.getInstancia().serializarObjetoDat("sesiones.dat", sesiones);
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeSesionesSerializadasDat"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Sesiones serializadas a Dat");

            LinkedList<SesionEntrenamiento> nuevaListaSesiones = (LinkedList<SesionEntrenamiento>) Utilidades.getInstancia().deserializarObjetoDat("sesiones.dat");
            JOptionPane.showMessageDialog(null, imprimirCodigosYDeportes(nuevaListaSesiones));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Sesiones serializadas a Dat impresas");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorSesionesSerializadasDat"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Error al intentar serializar las sesiones a Dat");
        }
        
    }

    //Métodos para serializar a XML

    @FXML
    void SerializarClubDeportivoAXML(ActionEvent event) throws IOException {
        ClubDeportivo club = App.getClub();

        try {
            Utilidades.getInstancia().serializarObjetoXML("clubDeportivo.xml", club);
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeClubSerializadoXML"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Club deportivo serializado a XML");

            ClubDeportivo nuevoClub = (ClubDeportivo) Utilidades.getInstancia().deserializarObjetoXML("clubDeportivo.xml");
            JOptionPane.showMessageDialog(null, nuevoClub.getNombre());
            Utilidades.getInstancia().escribirLog(Level.INFO,"Club deportivo serializado a XML impreso"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorClubSerializadoXML"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Error al intentar serializar el club deportivo a XML");
        }
    }
    
    @FXML
    @SuppressWarnings("unchecked")
    void SerializarListaPersonasAXML(ActionEvent event) throws IOException {
        LinkedList<Persona> personas = new LinkedList<>();
        personas.add(App.getClub().getAdministrador()) ; personas.addAll(App.getClub().getMiembros()); 
        personas.addAll(App.getClub().getEntrenadores());

        try {
            Utilidades.getInstancia().serializarObjetoXML("personas.xml", personas);
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajePersonasSerializadasXML"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Personas serializadas a XML");

            LinkedList<Persona> nuevaListaPersonas = (LinkedList<Persona>) Utilidades.getInstancia().deserializarObjetoXML("personas.xml");
            JOptionPane.showMessageDialog(null, imprimirNombres(nuevaListaPersonas));
            Utilidades.getInstancia().escribirLog(Level.INFO,"Personas serializadas a XML impresas"); 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorPersonasSerializadasXML"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Error al intentar serializar las personas a XML");
        }

    }

    @FXML
    @SuppressWarnings("unchecked")
    void SerializarListaSesionesAXML(ActionEvent event) throws IOException {
      LinkedList<SesionEntrenamiento> sesiones = App.getClub().getSesionesEntrenamiento();

        try {
            Utilidades.getInstancia().serializarObjetoXML(null, sesiones);
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeSesionesSerializadasXML"));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Sesiones serializadas a XML");

            LinkedList<SesionEntrenamiento> nuevaListaSesiones = (LinkedList<SesionEntrenamiento>) Utilidades.getInstancia().deserializarObjetoXML("sesiones.xml");
            JOptionPane.showMessageDialog(null, imprimirCodigosYDeportes(nuevaListaSesiones));
            Utilidades.getInstancia().escribirLog(Level.INFO, "Sesiones serializadas a XML impresas");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Utilidades.getInstancia().mostrarMensajeBundle("MensajeErrorSesionesSerializadasXML"));
            Utilidades.getInstancia().escribirLog(Level.SEVERE, "Error al intentar serializar las sesiones a XML");
        }
    }

    private LinkedList<String> imprimirNombres(LinkedList<Persona> nuevaListaPersonas) {
        LinkedList<String> nombres = new LinkedList<>();
        for (Persona persona : nuevaListaPersonas) {
            nombres.add(persona.getNombre());
        }
        return nombres;
    }

    private LinkedList<String> imprimirCodigosYDeportes(LinkedList<SesionEntrenamiento> sesiones) {
        LinkedList<String> codigosYDeportes = new LinkedList<>();
        for (SesionEntrenamiento sesion : sesiones) {
            codigosYDeportes.add(sesion.getCodigo() + ": " + sesion.getDeporte().getNombre());
        }
        return codigosYDeportes;
    }
}