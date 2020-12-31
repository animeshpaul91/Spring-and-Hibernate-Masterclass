package academy.learnprogramming.simpleservice;

import org.springframework.stereotype.Service;

@Service // provides the business service to other components of the application
// Its another stereotyped annotation like @Component and @Controller
public class DemoServiceImpl implements DemoService{
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to the Demo Application";
    }
}
