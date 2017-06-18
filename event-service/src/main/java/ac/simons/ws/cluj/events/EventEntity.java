package ac.simons.ws.cluj.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Entity
@Table(
        name = "events",
        uniqueConstraints = {
            @UniqueConstraint(name = "events_uk", columnNames = {"held_on", "name"})
        }
)
@JsonInclude(NON_NULL)
public class EventEntity implements Serializable {

    private static final long serialVersionUID = 2005305860095134425L;

    /**
     * Status of an event.
     */
    public enum Status {

        open, closed
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "held_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar heldOn;

    @Column(length = 512, nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Calendar createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * Needed for Hibernate, not to be called by application code.
     */
    protected EventEntity() {
    }

    public EventEntity(final Calendar heldOn, final String name) {
        this.heldOn = heldOn;
        this.name = name;
        this.status = Status.open;
    }

    @PrePersist
    @PreUpdate
    void prePersistAndUpdate() {
        if (this.createdAt == null) {
            this.createdAt = Calendar.getInstance();
        }
    }

    public Integer getId() {
        return id;
    }

    public Calendar getHeldOn() {
        return heldOn;
    }

    public String getName() {
        return name;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.heldOn);
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EventEntity other = (EventEntity) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.heldOn, other.heldOn);
    }
}
