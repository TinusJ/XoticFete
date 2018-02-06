package za.co.crosstek.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.crosstek.anot.CoreAttribute;
import za.co.crosstek.anot.EntityAnotation;

/**
 *
 * @author Tinus
 */
@Stateless
public class DynamicFacade implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(DynamicFacade.class);
    private Reflections reflections;
    private Set<Class<?>> coreEntities;

    public Set<Class<?>> getCoreEntities() {

        if (coreEntities == null) {
            reflections = new Reflections("za.co.crosstek.entity");
            coreEntities = reflections.getTypesAnnotatedWith(EntityAnotation.class);
        }

        return coreEntities;
    }

    public Set<Class<?>> getRestEntities() {
        return null;
    }

    public Set<Class<?>> getGlobalEntities() {
        return null;
    }

    public Set<Class<?>> getMenuItems() {
        Set<Class<?>> menuList = new HashSet<>();

        try {

            getCoreEntities().forEach((c) -> {
                if (Arrays.asList(c.getAnnotation(EntityAnotation.class).attributes()).contains(CoreAttribute.SHOW_ON_MENU)) {
                    menuList.add(c);
                }
            });
        } catch (Exception e) {
            LOG.error("Could not get menu items", e);
        }
        return menuList;
    }

}
