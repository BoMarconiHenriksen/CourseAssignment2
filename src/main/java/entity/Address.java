package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@DiscriminatorValue("Address")
@Entity
public class Address implements Serializable {

    private String street;
    //Denne referer til cityInfo. Mange Address kender en CityInfo
    @ManyToOne
    private CityInfo additionalInfo;

    @Id
    private Long id;

    @OneToMany(mappedBy = "address")//Denne referer til InfoEntity. En Address kender Mange InfoEntity
    private List<InfoEntity> infoEntities = new ArrayList();


    public Address() {

    }

    public List<InfoEntity> getInfoEntities() {
        return infoEntities;
    }

    public void setInfoEntities(List<InfoEntity> infoEntities) {
        this.infoEntities = infoEntities;
    }
    
    
    
    public Long getId() {
        return id;

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



    public void setId(Long id) {
        this.id = id;
    }

}
