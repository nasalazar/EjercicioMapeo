/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entity.Usuario;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author NATHALY
 */
@ManagedBean(name="controlA")
@ViewScoped
public class ControladorSeguridadAdmin {

    /**
     * Constructor
     */
    public ControladorSeguridadAdmin() {
         
    }
    /**
     * Valida la sesion activa
     */
    public void sesionAdministrador(){
        try{
            
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("administrador");
           
            if(user == null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
        }catch(IOException ex){
            
        }
    }
}