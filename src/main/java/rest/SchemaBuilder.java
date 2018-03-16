/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ejer
 */
public class SchemaBuilder {

    public static void main(String[] args) throws InterruptedException {
//        Persistence.generateSchema("CourseAssignment2_war_1.0-SNAPSHOTPU", null);
//        HashMap puproperties = new HashMap();
//        puproperties.put("javax.persistence.sql-load-script-source", "scripts/cityinfoscript.sql");
//
//        //   puproperties.put("javax.persistence.sql-load-script-source", "oneTimeSetupCa2.sql");
//        Persistence.generateSchema("CourseAssignment2_war_1.0-SNAPSHOTPU", puproperties);
//
//        puproperties.remove("scripts/cityinfoscript.sql");

//        Persistence.generateSchema("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU", null);
        HashMap puproperties2 = new HashMap();
        
       
puproperties2.put("javax.persistence.sql-load-script-source", "scripts/dbdropAndCreatre.sql"); 

//           puproperties.put("javax.persistence.sql-load-script-source", "oneTimeSetupCa2.sql");
      
puproperties2.put("javax.persistence.sql-load-script-source", "scripts/cityinfoscript.sql");
  Persistence.generateSchema("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU", puproperties2);
        puproperties2.remove("scripts/cityinfoscript.sql");
         puproperties2.remove("scripts/dbdropAndCreatre.sql");
      
         
       
//         
//       EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
//
//        EntityManager em = emf.createEntityManager();
//        TestDataGenerator tdg = new TestDataGenerator();
//
//        em.getTransaction().begin();
//
//        tdg.createTestAddresses(em);
//
//        tdg.createTestPersons(em);
////        tdg.addHobbies(em);
//        tdg.createTestCompanies(em);
//        tdg.createPhones(em);
////        tdg.createHobbies(em);
//////System.out.println(tdg.getCityInfo(em));
////tdg.addHobbies(em);
////System.out.println(tdg.getHobbies(em));
//        em.getTransaction().commit();
//        em.close();
//     
    }
}
