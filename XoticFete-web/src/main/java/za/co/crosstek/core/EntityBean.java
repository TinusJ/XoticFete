package za.co.crosstek.core;

import java.io.Serializable;
import javax.ejb.EJB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.entity.CoreEntity;

/**
 *
 * @author Tinus
 */
public abstract class EntityBean<T extends CoreEntity> implements Serializable {

    protected static final Logger LOG = LoggerFactory.getLogger(EntityBean.class);

    @EJB
    protected CoreReflector coreReflector;

    @EJB
    protected ListRenderer listRenderer;

    protected Class<T> entityClazz;
    private T selected;

    public String getIcon() {
        String icon = null;

        try {
            icon = "fa-fw " + entityClazz.getAnnotation(EntityAnotation.class).icon();
        } catch (Exception e) {
            LOG.error("Could not get icon for class : " + entityClazz, e);
        }

        return icon;
    }

    public String getLabel() {
        String label = null;

        try {
            label = entityClazz.getAnnotation(EntityAnotation.class).label();
        } catch (Exception e) {
            LOG.error("Could not get label for class : " + entityClazz, e);
        }

        return label;
    }

    public Class<T> getEntityClazz() {
        return entityClazz;
    }

    public void setEntityClazz(Class<T> entityClazz) {
        this.entityClazz = entityClazz;
    }

    public T getSelected() {
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

}
