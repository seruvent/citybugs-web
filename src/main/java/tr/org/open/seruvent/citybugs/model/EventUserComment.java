package tr.org.open.seruvent.citybugs.model;

public class EventUserComment {

  private long userId;
  private long eventId;
  private String comment;
  private long voting;
  private java.sql.Timestamp registerDate;
  private java.sql.Timestamp updateDate;
  private java.sql.Timestamp deleteDate;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getEventId() {
    return eventId;
  }

  public void setEventId(long eventId) {
    this.eventId = eventId;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  public long getVoting() {
    return voting;
  }

  public void setVoting(long voting) {
    this.voting = voting;
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
