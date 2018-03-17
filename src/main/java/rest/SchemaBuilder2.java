/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ejer
 */
public class SchemaBuilder2 {

    public static void main(String[] args) throws InterruptedException {

        HashMap puproperties3 = new HashMap();

        

           puproperties3.put("javax.persistence.sql-load-script-source", "oneTimeSetupCa2.sql");
           puproperties3.put("javax.persistence.sql-load-script-source", "scripts/populate_fixed.sql");
        Persistence.generateSchema("Test_CourseAssignment2_war_1.0-SNAPSHOTPU", puproperties3);
        puproperties3.remove("scripts/oneTimeSetupCa2.sql");
        puproperties3.remove("scripts/dbdropAndCreatre.sql");

//        TestDataGenerator.fillTables();

    }

}
