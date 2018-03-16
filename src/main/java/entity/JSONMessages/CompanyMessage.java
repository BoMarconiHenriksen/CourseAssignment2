/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.JSONMessages;

import entity.Address;
import entity.Company;
import entity.Hobby;
import facade.CompanyFacade;
import facade.PersonFacade;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ticondrus
 */
public class CompanyMessage implements JSONMessage<Company> {

    private String name;
    private String description;
    private int cvr;
    private int numEmployees;
    private int marketValue;

    public CompanyMessage(Company c) {


        this.name = c.getName();
        this.description = c.getDescription();

    }

    @Override
    public Company toInternal() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    Address address = new Address();
        ArrayList<Company>cmpanies = new ArrayList();
        for (Company cmp :cmpanies){
            cmpanies.add((Company) CompanyFacade.findCompanyByName(em, name));
        
    }
        return new Company(name, description, cvr, numEmployees, marketValue, address, name);
    }
}
