package tr.org.open.seruvent.citybugs.model;


import javax.persistence.*;


public class EventResource {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private long eventId;
  private String url;
  private java.sql.Timestamp registerDate;
  private java.sql.Timestamp updateDate;
  private java.sql.Timestamp deleteDate;


  public long getEventId() {
    return eventId;
  }

  public void setEventId(long eventId) {
    this.eventId = eventId;
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
