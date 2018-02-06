package za.co.crosstek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.CoreAttribute;
import za.co.crosstek.anot.EntityAnotation;

@Entity
@EntityAnotation(attributes = {CoreAttribute.REST}, label = "Special Review", icon = "fa fa-rating")
public class SpecialReview extends CoreEntity {

    protected static final long serialVersionUID = 1L;

    @ManyToOne
    @NotNull
    private Special special;

    @ManyToOne
    @NotNull
    private MobileUser mobileUser;

    @NotNull
    @Column(nullable = false)
    private String title;

    @Column(length = Short.MAX_VALUE)
    private String comment;

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
