package za.co.crosstek.util;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ApplicationSettings implements Serializable {

    private final String applicationName = "Xotic Fete";
    private final String version = "1.0.0";

    public String getApplicationName() {
        return applicationName;
    }

    public String getVersion() {
        return version;
    }

}
