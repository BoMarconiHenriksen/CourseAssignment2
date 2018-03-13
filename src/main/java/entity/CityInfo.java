
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CityInfo  implements Serializable {

  
    @Id
    private int zip;
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

 
    
}
