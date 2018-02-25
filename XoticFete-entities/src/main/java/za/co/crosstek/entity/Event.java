package za.co.crosstek.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.EntityAttribute;
import za.co.crosstek.enums.EventTag;
import za.co.crosstek.enums.FieldExclusion;
import za.co.crosstek.enums.FieldType;

@Entity
@EntityAnotation(attributes = {EntityAttribute.SHOW_ON_MENU, EntityAttribute.REST}, label = "Event", icon = "fa fa-calendar")
public class Event extends CoreEntity {

    @NotNull
    @Column(nullable = false)
    @FieldAnotation(label = "Event Name")
    private String eventName;

    @Column(length = Short.MAX_VALUE)
    @FieldAnotation(label = "Description")
    private String description;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = EventTag.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "event_tags")
    @Column(name = "eventtag")
    @FieldAnotation(label = "Event Tags", exclusions = {FieldExclusion.LIST})
    private List<EventTag> eventTags;

    @Temporal(TemporalType.TIMESTAMP)
    @FieldAnotation(label = "Start Date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @FieldAnotation(label = "End Date")
    private Date endDate;

    @Column(nullable = false)
    @FieldAnotation(label = "Entrance Fee", type = FieldType.CURRENCY)
    private Double entranceFee;

    @OneToOne(fetch = FetchType.LAZY)
    @FieldAnotation(label = "Attachment", type = FieldType.ATTACHMENT, exclusions = {FieldExclusion.LIST})
    private Attachment attachment;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    @FieldAnotation(label = "Reviews", exclusions = {FieldExclusion.LIST})
    private Set<EventReview> eventReviews;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    @FieldAnotation(label = "Favorites", exclusions = {FieldExclusion.LIST})
    private Set<FavoriteEvent> eventFavorites;

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

    public Set<EventReview> getEventReviews() {
        return eventReviews;
    }

    public void setEventReviews(Set<EventReview> eventReviews) {
        this.eventReviews = eventReviews;
    }

    public Set<FavoriteEvent> getEventFavorites() {
        return eventFavorites;
    }

    public void setEventFavorites(Set<FavoriteEvent> eventFavorites) {
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
