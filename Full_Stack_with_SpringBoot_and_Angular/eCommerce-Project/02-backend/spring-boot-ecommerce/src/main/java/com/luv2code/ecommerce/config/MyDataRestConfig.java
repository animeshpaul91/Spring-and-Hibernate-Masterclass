package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    /**
     * Override this method to add additional configuration.
     *
     * @param config Main configuration bean.
     * @param cors   CORS configuration.
     * @since 3.4
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT};

        // disable HTTP methods for PUT, POST and DELETE

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))) // for single item endpoints like ID
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)); // for collection endpoints

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))) // for single item endpoints like ID
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)); // for collection endpoints
    }
}
