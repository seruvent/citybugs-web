package tr.org.open.seruvent.citybugs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

    @Id
    private long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String phone;
    private java.sql.Timestamp registerDate;
    private java.sql.Timestamp updateDate;
    private java.sql.Timestamp deleteDate;


    public long getId() {
    return id;
    }

    public void setId(long id) {
    this.id = id;
    }


    public String getUsername() {
    return username;
    }

    public void setUsername(String username) {
    this.username = username;
    }


    public String getPassword() {
    return password;
    }

    public void setPassword(String password) {
    this.password = password;
    }


    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
    this.email = email;
    }


    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }


    public String getSurname() {
    return surname;
    }

    public void setSurname(String surname) {
    this.surname = surname;
    }


    public String getPhone() {
    return phone;
    }

    public void setPhone(String phone) {
    this.phone = phone;
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
