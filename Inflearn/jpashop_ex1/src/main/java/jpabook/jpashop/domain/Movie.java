package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item{
    private String director;
    private String author;

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDirector() {
        return director;
    }

    public String getAuthor() {
        return author;
    }
}
