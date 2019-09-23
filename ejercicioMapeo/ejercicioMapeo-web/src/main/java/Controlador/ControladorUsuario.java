/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Ejb.UsuarioFacadeLocal;
import Entity.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import javax.faces.context.FacesContext;


/**
 *
 * @author NATHALY
 */
@ManagedBean(name="control")
@ViewScoped
public class ControladorUsuario implements Serializable {
    /**
     * Llamado al EJB e instancia de la interface
     */
    @EJB
    private UsuarioFacadeLocal  EJBusuario;
    
    
    /**
     * instancia de Usuario EJB
     */
    private Usuario usuario;
    /**
     * Inicializacion de Usuario
     */
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    /**
     * Get de Usuario
     * @return Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * Set de Usuario
     * @param usuario 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     * Metodo que hace la solicitud para iniciar sesion
     * @return String
     */
    public String inicioSesion(){
        Usuario user;
        String redireccion = null;
        try{            
            user =  EJBusuario.inicioSesion(usuario);

            if(user != null ){
                
                if(user.getRol().equals("administrador")){
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("administrador", user);
                    redireccion = "admin";
                    FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
                }else{
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("estudiante", user);
                    redireccion = "usuario";
                    FacesContext.getCurrentInstance().getExternalContext().redirect("estudiante.xhtml");
                }
                
            
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Usuario o clave incorrecta"));
            }
            
        }catch(IOException ex){
          
        }
        return redireccion;
    }
    /**
     * Metodo de prueba para crear un usuario ya definido
     */
    public void crearUsuario(){
        try{
            usuario= new Usuario("123","nathaly","nat");
            EJBusuario.create(usuario);
        }catch(Exception e){
            
        }
    }
    public String iniciar() throws IOException{
        
        List<Usuario> usuariosReg = EJBusuario.findAll();
        for(Usuario u : usuariosReg){
            if(u.getUsuario().equals(usuario.getUsuario()) & u.getClave().equals(usuario.getClave())){
                if(u.getRol().equals("administrador")){
                    usuario.setRol("administrador");
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("administrador", u);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
                }else{
                    usuario.setRol("usuario");
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("estudiante.xhtml");
                }
            }
        }
        return "";
    }
}
