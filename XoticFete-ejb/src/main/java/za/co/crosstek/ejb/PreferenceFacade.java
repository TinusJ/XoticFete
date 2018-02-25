package za.co.crosstek.ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.crosstek.core.AbstractFacade;
import za.co.crosstek.entity.Preference;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class PreferenceFacade extends AbstractFacade<Preference> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public PreferenceFacade() {
        super(Preference.class);
    }

}
