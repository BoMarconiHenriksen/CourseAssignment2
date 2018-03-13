
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CityInfo  implements Serializable {

  
    @Id
    private int zip;
    private String city;
    //En CityInfo kender mange Address
    @OneToMany(mappedBy = "additionalInfo")
    private List<Address> addresses = new ArrayList();

    public CityInfo(int zip, String city) {
        this.zip = zip;
        this.city = city;
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

 
    
}
