/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.JSONMessages;

import entity.InfoEntity;
import entity.Phone;
import facade.InfoEntityFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ejer
 */
public class EntityMessage implements JSONMessage {

    @Override
    public InfoEntity toInternal() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");

        EntityManager em = emf.createEntityManager();
        InfoEntityFacade ifa = new InfoEntityFacade();
        InfoEntity ie = null;
        List<Phone> phones = new ArrayList<>();
        for (Phone id : phones) {
            phones.add(ie.getPhones().get(id.getNumber()));
        }
        return new InfoEntity(ie.getAddress(), ie.getEmail(), phones) {
        };

    }
}
