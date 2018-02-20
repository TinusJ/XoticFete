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
@EntityAnotation(attributes = {EntityAttribute.REST}, label = "Favorite Special", icon = "fa fa-star")
public class FavoriteSpecial extends CoreEntity {

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Special")
    private Special special;

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Mobile User")
    private MobileUser mobileUser;

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }

    @Override
    public String toString() {
        return mobileUser.toString() + " " + special.toString();
    }

}
