package academy.learnprogramming.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    /* Complete MVC Request Processing Workflow.
       1. Dispatcher Servlet Identifies which controller will handle the HTTP request using handler Mapping
       2. Handler Mapping returns the specific handler method (hello/welcome) that is supposed to handle the HTTP request
       3. Dispatcher Servlet calls that specific method (hello/welcome) in the controller
       4. Handler Method returns the Model and the view name. The logical view name is welcome (the welcome string returned).
       5. Now the dispatcher servlet has the logical view name (welcome) but it still needs  to determine which view file to use i.e welcome.jsp.
       6. It finds the View Resolver to call it with the logical view name.
       7. View Resolver receives the logical view name. It finds welcome.jsp file in /WEB-INF/ and returns it to the dispatcher servlet.
       8. Dispatcher Servlet executes the file welcome.jsp and makes the model available to the view.
       9. The view is rendered and it returns the content back to the dispatcher servlet.
       10. The dispatcher servlet sends the response back to the browser after which we see the content on the browser.
     */

    public static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("On startup");

        // create spring Application Context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class); // for this to work the WebConfig class should be configured with @Configuration Annotation

        // create the dispatcher servlet that behaves as a front controller
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // register abd configure dispatcher servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
