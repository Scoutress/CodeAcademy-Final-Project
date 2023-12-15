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

    private double priceForOneGram;

    private double priceForOneMililitre;

    private double priceForOneTablespoon;

    private double priceForOneTeaspoon;

    private double priceForOneUnit;

    public Ingredient(){}

    public Ingredient(int id, String name, double priceForOneGram, double priceForOneMililitre,
            double priceForOneTablespoon, double priceForOneTeaspoon, double priceForOneUnit) {
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

    public double getPriceForOneGram() {
        return priceForOneGram;
    }

    public void setPriceForOneGram(double priceForOneGram) {
        this.priceForOneGram = priceForOneGram;
    }

    public double getPriceForOneMililitre() {
        return priceForOneMililitre;
    }

    public void setPriceForOneMililitre(double priceForOneMililitre) {
        this.priceForOneMililitre = priceForOneMililitre;
    }

    public double getPriceForOneTablespoon() {
        return priceForOneTablespoon;
    }

    public void setPriceForOneTablespoon(double priceForOneTablespoon) {
        this.priceForOneTablespoon = priceForOneTablespoon;
    }

    public double getPriceForOneTeaspoon() {
        return priceForOneTeaspoon;
    }

    public void setPriceForOneTeaspoon(double priceForOneTeaspoon) {
        this.priceForOneTeaspoon = priceForOneTeaspoon;
    }

    public double getPriceForOneUnit() {
        return priceForOneUnit;
    }

    public void setPriceForOneUnit(double priceForOneUnit) {
        this.priceForOneUnit = priceForOneUnit;
    }

    
}
