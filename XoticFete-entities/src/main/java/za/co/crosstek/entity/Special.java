package za.co.crosstek.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import za.co.crosstek.enums.SpecialTag;

@Entity
public class Special extends CoreEntity {

    @NotNull
    @Column(nullable = false)
    private String name;

    @Column(length = Short.MAX_VALUE)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Double price;

    @OneToOne
    private Attachment image;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = SpecialTag.class)
    @CollectionTable(name = "special_tags")
    @Column(name = "specialtag")
    private List<SpecialTag> specialTags;

    @Temporal(TemporalType.TIME)
    private Date specialStartTime;

    @Temporal(TemporalType.TIME)
    private Date specialEndTime;

    @OneToMany(mappedBy = "special", cascade = CascadeType.REFRESH)
    private List<SpecialReview> specialReviews;

    @Transient
    private Integer viewed;

    @Transient
    private Boolean launched;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Attachment getImage() {
        return image;
    }

    public void setImage(Attachment image) {
        this.image = image;
    }

    public List<SpecialTag> getSpecialTags() {
        return specialTags;
    }

    public void setSpecialTags(List<SpecialTag> specialTags) {
        this.specialTags = specialTags;
    }

    public Date getSpecialStartTime() {
        return specialStartTime;
    }

    public void setSpecialStartTime(Date specialStartTime) {
        this.specialStartTime = specialStartTime;
    }

    public Date getSpecialEndTime() {
        return specialEndTime;
    }

    public void setSpecialEndTime(Date specialEndTime) {
        this.specialEndTime = specialEndTime;
    }

    public List<SpecialReview> getSpecialReviews() {
        return specialReviews;
    }

    public void setSpecialReviews(List<SpecialReview> specialReviews) {
        this.specialReviews = specialReviews;
    }

    public Integer getViewed() {
        return viewed;
    }

    public void setViewed(Integer viewed) {
        this.viewed = viewed;
    }

    public Boolean getLaunched() {
        return launched;
    }

    public void setLaunched(Boolean launched) {
        this.launched = launched;
    }

    @Override
    public String toString() {
        return name + "(R" + price + ")";
    }
}
