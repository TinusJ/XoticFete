package za.co.crosstek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.EntityAttribute;
import za.co.crosstek.enums.FieldType;

@Entity
@EntityAnotation(attributes = {EntityAttribute.REST}, label = "Event Review", icon = "fa fa-calendar")
public class EventReview extends CoreEntity {

    protected static final long serialVersionUID = 1L;

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Event")
    private Event event;

    @Column(nullable = false)
    @NotNull
    @FieldAnotation(label = "Title")
    private String title;

    @Column(length = Short.MAX_VALUE)
    @FieldAnotation(label = "Comment")
    private String comment;

    @FieldAnotation(label = "Rating", type = FieldType.RATING)
    private Integer rating;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }

    @Override
    public String toString() {
        return event.toString() + " " + title;
    }
}
