package moviePlatform.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.context.annotation.EnableMBeanExport;

@Entity
public class Movie {
    @Id
    private String name;
    private int id;
    private String type;
    private int episodes;
    private String status;
    private String aired;
    private String premiered;
    private String producers;
    private String licensors;
    private String studios;
    private String genres;
    private String theme;
    private String demographic;
    private String duration;
    private String description;
    private int rating;
    private String photo;

    public Movie(int id,String name,String type,int episodes, String status, String aired, String premiered, String producers,String licensors,
                 String studios,String genres,String theme,String demographic,String duration,String description,int rating, String photo)
    {
        this.id=id;
        this.name=name;
        this.type=type;
        this.episodes=episodes;
        this.status=status;
        this.aired=aired;
        this.premiered=premiered;
        this.producers=producers;
        this.licensors=licensors;
        this.studios=studios;
        this.genres=genres;
        this.theme=theme;
        this.demographic=demographic;
        this.duration=duration;
        this.description=description;
        this.rating=rating;
        this.photo=photo;
    }
    public Movie()
    {
        this.id=-1;
        this.name= "";
        this.type="";
        this.episodes=-1;
        this.status="";
        this.aired="";
        this.premiered="";
        this.producers="";
        this.licensors="";
        this.studios="";
        this.genres="";
        this.theme="";
        this.demographic="";
        this.duration="";
        this.description="";
        this.rating=-1;
        this.photo="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAired() {
        return aired;
    }

    public void setAired(String aired) {
        this.aired = aired;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getLicensors() {
        return licensors;
    }

    public void setLicensors(String licensors) {
        this.licensors = licensors;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDemographic() {
        return demographic;
    }

    public void setDemographic(String demographic) {
        this.demographic = demographic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description=description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo=photo;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", episodes='" + episodes + '\'' +
                ", status='" + status + '\'' +
                ", aired='" + aired + '\'' +
                ", premiered='" + premiered + '\'' +
                ", producers='" + producers + '\'' +
                ", licensors='" + licensors + '\'' +
                ", studios='" + studios + '\'' +
                ", genres='" + genres + '\'' +
                ", theme='" + theme + '\'' +
                ", demographic='" + demographic + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", photo='" + photo + '\'' +

                '}';
    }

}
