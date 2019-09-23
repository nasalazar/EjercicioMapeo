/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NATHALY
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;
    /**
     * Instancia del entity manager
     * @return 
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /**
     * Constructor
     */
    public UsuarioFacade() {
        super(Usuario.class);
    }
    /**
     * Metodo mapeado que se va a comunicar contra la base de datos y hacer JPQL
     * @param user
     * @return 
     */
    @Override
    public Usuario inicioSesion(Usuario user){
        
        Usuario usuario = null;
        String consulta;
        try{
            consulta = "FROM Usuario u WHERE u.usuario = ?2 and u.clave = ?3";
            //EL ERROR ESTA AQUI
            Query query = em.createQuery(consulta);
            query.setParameter(2,user.getUsuario());
            query.setParameter(3,user.getClave());
            //ERROR CAPTURADO
            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
                return usuario;
            }
        }catch(Exception e){
         throw e;   
        }
        return usuario;
    }
}
