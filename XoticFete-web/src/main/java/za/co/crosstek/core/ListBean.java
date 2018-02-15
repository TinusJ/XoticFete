package za.co.crosstek.core;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.crosstek.model.ColumnModel;

/**
 *
 * @author Tinus
 */
@Named
@ViewScoped
public class ListBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(ListBean.class);

    @EJB
    private CoreReflector coreReflector;

    @EJB
    private ListRenderer listRenderer;

    private String e;
    private Class<?> c;
    private List<?> list;
    private List<ColumnModel> columns;
    private List<?> filteredList;

    public void init() {

        if (StringUtils.isNotBlank(e)) {

            try {
                c = Class.forName(coreReflector.getEntityPackage() + "." + e);
                listRenderer.setClazz(c);
            } catch (Exception e) {
                LOG.error("Could not find class ", e);
            }
        }

    }

    public Class<?> getC() {

        if (c == null && e != null) {
            try {
                c = Class.forName(coreReflector.getEntityPackage() + "." + e);
            } catch (Exception e) {
                LOG.error("Could not find class ", e);
            }
        }
        return c;
    }

    public void setC(Class<?> c) {

        if (c != null) {
            this.c = c;
        }
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public List<?> getList() {

        if (list == null) {

            if (c != null) {
                list = listRenderer.getList();
            }
        }

        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public List<ColumnModel> getColumns() {

        if (c != null && columns == null) {
            columns = listRenderer.buildColumns();
        }
        return columns;
    }

    public void setColumns(List<ColumnModel> columns) {
        this.columns = columns;
    }

    public List<?> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<?> filteredList) {
        this.filteredList = filteredList;
    }

}
