package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.Country;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import com.luv2code.ecommerce.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    /**
     * Override this method to add additional configuration.
     *
     * @param config Main configuration bean.
     * @param cors   CORS configuration.
     * @since 3.4
     */

    @Value("${allowed.origins}") // injecting from properties file
    private String[] allowedOrigins;

    private final EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT};

        // disable HTTP methods for PUT, POST and DELETE
        disableHTTPMethods(Product.class, config, unsupportedActions);
        disableHTTPMethods(ProductCategory.class, config, unsupportedActions);
        disableHTTPMethods(Country.class, config, unsupportedActions);
        disableHTTPMethods(State.class, config, unsupportedActions);

        // call an internal helper method
        exposeIds(config);

        // configure CORS mapping
        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(allowedOrigins);
        // now we can remove @CrossOrigin from JPA Repositories
    }

    private void disableHTTPMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))) // for single item endpoints like ID
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)); // for collection endpoints
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity IDs

        // get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<Class> entityClasses = new ArrayList<>();

        // get the entity types for the entities
        for (EntityType entityType : entities) {
            entityClasses.add(entityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
