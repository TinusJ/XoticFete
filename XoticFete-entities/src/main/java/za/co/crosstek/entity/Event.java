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
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import za.co.crosstek.enums.EventTag;

@Entity
public class Event extends CoreEntity {

    @NotNull
    @Column(nullable = false)
    private String eventName;

    @Column(length = Short.MAX_VALUE)
    private String description;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = EventTag.class)
    @CollectionTable(name = "event_tags")
    @Column(name = "eventtag")
    private List<EventTag> eventTags;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(nullable = false)
    private Double entranceFee;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REFRESH)
    private List<EventReview> eventReviews;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REFRESH)
    private List<FavoriteEvent> eventFavorites;

    @Transient
    private Integer viewed;

    @Transient
    private Boolean launched;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EventTag> getEventTags() {
        return eventTags;
    }

    public void setEventTags(List<EventTag> eventTags) {
        this.eventTags = eventTags;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getEntranceFee() {
        return entranceFee;
    }

    public void setEntranceFee(Double entranceFee) {
        this.entranceFee = entranceFee;
    }

    public List<EventReview> getEventReviews() {
        return eventReviews;
    }

    public void setEventReviews(List<EventReview> eventReviews) {
        this.eventReviews = eventReviews;
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

    public List<FavoriteEvent> getEventFavorites() {
        return eventFavorites;
    }

    public void setEventFavorites(List<FavoriteEvent> eventFavorites) {
        this.eventFavorites = eventFavorites;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return eventName + " - " + entranceFee;
    }
}
