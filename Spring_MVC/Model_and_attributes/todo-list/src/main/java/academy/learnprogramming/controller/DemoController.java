package academy.learnprogramming.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller // tells spring that this is a web controller. It is a special type of Component
public class DemoController {

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    // http://localhost:8080/todo-list/welcome
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("user", "Animesh Paul"); // add a key value pair to a model
        log.info("Model = {}", model);

        // prefix + name + suffix uis what view resolver gives
        // /WEB-INF/view/welcome.jsp
        return "welcome"; // controller will forward request to ViewResolver to render welcome.jsp
        // viewResolver will get request for viewname welcome
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return "Welcome to this Demo Application.";
    }
}
