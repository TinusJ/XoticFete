package za.co.crosstek.ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.crosstek.core.AbstractFacade;
import za.co.crosstek.entity.GeoLocation;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class GeoLocationFacade extends AbstractFacade<GeoLocation> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public GeoLocationFacade() {
        super(GeoLocation.class);
    }

}
