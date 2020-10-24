/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.ConexionBD;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author alber
 */
public class VistaLoginControlador implements Initializable {

    @FXML
    private javafx.scene.control.TextField txtUsuario;
    @FXML
    private PasswordField txtClave;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCerrar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void cerrar(){
        System.exit(0);
    }
    
    @FXML
    private void logUsuario(){
        try {
            if((txtUsuario.getText().equals("") && (txtClave.getText().equals(""))) || (txtUsuario.getText().equals("") || txtClave.getText().equals(""))){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Verifique campos vacíos.");
                alert.showAndWait();
                return;
            }
            
            
            String usuario = txtUsuario.getText();
            String clave = txtClave.getText();
            
            ConexionBD.Iniciar();
            int cod_colaborador = ConexionBD.obtenerCodColaborador(usuario, clave);
            if(cod_colaborador == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Credenciales incorrectas.");
                alert.showAndWait();
                return;
            }
            int cod_rol = ConexionBD.obtenerCodRol(cod_colaborador);
            String tipo_rol = ConexionBD.obtenerRol(cod_rol);
            ConexionBD.Finalizar();
            
            if(tipo_rol.equals("Administrador")){
                JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
            }else if(tipo_rol.equals("Colaborador")){
                JOptionPane.showMessageDialog(null, "Bienvenido Colaborador");
            }            
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Hubo un error en la conexión: " + e);
            alert.showAndWait();
            return;
        }
    }
    
}
