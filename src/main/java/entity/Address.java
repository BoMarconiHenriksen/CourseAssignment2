
package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@DiscriminatorValue("Address")
@Entity
public class Address extends InfoEntity implements Serializable {

    private String street;
    private CityInfo additionalInfo;

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
