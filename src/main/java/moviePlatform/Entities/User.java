package moviePlatform.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private int active;
    private String username;
    private String password;
    private String role;
    private String gender;
    private String location;
    private String description;
    private String profilePhoto;

    public User(int active,String username, String password, String role, String gender, String location, String description, String profilePhoto)
    {
        this.active=active;
        this.username=username;
        this.password=password;
        this.role=role;
        this.gender=gender;
        this.location=location;
        this.description=description;
        this.profilePhoto=profilePhoto;
    }

    public User()
    {
        this.active=0;
        this.username="";
        this.password="";
        this.role="Guest";
        this.gender="";
        this.location="";
        this.description="";
        this.profilePhoto="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", active='" + active + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profilePicture='" + profilePhoto + '\'' +
                ", active='" + active + '\'' +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
