package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "zip")
    private int zip;
    private String city;

    //En CityInfo kender mange Address
    @OneToMany(mappedBy = "cityinfo")
    private List<Address> addresses = new ArrayList();
    public CityInfo(int zip, String city) {
        this.zip = zip;
        this.city = city;
    }

    public CityInfo() {
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;

    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CityInfo{" + "zip=" + zip + ", city=" + city + '}';
    }

}
