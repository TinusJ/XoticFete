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
@EntityAnotation(attributes = {EntityAttribute.REST}, label = "Special Review", icon = "fa fa-rating")
public class SpecialReview extends CoreEntity {

    protected static final long serialVersionUID = 1L;

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Special")
    private Special special;

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Mobile User")
    private MobileUser mobileUser;

    @NotNull
    @Column(nullable = false)
    @FieldAnotation(label = "Title")
    private String title;

    @Column(length = Short.MAX_VALUE)
    @FieldAnotation(label = "Comment")
    private String comment;

    @FieldAnotation(label = "Rating", type = FieldType.RATING)
    private Integer rating;

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
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
        return special.toString() + " " + title;
    }
}
