package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorColumn(name = "INFOTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    //Mange InfoEntity kender en Address
    @ManyToOne
    private Address address;
    //En InfoEntity kender mange Phone.
    
   
    @OneToMany(mappedBy = "infoEntity",cascade=CascadeType.PERSIST)
    private List<Phone> phones;

    private String email;

    public InfoEntity() {
        this.phones = new ArrayList();
    }

    public InfoEntity(Address address, String email, List<Phone> phones) {
        this.phones = new ArrayList();
        this.address = address;
        this.email = email;
        this.phones = phones;
    }

    public InfoEntity(Long id, Address address, String email, List<Phone> phones) {
        this.phones = new ArrayList();
        this.id = id;
        this.address = address;
        this.email = email;
        this.phones = phones;
    }

    public InfoEntity(Address address, String email) {
        this.phones = new ArrayList();
        this.address = address;
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoEntity)) {
            return false;
        }
        InfoEntity other = (InfoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InfoEntity{" + "id=" + id + ", address=" + address + ", phones=" + phones + ", email=" + email + '}';
    }

}
