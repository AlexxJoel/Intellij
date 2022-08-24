package canciones.canciones.model;

import java.util.Date;

public class BeanSongs {
    private int id;
    private String name;
    private String album;
    private String genero;
    private int duration;
    private String artist;
    private Date year;


    public BeanSongs() {
    }

    public BeanSongs(int id, String name, String album, String genero, int duration, String artist, Date year) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.genero = genero;
        this.duration = duration;
        this.artist = artist;
        this.year = year;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "BeanSongs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", album='" + album + '\'' +
                ", genero='" + genero + '\'' +
                ", duration=" + duration +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                '}';
    }
}
