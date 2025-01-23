package org.example.Entity;

public class FilmActor {
    private int actorId;
    private int filmId;
    private String lastUpdate;

    public FilmActor(int actorId, int filmId, String lastUpdate) {
        this.actorId = actorId;
        this.filmId = filmId;
        this.lastUpdate = lastUpdate;
    }

    public int getActorId() {
        return actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}


