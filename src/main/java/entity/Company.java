package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("Company")
@Entity
public class Company extends InfoEntity implements Serializable {

    private String name;
    private String description;
    private int cvr;
    private int numEmployees;
    private int marketValue;

    public Company(String name, String description, int cvr, int numEmployees, int marketValue, Address address, String email) {
        super(address, email);
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public Company() {
    }

    public Company(Address address, String email) {
        super(address, email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + ", description=" + description + ", cvr=" + cvr + ", numEmployees=" + numEmployees + ", marketValue=" + marketValue + '}';
    }

}
