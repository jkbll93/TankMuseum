package lesiak.jakub.Tank.Museum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Tank {

    private @Id String id;

    @NotEmpty
    @NotNull
    @NotBlank
    private String name;

    @Positive
    private double weight;

    Tank(){}

    Tank(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public Tank(String id, @NotEmpty @NotNull @NotBlank String name, @Positive double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
