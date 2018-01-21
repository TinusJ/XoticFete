package za.co.crosstek.jsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class GuestPreferences implements Serializable {

    private String color = "blue";

    private boolean dark = false;

    private String layoutMode = "horizontal";

    public void updateTheme(String color, boolean dark) {
        this.color = color;
        this.dark = dark;
    }

    public String getTheme() {
        return this.color + "-" + (this.dark ? "dark" : "light");
    }

    public void changeScheme() {
        this.dark = !this.dark;
        this.updateTheme(this.color, this.dark);
    }

    public String getLayoutMode() {
        return this.layoutMode;
    }

    public void setLayoutMode(String value) {
        this.layoutMode = value;
    }

    public boolean isDark() {
        return this.dark;
    }

    public void setDark(boolean value) {
        this.dark = dark;
    }
}
