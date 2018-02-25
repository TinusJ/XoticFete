package za.co.crosstek.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.FieldExclusion;
import za.co.crosstek.model.ColumnModel;

/**
 *
 * @author Tinus
 */
@Stateless
@Named
public class ListRenderer {

    private static final Logger LOG = LoggerFactory.getLogger(ListRenderer.class);

    @EJB
    private GenericFacade genericFacade;

    @EJB
    private CoreReflector coreReflector;

    private Class<?> clazz;
    private List<?> list;

    public ListRenderer() {
    }

    public ListRenderer(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public List<?> getList() {

        if (list == null) {
            list = buildList();
        }

        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    private List<?> buildList() {
        List<?> ret = null;

        try {

            if (clazz != null) {
                ret = genericFacade.findFacade(clazz.getSimpleName() + "Facade").findAll();
            }
        } catch (Exception e) {
            LOG.error("Could not build list for clazz", e);
        }

        return ret;
    }

    public List<ColumnModel> buildColumns() {
        List<ColumnModel> columns = new ArrayList<>();

        try {
            Set<Field> fields = coreReflector.getFieldsForType(clazz, FieldExclusion.LIST);

            for (Field field : fields) {
                columns.add(new ColumnModel(field.getAnnotation(FieldAnotation.class).label(), field.getName(), field.getAnnotation(FieldAnotation.class).type()));
            }
        } catch (Exception e) {
            LOG.error("Could not build columns", e);
        }

        return columns;
    }

}
