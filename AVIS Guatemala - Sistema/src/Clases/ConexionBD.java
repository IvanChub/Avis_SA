/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class ConexionBD {
    
    //--------------------------------------------CONEXIÓN-----------------------------------------------------------------
    public static Connection con;
    
    public static Connection getVarCon(){
        return con;
    }
    
    public static void Iniciar(){
        //1. probamos hacer la conexion
        try{
            //2.Cargamos el driver de conexion a BD
            Class.forName("com.mysql.jdbc.Driver");
            
            //3.Creamos la conexion a la BD(ruta/nombrebd, username, password)
            //con = DriverManager.getConnection("jdbc:mysql://localhost/bdcajero", "root", "");
            con = DriverManager.getConnection("jdbc:mysql://localhost/avis", "root", "");
            
        }catch (ClassNotFoundException | SQLException ex){
            //4. si no funciona la conexion nos mostrar un mensaje diciendo que hubo un error
            JOptionPane.showMessageDialog(null, "Hubo un problema con la conexión a la Base de Datos: " + ex);
        }
        
    }
    
    public static void Finalizar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    //--------------------------------------------CONEXIÓN-----------------------------------------------------------------
    
    
    
    
    
    
    
    
    //--------------------------------------------USUARIO-----------------------------------------------------------------
    
     /*PARA LOGGEAR ADMINISTRADOR O CAJERO*/    
    public static int obtenerCodColaborador(String usuario, String  clave){
        
        try{
            
            //indicamos la consulta a utilizar
            String sql="SELECT cod_colaborador FROM tb_usuario_sistema WHERE usuario = ? AND pswd = ?";
            
            /*El Statement es el interpretador de consultas e instrucciones SQL
              Y el PreparedStatemen permite indicar que parametros se van a usar 
              en la consulta SQL antes de interpretarla, o sea, "prepara la consulta
              para el interpretador de consultas >Statement<" */
            PreparedStatement ConsultaSQL = con.prepareStatement(sql);
            
            //indicamos cual es el parametro a usar
            ConsultaSQL.setString(1, usuario);
            ConsultaSQL.setString(2, clave);
            
            //obtenemos la estructura de la tabla que devuelve la consulta sql
            ResultSet estructuraTabla = ConsultaSQL.executeQuery();
            
            //si la funcion next() logra obtener un valor
            if(estructuraTabla.next()){
                int cod_colaborador = estructuraTabla.getInt("cod_colaborador");
                return cod_colaborador;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha surgido un error: " + ex);
            return 0;
        }
    
    }
    
     /*PARA LOGGEAR ADMINISTRADOR O CAJERO*/    
    public static int obtenerCodRol(int cod_colaborador){
        
        try{
            
            //indicamos la consulta a utilizar
            String sql="SELECT cod_rol FROM tb_colaborador WHERE cod_colaborador=?";
            
            /*El Statement es el interpretador de consultas e instrucciones SQL
              Y el PreparedStatemen permite indicar que parametros se van a usar 
              en la consulta SQL antes de interpretarla, o sea, "prepara la consulta
              para el interpretador de consultas >Statement<" */
            PreparedStatement ConsultaSQL = con.prepareStatement(sql);
            
            //indicamos cual es el parametro a usar
            ConsultaSQL.setInt(1, cod_colaborador);
            
            //obtenemos la estructura de la tabla que devuelve la consulta sql
            ResultSet estructuraTabla = ConsultaSQL.executeQuery();
            
            //si la funcion next() logra obtener un valor
            if(estructuraTabla.next()){
                int cod_rol = estructuraTabla.getInt("cod_rol");
                return cod_rol;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha surgido un error: " + ex);
            return 0;
        }
    
    }
    
     public static String obtenerRol(int cod_rol){
        
        try{
            
            //indicamos la consulta a utilizar
            String sql="SELECT tipo_rol FROM tb_rol WHERE cod_rol=?";
            
            /*El Statement es el interpretador de consultas e instrucciones SQL
              Y el PreparedStatemen permite indicar que parametros se van a usar 
              en la consulta SQL antes de interpretarla, o sea, "prepara la consulta
              para el interpretador de consultas >Statement<" */
            PreparedStatement ConsultaSQL = con.prepareStatement(sql);
            
            //indicamos cual es el parametro a usar
            ConsultaSQL.setInt(1, cod_rol);
            
            //obtenemos la estructura de la tabla que devuelve la consulta sql
            ResultSet estructuraTabla = ConsultaSQL.executeQuery();
            
            //si la funcion next() logra obtener un valor
            if(estructuraTabla.next()){
                String tipo_rol = estructuraTabla.getString("tipo_rol");
                return tipo_rol;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha surgido un error: " + ex);
            return null;
        }
    
    }
     
     
    //--------------------------------------------USUARIO-----------------------------------------------------------------
}
