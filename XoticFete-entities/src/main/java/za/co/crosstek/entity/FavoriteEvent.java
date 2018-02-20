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
@EntityAnotation(attributes = { EntityAttribute.REST}, label = "Favorite Event", icon = "fa fa-star")
public class FavoriteEvent extends CoreEntity {

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Event")
    private Event event;

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Mobile User")
    private MobileUser mobileUser;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }

    @Override
    public String toString() {
        return mobileUser.toString() + " " + event.toString();
    }

}
