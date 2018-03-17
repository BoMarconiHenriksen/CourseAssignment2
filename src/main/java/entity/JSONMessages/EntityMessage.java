/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.JSONMessages;

import entity.Address;
import entity.InfoEntity;
import entity.Phone;
import facade.InfoEntityFacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ejer
 */
public class EntityMessage implements JSONMessage {

    public Long id;
    public Address address;
    public String email;

    public EntityMessage(InfoEntity ie) {
        this.id = ie.getId();
        this.address = ie.getAddress();
        this.email = ie.getEmail();
    }

    @Override
    public InfoEntity toInternal() {

        List<Phone> phoneys = new ArrayList<>();
        for (Phone id : phoneys) {
            phoneys.add(InfoEntityFacade.getPhones(id.number));
        }
        return new InfoEntity(address, email, phoneys) {
        };

    }
}
