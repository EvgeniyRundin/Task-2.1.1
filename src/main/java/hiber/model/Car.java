package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int series;

    @Column
    private String model;

    @OneToOne(mappedBy = "car")
    @JoinColumn(name = "car_id", referencedColumnName ="id")
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public int setSeries(int series) {
        this.series = series;
        return series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    @Override
    public String toString(){
        return model + " " + series;
    }
}
