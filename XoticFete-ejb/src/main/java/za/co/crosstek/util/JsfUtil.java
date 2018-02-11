package za.co.crosstek.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Tinus
 */
public class JsfUtil {

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Convenience method for setting Session variables.
     *
     * @param key object key
     * @param object value to store
     */
    public static void storeOnSession(String key, Object object) {
        Map session = getFacesContext().getExternalContext().getSessionMap();
        session.put(key, object);
    }

    /**
     * Convenience method for getting Session variables.
     *
     * @param key object key
     */
    public static Object getFromSession(String key) {
        Map session = getFacesContext().getExternalContext().getSessionMap();
        return session.get(key);
    }

    public static void redirect(String redirectUrl) {
        try {
            getFacesContext().getExternalContext().redirect(redirectUrl);
        } catch (IOException e) {
            System.out.println("Error redirecting to " + redirectUrl + ": "
                    + e.getMessage());
        }
    }

    /**
     *
     * Generates select element list
     *
     * @param entities
     * @param selectOne
     * @return
     */
    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "-- Select --");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    public static void addWarningMessage(String title, String msg) {

        if (StringUtils.isEmpty(title)) {
            title = "Warning";
        }

        addMessage(FacesMessage.SEVERITY_WARN, title, msg);
    }

    public static void addErrorMessage(String title, String msg) {

        if (StringUtils.isEmpty(title)) {
            title = "Error";
        }

        addMessage(FacesMessage.SEVERITY_ERROR, title, msg);

        if (getFacesContext() != null) {
            getFacesContext().validationFailed();                                             // Invalidate JSF page if we raise an error message
        }
    }

    public static void addSuccessMessage(String title, String msg) {

        if (StringUtils.isEmpty(title)) {
            title = "Success";
        }

        addMessage(FacesMessage.SEVERITY_INFO, title, msg);
    }

    public static void addInfoMessage(String title, String msg) {

        if (StringUtils.isEmpty(title)) {
            title = "Info";
        }

        addMessage(FacesMessage.SEVERITY_INFO, title, msg);
    }

    private static void addMessage(FacesMessage.Severity severity, String title, String message) {
        FacesMessage facesMsg = new FacesMessage(severity, title, message);

        if (getFacesContext() != null) {
            getFacesContext().addMessage(null, facesMsg);
        }
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    public static String getRequestURI() {
        HttpServletRequest request = getRequest();
        return request.getRequestURI();
    }

    public static String getViewId() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        return viewRoot.getViewId();
    }

    public static String getRealPath() {
        return getRequest().getSession().getServletContext().getRealPath("/");
    }
}
