package academy.learnprogramming.controller;

import academy.learnprogramming.simpleservice.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller // tells spring that this is a web controller. It is a special type of Component
public class DemoController {

    // == fields ==
    private final DemoService demoService;

    // == constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == request methods ==
    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    // http://localhost:8080/todo-list/welcome
    // http://localhost:8080/todo-list/welcome?user=Animesh
    @GetMapping("welcome")
    public String welcome(Model model, @RequestParam String user, @RequestParam int age) {
        model.addAttribute("hello", demoService.getHelloMessage(user)); // add a key value pair to a model
        model.addAttribute("age", age);
        log.info("Model = {}", model);

        // prefix + name + suffix uis what view resolver gives
        // /WEB-INF/view/welcome.jsp
        return "welcome"; // controller will forward request to ViewResolver to render welcome.jsp
        // viewResolver will get request for viewname welcome
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
