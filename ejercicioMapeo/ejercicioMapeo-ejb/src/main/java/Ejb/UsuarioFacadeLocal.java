/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NATHALY
 */
@Local
public interface UsuarioFacadeLocal {
    /**
     * Metodo crear por defecto
     * @param usuario 
     */
    void create(Usuario usuario);
    /**
     * Metodo editar por defecto
     * @param usuario 
     */
    void edit(Usuario usuario);
    /**
     * Metodo eliminar por defecto
     * @param usuario 
     */
    void remove(Usuario usuario);
    /**
     * Metodo buscar por defecto
     * @param id
     * @return 
     */
    Usuario find(Object id);

    List<Usuario> findAll();
    /**
     * Metodo busqueda entre rangos por defecto
     * @param range
     * @return 
     */
    List<Usuario> findRange(int[] range);
    /**
     * Metodo que cuenta
     * @return 
     */
    int count();
    /**
     * Metodo EJB para iniciar sesion
     * @param user
     * @return 
     */
    Usuario inicioSesion(Usuario user);
    
    
}
