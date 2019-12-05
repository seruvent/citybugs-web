package tr.org.open.seruvent.citybugs.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private Set<Event> events;

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
}
