package movie.movies.model;

import java.io.InputStream;
import java.util.Date;

public class BeanMovie {
    private int id;
    private String name;
    private String description;
    private Date publish_date;
    private String actors;
    private String duration;
    private String ranking;
    private String imageToShow;
    private InputStream imageToInsert;
    private int status;

    public BeanMovie() {
    }

    public BeanMovie(int id, String name, String description, Date publish_date, String actors, String duration, String ranking, String imageToShow, InputStream imageToInsert, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.publish_date = publish_date;
        this.actors = actors;
        this.duration = duration;
        this.ranking = ranking;
        this.imageToShow = imageToShow;
        this.imageToInsert = imageToInsert;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getImageToShow() {
        return imageToShow;
    }

    public void setImageToShow(String imageToShow) {
        this.imageToShow = imageToShow;
    }

    public InputStream getImageToInsert() {
        return imageToInsert;
    }

    public void setImageToInsert(InputStream imageToInsert) {
        this.imageToInsert = imageToInsert;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BeanMovie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", publish_date=" + publish_date +
                ", actors='" + actors + '\'' +
                ", duration='" + duration + '\'' +
                ", ranking='" + ranking + '\'' +
                ", imageToShow='" + imageToShow + '\'' +
                ", imageToInsert=" + imageToInsert +
                ", status=" + status +
                '}';
    }
}
