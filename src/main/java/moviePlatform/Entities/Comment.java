package moviePlatform.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private String numeFilm;
    private String comment;

    public Comment(int userId, String numeFilm, String comment)
    {
        this.userId=userId;
        this.numeFilm=numeFilm;
        this.comment=comment;
    }
    public Comment() {
        this.id=-1;
        this.userId=-1;
        this.numeFilm="";
        this.comment="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumeFilm() {
        return numeFilm;
    }

    public void setNumeFilm(String numeFilm) {
        this.numeFilm = numeFilm;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
