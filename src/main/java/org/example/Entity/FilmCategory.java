package org.example.Entity;

public class FilmCategory {
    private int filmId;
    private int categoryId;
    private String lastUpdate;

    public FilmCategory(int filmId, int categoryId, String lastUpdate) {
        this.filmId = filmId;
        this.categoryId = categoryId;
        this.lastUpdate = lastUpdate;
    }

    public int getFilmId() {
        return filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}


