/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author alber
 */
public class VistaMenuControlador implements Initializable {

    @FXML
    private StackPane stakpanel;
    @FXML
    private Button btnHistorialesMedicos;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnUsuario;
    @FXML
    private Pane pnlUsuarios;
    @FXML
    private Pane pnlBeneficiarios;
    @FXML
    private Pane pnlPacientes;
    @FXML
    private Pane pnlBecados;
    @FXML
    private Pane pnlHistorialesMedicos;
    @FXML
    private Button btnBeneficiario;
    @FXML
    private Button btnPacientes;
    @FXML
    private Button btnBecados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML   
    private void cambioPanel(javafx.event.ActionEvent evento) {
        if(evento.getSource() == btnUsuario){
            pnlUsuarios.toFront();
        }else if(evento.getSource() == btnBeneficiario){
            pnlBeneficiarios.toFront();
        }
    }

    @FXML
    private void CerrarSesion(javafx.event.ActionEvent event) {
        System.exit(0);
    }

    
  
}
