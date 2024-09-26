package co.edu.uniquindio.laboratorio1;

import co.edu.uniquindio.laboratorio1.Model.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static ClubDeportivo club;
    private static Locale idioma;
    private static FileHandler archivo;
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

	@Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 650, 465);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static ClubDeportivo getClub(){
        return club;
    }

    public static Locale getIdioma(){
        return idioma;
    }

    @SuppressWarnings("exports")
    public static FileHandler getArchivo(){
        return archivo;
    }

    public static void setIdioma(Locale idioma) {
        App.idioma = idioma;
    }

    public static void main(String[] args) throws IOException {
        club = new ClubDeportivo("Club Penguin");
        idioma = new Locale("es", "CO");
        archivo = new FileHandler("MyLog.txt", true);
        archivo.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(archivo);
        launch(args);
        // Administrador admin = new Administrador( null , "1029384756");
        // Entrenador entrenador1 = new Entrenador("Damián", "1098765412");
        // Entrenador entrenador2 = new Entrenador("Carolina", "1234567809");
        // Deporte basquetbol = new Deporte("basquetbol", "abc", Dificultad.MEDIO);
        // Deporte ajedrez = new Deporte("Ajedrez", "El deporte más atlético de los juegos olímpicos según Guiness", Dificultad.ALTO);
        // Miembro miembro1 = new Miembro("Santiago Lopez", "12345", "santilopez12@gmail.com", TipoMiembro.JOVEN, basquetbol);
        // Miembro miembro2 = new Miembro("Hanna Montana","007666","HannaP@yahoo.com",TipoMiembro.ADULTO, ajedrez);
        // SesionEntrenamiento sesion1 = new SesionEntrenamiento("123", LocalDateTime.of(LocalDate.of(2024, 9, 01), LocalTime.of(8, 0)), Duration.ofMinutes(120), entrenador1, basquetbol);
        // SesionEntrenamiento sesion2 = new SesionEntrenamiento("321", LocalDateTime.of(LocalDate.of(2024, 9, 01), LocalTime.of(10, 30)), Duration.ofMinutes(120), entrenador1, basquetbol);

        
        // club.agregarMiembro(miembro1); club.agregarMiembro(miembro2);
        // club.agregarDeporte(ajedrez); club.agregarDeporte(basquetbol);
        // club.agregarEntrenador(entrenador1); club.agregarEntrenador(entrenador2);
        // club.asignarEntrenadorADeporte(entrenador1, basquetbol); club.asignarEntrenadorADeporte(entrenador2, ajedrez);
        
        // club.agregarSesionEntrenamiento(sesion1); club.agregarSesionEntrenamiento(sesion2);
        // club.asignarMiembroASesion(miembro1, sesion1); club.asignarMiembroASesion(miembro1, sesion2);
    }

}