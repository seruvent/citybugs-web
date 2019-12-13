package tr.org.open.seruvent.citybugs.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=255)
    private String title;

    @Column(length=1255)
    private String description;

    @Column(length=255, nullable=false)
    private String gpsLocation;

    @CreationTimestamp
    @Column(nullable=false)
    private java.sql.Timestamp registerDate;

    @UpdateTimestamp
    private java.sql.Timestamp updateDate;

    private java.sql.Timestamp deleteDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "event")
    private Set<EventResource> eventResources;

    private long state;


    public long getId() {
    return id;
    }

    public void setId(long id) {
    this.id = id;
    }


    public String getTitle() {
    return title;
    }

    public void setTitle(String title) {
    this.title = title;
    }


    public String getDescription() {
    return description;
    }

    public void setDescription(String description) {
    this.description = description;
    }


    public String getGpsLocation() {
    return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
    this.gpsLocation = gpsLocation;
    }


    public long getState() {
    return state;
    }

    public void setState(long state) {
    this.state = state;
    }


    public java.sql.Timestamp getRegisterDate() {
    return registerDate;
    }

    public void setRegisterDate(java.sql.Timestamp registerDate) {
    this.registerDate = registerDate;
    }


    public java.sql.Timestamp getUpdateDate() {
    return updateDate;
    }

    public void setUpdateDate(java.sql.Timestamp updateDate) {
    this.updateDate = updateDate;
    }


    public java.sql.Timestamp getDeleteDate() {
    return deleteDate;
    }

    public void setDeleteDate(java.sql.Timestamp deleteDate) {
    this.deleteDate = deleteDate;
    }

    public User getUser() {
      return user;
    }

    public void setUser(User user) {
      this.user = user;
    }

    public Set<EventResource> getEventResources() {
        return eventResources;
    }

    public void setEventResources(Set<EventResource> eventResources) {
        this.eventResources = eventResources;
    }
}
