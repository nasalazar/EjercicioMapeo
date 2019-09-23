/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author NATHALY
 */
@Entity
@Table(name= "usuario")
public class Usuario implements Serializable {
    /**
     * id de la tabla autoincrementable
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    /**
     * nombre de usuario
     */
    @Column(name="usuario")
    private String usuario;
    /**
     * Constraseña del usuario
     */
    @Column(name="clave")
    private String clave;
    /**
     * Rol del usuario
     */
    @Column(name="rol")
    private String rol;
    /**
     * Constructor
     * @param usuario
     * @param clave
     * @param rol 
     */
    public Usuario(String usuario, String clave, String rol) {
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }
    /**
     * COnstructor
     */
    public Usuario() {
    }
    /**
     * Get del id
     * @return int
     */
    public int getId() {
        return id;
    }
    /**
     * Set del id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Get del nombre de usuario
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Set del usuario
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Get de la contraseña
     * @return String
     */
    public String getClave() {
        return clave;
    }
    /**
     * Set de la contraseña
     * @param clave 
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     * Get del rol
     * @return String
     */
    public String getRol() {
        return rol;
    }
    /**
     * Set del rol
     * @param rol 
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
    
}
