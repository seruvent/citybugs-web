package tr.org.open.seruvent.citybugs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import tr.org.open.seruvent.citybugs.util.SeruventUtils;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=255, nullable=false, unique=true)
    private String username;

    @Column(length=255, nullable=false, unique=false)
    private String password;

    @Column(length=255, nullable=false, unique=true)
    private String email;

    @Column(length=255)
    private String name;

    @Column(length=255)
    private String surname;

    @Column(length=255)
    private String phone;

    @Column(length=255)
    private String facebook_id;

    @Column(length=1000)
    private String facebook_access_token;

    @CreationTimestamp
    @Column(nullable=false)
    private java.sql.Timestamp registerDate;

    @UpdateTimestamp
    private java.sql.Timestamp updateDate;

    private java.sql.Timestamp deleteDate;

    @ManyToOne
    @JoinColumn(name = "user_role_id", nullable = false)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Event> events;

    public User(){

    }

    public User(String username, String email, String name, String surname){
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setRandomPassword(){
        this.password = SeruventUtils.generateRandomString();
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getFacebook_access_token() {
        return facebook_access_token;
    }

    public void setFacebook_access_token(String facebook_access_token) {
        this.facebook_access_token = facebook_access_token;
    }
}
