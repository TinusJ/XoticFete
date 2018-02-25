package za.co.crosstek.ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.crosstek.core.AbstractFacade;
import za.co.crosstek.entity.SentEmail;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class SentEmailFacade extends AbstractFacade<SentEmail> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public SentEmailFacade() {
        super(SentEmail.class);
    }

}
