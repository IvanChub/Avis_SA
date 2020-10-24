package Controlador;

import com.sun.scenario.effect.impl.Renderer;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

public class AVISGuatemala extends Application {

    private double xOffset = 0;
    private double yOffset = 0;
    
    @Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AVISGuatemala.class.getResource("/Vista/VistaMenu.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();

            // Cargo el scene
            Scene scene = new Scene(ventana);
            
            /*primaryStage.initStyle(StageStyle.DECORATED.UNDECORATED);
            
            ventana.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            
            ventana.setOnMouseDragged(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            });*/
            
            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}