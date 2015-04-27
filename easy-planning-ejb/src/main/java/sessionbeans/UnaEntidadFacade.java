/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.UnaEntidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alonso
 */
@Stateless
public class UnaEntidadFacade extends AbstractFacade<UnaEntidad> implements UnaEntidadFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_easy-planning-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnaEntidadFacade() {
        super(UnaEntidad.class);
    }
    
}