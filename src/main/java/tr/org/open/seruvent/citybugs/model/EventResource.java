package tr.org.open.seruvent.citybugs.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Table(name="event_resources")
public class EventResource {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "event_id", nullable = false)
  @JsonBackReference
  private Event event;

  @Column(length=1000)
  private String url;

  @CreationTimestamp
  @Column(nullable=false)
  private java.sql.Timestamp registerDate;

  @UpdateTimestamp
  private java.sql.Timestamp updateDate;

  private java.sql.Timestamp deleteDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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



}
