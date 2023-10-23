package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")    // 이름을 바꿀 수 있음
public class Movie extends Item{
    private String director;
    private String actor;

    public String getDirector() {
        return director;
    }

    public String getActor() {
        return actor;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
