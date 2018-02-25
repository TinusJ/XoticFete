package za.co.crosstek.ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.crosstek.core.AbstractFacade;
import za.co.crosstek.entity.TopUpItem;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class TopUpItemFacade extends AbstractFacade<TopUpItem> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public TopUpItemFacade() {
        super(TopUpItem.class);
    }

}
