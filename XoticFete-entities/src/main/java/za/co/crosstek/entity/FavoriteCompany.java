package za.co.crosstek.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.EntityAttribute;
 
/**
 *
 * @author Tinus
 */
@Entity
@EntityAnotation(attributes = {EntityAttribute.REST}, label = "Favrorite Company", icon = "fa fa-star")
public class FavoriteCompany extends CoreEntity {

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Logo")
    private Company company;

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Mobile User")
    private MobileUser mobileUser;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }

    @Override
    public String toString() {
        return mobileUser.toString() + " " + company.toString();
    }

}
