package com.example.assignmentmovie.entity;

import javax.persistence.*;
@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cast_id;

    private int movie_id;
    @ManyToOne()
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private CastEntity movies;

    public int getCast_id() {
        return cast_id;
    }

    public void setCast_id(int cast_id) {
        this.cast_id = cast_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public CastEntity getMovies() {
        return movies;
    }

    public void setMovies(CastEntity movies) {
        this.movies = movies;
    }
}
