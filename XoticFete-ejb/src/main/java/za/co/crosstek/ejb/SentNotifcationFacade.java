package za.co.crosstek.ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.crosstek.core.AbstractFacade;
import za.co.crosstek.entity.Event;
import za.co.crosstek.entity.SentNotification;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class SentNotifcationFacade extends AbstractFacade<SentNotification> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public SentNotifcationFacade() {
        super(SentNotification.class);
    }

}
