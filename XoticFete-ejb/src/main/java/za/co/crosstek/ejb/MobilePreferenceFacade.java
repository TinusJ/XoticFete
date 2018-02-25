package za.co.crosstek.ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.crosstek.core.AbstractFacade;
import za.co.crosstek.entity.Event;
import za.co.crosstek.entity.MobilePreference;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class MobilePreferenceFacade extends AbstractFacade<MobilePreference> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public MobilePreferenceFacade() {
        super(MobilePreference.class);
    }

}
