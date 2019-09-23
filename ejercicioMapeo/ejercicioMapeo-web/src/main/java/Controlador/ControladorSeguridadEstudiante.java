/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entity.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author NATHALY
 */
@ManagedBean(name = "seguridadE")
@ViewScoped
public class ControladorSeguridadEstudiante {

    /**
     * Constructor
     */
    public ControladorSeguridadEstudiante() {
    }
    /**
     * Valida la sesion activa
     */
    public void sesionEstudiante(){
        try{
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
            if(user == null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
        }catch(IOException ex){
            
        }
    }
}
