
package rest;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {
    
    /**
     * ApplicationConfig is the main java class that represents all resources api's.
     * You run it by naviagting to the application path in yo url.
     * You can further run the given resource by navigating further to the given resource.
     *
     * @return resources
     */

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ExceptionHandling.PersonNotFoundExceptionMapper.class);
        resources.add(rest.CompanyResource.class);
        resources.add(rest.PersonsResource.class);
    }
    
}
