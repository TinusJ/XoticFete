package za.co.crosstek.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

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

    /**
     *
     * Adds error message to page.
     *
     * @param ex
     * @param defaultMsg
     */
    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    /**
     *
     * Adds list of error messages to page.
     *
     * @param messages
     */
    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    /**
     *
     * Adds error message to page.
     *
     * @param msg
     */
    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     *
     * Adds sucesses message to page
     *
     * @param msg
     */
    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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
