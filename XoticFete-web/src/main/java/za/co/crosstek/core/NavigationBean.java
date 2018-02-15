package za.co.crosstek.core;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.crosstek.anot.EntityAnotation;

/**
 *
 * @author Tinus
 */
@SessionScoped
@Named
public class NavigationBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(NavigationBean.class);

    @EJB
    private CoreReflector reflector;

    public String navigateToForm(Class<?> pClazz) {
        String destiniation = "";
        EntityAnotation eAnot = pClazz.getAnnotation(EntityAnotation.class);

        if (eAnot != null) {
            destiniation = eAnot.url().form();
        }

        return destiniation;
    }

    public String navigateToList(Class<?> pClazz) {
        String destiniation = "";
        EntityAnotation eAnot = pClazz.getAnnotation(EntityAnotation.class);

        if (eAnot != null) {
            destiniation = eAnot.url().list();
        }

        return destiniation;
    }

    public String navigateToView(Class<?> pClazz) {
        String destiniation = "";
        EntityAnotation eAnot = pClazz.getAnnotation(EntityAnotation.class);

        if (eAnot != null) {
            destiniation = eAnot.url().view();
        }

        return destiniation;
    }

    public String navigateToForm(String pEntity) {
        String destiniation = "";

        try {
            Class clazz = Class.forName(reflector.getEntityPackage() + pEntity);
            destiniation = navigateToForm(clazz);
        } catch (ClassNotFoundException ex) {
            LOG.error("No Clazz found " + pEntity, ex);
        }

        return destiniation;
    }

    public String navigateToList(String pEntity) {
        String destiniation = "";

        try {
            Class clazz = Class.forName(reflector.getEntityPackage() + pEntity);
            destiniation = navigateToList(clazz);
        } catch (ClassNotFoundException ex) {
            LOG.error("No Clazz found " + pEntity, ex);
        }

        return destiniation;
    }

    public String navigateToView(String pEntity) {
        String destiniation = "";

        try {
            Class clazz = Class.forName(reflector.getEntityPackage() + pEntity);
            destiniation = navigateToView(clazz);
        } catch (ClassNotFoundException ex) {
            LOG.error("No Clazz found " + pEntity, ex);
        }

        return destiniation;
    }

    /**
     * Return the current path of the application.
     *
     * @param includeProjectPath
     * @return
     */
    public String getRootURL() {
        String url = null;
        try {
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String websiteURL = req.getRequestURL().toString();
            String requestURI = req.getRequestURI();
            String root = websiteURL.substring(0, websiteURL.indexOf(requestURI));
            String context = req.getContextPath();

            url = root + (!StringUtils.isEmpty(context) && requestURI.contains(context) ? context : "");

        } catch (Exception e) {
            LOG.error("Could not get root URL", e);
        }

        return url;
    }

    /**
     * Navigate user to page .
     *
     * @param destination
     */
    public void navigate(String destination) {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(destination);
            context.responseComplete();
        } catch (IOException e) {
            LOG.error("Could not redirect " + destination, e);
        }
    }

}
