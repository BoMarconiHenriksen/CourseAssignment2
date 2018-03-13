
package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@DiscriminatorValue("Address")
@Entity
public class Address implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private CityInfo additionalInfo;

    public Address(String street, CityInfo additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
    }
    
    public Address() {
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public CityInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(CityInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

}
