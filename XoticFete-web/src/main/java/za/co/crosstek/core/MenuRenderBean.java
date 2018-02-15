package za.co.crosstek.core;

import java.io.Serializable;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
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
    private CoreReflector coreReflector;
    
    @Inject
    private NavigationBean navigationBean;
    
    private MenuModel menuModel;
    
    @PostConstruct
    public void init() {
        menuModel = new DefaultMenuModel();
        Set<Class<?>> menuClasses = coreReflector.getMenuItems();
        
        DefaultMenuItem dashboardItem = new DefaultMenuItem("Dashboard");
        dashboardItem.setIcon("fa fa-home");
        dashboardItem.setUrl("/dashboard");
        menuModel.addElement(dashboardItem);
        
        if (menuClasses != null && !menuClasses.isEmpty()) {
            
            menuClasses.stream().forEachOrdered((c) -> {
                DefaultMenuItem item = new DefaultMenuItem(c.getAnnotation(EntityAnotation.class).label());
                item.setIcon(c.getAnnotation(EntityAnotation.class).icon());
                item.setUrl("/components/" + navigationBean.navigateToList(c) + "?e=" + c.getSimpleName());
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
