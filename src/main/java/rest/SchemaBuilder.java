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

        HashMap puproperties2 = new HashMap();
        puproperties2.put("javax.persistence.sql-load-script-source", "scripts/dbdropAndCreatre.sql");
        Persistence.generateSchema("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU", puproperties2);

        puproperties2 = new HashMap();
        
        puproperties2.put("javax.persistence.sql-load-script-source", "scripts/cityinfoscript.sql");
        Persistence.generateSchema("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU", puproperties2);
        puproperties2.remove("scripts/cityinfoscript.sql");
        puproperties2.remove("scripts/dbdropAndCreatre.sql");

        TestDataGenerator.fillTables();

    }

}
