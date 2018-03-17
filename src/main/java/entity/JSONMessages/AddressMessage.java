/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.JSONMessages;


import entity.Address;
import entity.CityInfo;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import facade.InfoEntityFacade;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Ejer
 */
public class AddressMessage implements JSONMessage<Address> {

    public String streetName;
    public int zip;
    public long id;
    public List<InfoEntity> inforentities;
    private  CityInfo CityInfo;
//
    public AddressMessage(Address a) {
       this.CityInfo=a.getCityinfo();
        this.id = a.getId();
        this.inforentities=a.getInfoEntities();
    }

    @Override
    public Address toInternal() {
        return null;
//         EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
//    
//    EntityManager em = emf.createEntityManager();
//   InfoEntityFacade ifa = new InfoEntityFacade();
//   InfoEntity ie = null;
//        ArrayList<Phone> phones = new ArrayList<>();
//        for (Phone id : phones) {
//            phones.add(ie.getPhones().get(id.getNumber()));
//        }
//        return new InfoEntity(ie.id, ie.getAddress(), ie.id,phones) {};
    
    }}
   
  
  
 

