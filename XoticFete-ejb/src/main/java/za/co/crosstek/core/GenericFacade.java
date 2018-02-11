package za.co.crosstek.core;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import za.co.crosstek.entity.CoreEntity;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class GenericFacade extends AbstractFacade<CoreEntity> {

    @PersistenceContext(unitName = "XoticPU")
    private EntityManager em;

    public GenericFacade() {
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenericFacade(Class<CoreEntity> entityClass) {
        super(entityClass);
    }

    public AbstractFacade findAbstractFacadeFor(String facadeClassName) {
        AbstractFacade ejbFacade = null;

        if (StringUtils.isNotBlank(facadeClassName)) {
            try {
                Context ctx = new InitialContext();
                String mname = (String) ctx.lookup("java:module/ModuleName");
                String anmae = (String) ctx.lookup("java:app/AppName");

                String lookupPath = "java:global"
                        + "/" + anmae + "/" + mname
                        + "/" + facadeClassName;
                ejbFacade = (AbstractFacade) ctx.lookup(lookupPath);
            } catch (Exception e) {
                LOG.error("Could not initialize converter facade: " + facadeClassName, e);
            }
        }
        return ejbFacade;
    }

}
