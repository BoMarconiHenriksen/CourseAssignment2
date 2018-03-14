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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    
    //Denne referer til cityInfo. Mange Address kender en CityInfo
    @ManyToOne
    private CityInfo cityinfo;
    
    //Denne referer til InfoEntity. En Address kender Mange InfoEntity
    @OneToMany(mappedBy = "address")
    private List<InfoEntity> infoEntities = new ArrayList();

    public Address(String street, CityInfo cityinfo) {
        this.street = street;
        this.cityinfo = cityinfo;
    }
    
    public Address() {

    }

    public CityInfo getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(CityInfo cityinfo) {
        this.cityinfo = cityinfo;
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



    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", additionalInfo=" + cityinfo + ", infoEntities=" + infoEntities + '}';
    }
    
    

}
