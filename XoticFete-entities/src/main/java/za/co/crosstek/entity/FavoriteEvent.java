package za.co.crosstek.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tinus
 */
@Entity
public class FavoriteEvent extends CoreEntity {

    @ManyToOne
    @NotNull
    private Event event;

    @ManyToOne
    @NotNull
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
