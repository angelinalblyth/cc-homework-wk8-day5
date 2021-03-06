package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studios")
public class Studio {

    private int id;
    private String name;
    private int budget;
    private List<Film> films;
    private List<Director> directors;

    public Studio() {
    }

    public Studio(String name, int budget) {
        this.name = name;
        this.budget = budget;
        this.films = new ArrayList<Film>();
        this.directors = new ArrayList<Director>();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy="studio", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

//    public void payStar(Star star) {
//        int amount = star.getPay();
//        this.budget -= amount;
//        star.setWallet(amount);
//    }
}
