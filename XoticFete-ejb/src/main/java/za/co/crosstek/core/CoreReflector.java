package za.co.crosstek.core;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Named;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.crosstek.enums.EntityAttribute;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.FieldExclusion;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class CoreReflector {

    private static final Logger LOG = LoggerFactory.getLogger(CoreReflector.class);
    private static final String entityPackage = "za.co.crosstek.entity";

    private Reflections reflections;
    private Set<Class<?>> coreEntities;

    public Set<Class<?>> getCoreEntities() {

        if (coreEntities == null) {
            reflections = new Reflections(entityPackage);
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
                if (Arrays.asList(c.getAnnotation(EntityAnotation.class).attributes()).contains(EntityAttribute.SHOW_ON_MENU)) {
                    menuList.add(c);
                }
            });
        } catch (Exception e) {
            LOG.error("Could not get menu items", e);
        }
        return menuList;
    }

    public static String getEntityPackage() {
        return entityPackage;
    }

    public Set<Field> getFieldsForType(Class<?> clazz, FieldExclusion exclusion) {
        Set<Field> fieldSet = new HashSet<>();

        try {
            List<Field> fieldList = FieldUtils.getFieldsListWithAnnotation(clazz, FieldAnotation.class);

            if (fieldList != null) {

                for (Field field : fieldList) {
                    FieldAnotation anot = field.getAnnotation(FieldAnotation.class);

                    if (!Arrays.asList(anot.exclusions()).contains(exclusion)) {
                        fieldSet.add(field);
                    }
                }
            }

        } catch (Exception e) {
            LOG.error("Could not get the fields", e);
        }

        return fieldSet;
    }

}
