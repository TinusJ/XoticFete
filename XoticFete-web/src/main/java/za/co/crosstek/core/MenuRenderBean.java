package za.co.crosstek.core;

import java.io.Serializable;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.crosstek.anot.EntityAnotation;

/**
 *
 * @author Tinus
 */
@SessionScoped
@Named
public class MenuRenderBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(MenuRenderBean.class);

    @EJB
    private DynamicFacade dynamicFacade;

    private MenuModel menuModel;

    @PostConstruct
    public void init() {
        menuModel = new DefaultMenuModel();
        Set<Class<?>> menuClasses = dynamicFacade.getMenuItems();

        if (menuClasses != null && !menuClasses.isEmpty()) {

            menuClasses.forEach((c) -> {
                DefaultMenuItem item = new DefaultMenuItem(c.getAnnotation(EntityAnotation.class).label());
                item.setIcon(c.getAnnotation(EntityAnotation.class).icon());
                item.setUrl("/list?" + c.getAnnotation(EntityAnotation.class).label().toLowerCase());
                item.setTitle(c.getAnnotation(EntityAnotation.class).description());
                menuModel.addElement(item);
            });

        }
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

}
