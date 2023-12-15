package lt.codeacademy.javau7.finalproject1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Double priceForOneGram;

    private Double priceForOneMililitre;

    private Double priceForOneTablespoon;

    private Double priceForOneTeaspoon;

    private Double priceForOneUnit;

    public Ingredient(){}

    public Ingredient(int id, String name, Double priceForOneGram, Double priceForOneMililitre,
        Double priceForOneTablespoon, Double priceForOneTeaspoon, Double priceForOneUnit) {
        this.id = id;
        this.name = name;
        this.priceForOneGram = priceForOneGram;
        this.priceForOneMililitre = priceForOneMililitre;
        this.priceForOneTablespoon = priceForOneTablespoon;
        this.priceForOneTeaspoon = priceForOneTeaspoon;
        this.priceForOneUnit = priceForOneUnit;
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

    public Double getPriceForOneGram() {
        return priceForOneGram;
    }

    public void setPriceForOneGram(Double priceForOneGram) {
        this.priceForOneGram = priceForOneGram;
    }

    public Double getPriceForOneMililitre() {
        return priceForOneMililitre;
    }

    public void setPriceForOneMililitre(Double priceForOneMililitre) {
        this.priceForOneMililitre = priceForOneMililitre;
    }

    public Double getPriceForOneTablespoon() {
        return priceForOneTablespoon;
    }

    public void setPriceForOneTablespoon(Double priceForOneTablespoon) {
        this.priceForOneTablespoon = priceForOneTablespoon;
    }

    public Double getPriceForOneTeaspoon() {
        return priceForOneTeaspoon;
    }

    public void setPriceForOneTeaspoon(Double priceForOneTeaspoon) {
        this.priceForOneTeaspoon = priceForOneTeaspoon;
    }

    public Double getPriceForOneUnit() {
        return priceForOneUnit;
    }

    public void setPriceForOneUnit(Double priceForOneUnit) {
        this.priceForOneUnit = priceForOneUnit;
    }
}
