package za.co.crosstek.entity;

import javax.persistence.Entity;

/**
 *
 * @author Tinus
 */
@Entity
public class Company extends CoreEnity {

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
