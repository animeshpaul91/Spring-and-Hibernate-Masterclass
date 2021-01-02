package academy.learnprogramming.config;

// This Configuraion Class Registers a Dispatcher Servlet in this Application

import academy.learnprogramming.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc // enables Java based configuration for Spring Web MVC
@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class WebConfig implements WebMvcConfigurer {

    // WebMVCconfigurer has callback methods to customize Java based Configuration for Spring Web MVC
    // == constants ==
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX = ".jsp";

    // == Bean Methods ==
    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver(); // this type of view resolver will automatically add JSTLs added on the classpath
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME);
        // register an automated controller for the Home View
        // this will cause the Application to land in the Home Page view (home.jsp) whenever the application gets started
    }
}
