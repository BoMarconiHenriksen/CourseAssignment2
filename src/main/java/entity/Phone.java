
package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@DiscriminatorValue("Phone")
@Entity
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    public int number;
    private String description;
    //Mange Phone kender en InfoEntity.
    @ManyToOne
    private InfoEntity infoEntity;

    public Phone(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public Phone(int number, String description, InfoEntity infoEntity) {
        this.number = number;
        this.description = description;
        this.infoEntity = infoEntity;
    }

    public Phone() {
    }

    public InfoEntity getInfoEntity() {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity) {
        this.infoEntity = infoEntity;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Phone{" + "number=" + number + ", description=" + description + ", infoEntity=" + infoEntity + '}';
    }

}
