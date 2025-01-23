package org.example.Entity;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int stock;


    public Movie(int id, String title, String genre, int stock) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.stock = stock;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;

    }
}
