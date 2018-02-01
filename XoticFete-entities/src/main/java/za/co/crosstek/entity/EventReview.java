package za.co.crosstek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class EventReview extends CoreEntity {

    protected static final long serialVersionUID = 1L;

    @ManyToOne
    @NotNull
    private Event event;

    @Column(nullable = false)
    @NotNull
    private String title;

    @Column(length = Short.MAX_VALUE)
    private String comment;

    private Integer rating;

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

    @Override
    public String toString() {
        return event.toString() + " " + title;
    }
}
