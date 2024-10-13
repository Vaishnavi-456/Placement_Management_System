package tns.T050400946.application.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    @Id
    private long id;
    
    private String username;
    private String type;  // Can be "admin" or "student"
    private String password;
    
    @OneToOne(mappedBy = "collegeAdmin") // Reference to College entity
    @JsonIgnoreProperties("collegeAdmin")
    private College college;

    public User() {
        super();
    }

    public User(long id, String username, String type, String password) {
        super();
        this.id = id;
        this.username = username;
        this.type = type;
        this.password = password;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", type=" + type + ", password=" + password + "]";
    }
}
