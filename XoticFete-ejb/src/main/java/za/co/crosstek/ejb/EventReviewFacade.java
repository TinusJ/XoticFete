package za.co.crosstek.ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.crosstek.core.AbstractFacade;
import za.co.crosstek.entity.Event;
import za.co.crosstek.entity.EventReview;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class EventReviewFacade extends AbstractFacade<EventReview> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public EventReviewFacade() {
        super(EventReview.class);
    }

}
