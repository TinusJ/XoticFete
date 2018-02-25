package za.co.crosstek.ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.crosstek.core.AbstractFacade;
import za.co.crosstek.entity.FavoriteEvent;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class FavoriteEventFacade extends AbstractFacade<FavoriteEvent> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public FavoriteEventFacade() {
        super(FavoriteEvent.class);
    }

}
