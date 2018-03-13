
package persistence;

import org.fluttercode.datafactory.impl.DataFactory;

public class TestDataGenerator {
    
    
 public static void main(String[] args) {
     
     
     
        DataFactory df = new DataFactory();
        for (int i = 0; i < 100; i++) {          
            String name = df.getFirstName() + " "+ df.getLastName();
            System.out.println(name);
        }
    }
}