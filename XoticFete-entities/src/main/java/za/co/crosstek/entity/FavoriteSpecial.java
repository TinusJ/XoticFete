package za.co.crosstek.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tinus
 */
@Entity
public class FavoriteSpecial extends CoreEntity {

    @ManyToOne
    @NotNull
    private Special special;

    @ManyToOne
    @NotNull
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
