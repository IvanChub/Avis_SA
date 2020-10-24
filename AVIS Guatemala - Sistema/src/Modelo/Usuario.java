/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alber
 */
public class Usuario {
    private String usuario;
    private String clave;
    private int cod_colaborador;

    public Usuario(String usuario, String clave, int cod_colaborador) {
        this.usuario = usuario;
        this.clave = clave;
        this.cod_colaborador = cod_colaborador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCod_colaborador() {
        return cod_colaborador;
    }

    public void setCod_colaborador(int cod_colaborador) {
        this.cod_colaborador = cod_colaborador;
    }
    
    
}
