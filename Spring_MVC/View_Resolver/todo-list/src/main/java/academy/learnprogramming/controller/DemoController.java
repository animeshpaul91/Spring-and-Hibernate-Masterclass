package academy.learnprogramming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // tells spring that this is a web controller. It is a special type of Component
public class DemoController {

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    // http://localhost:8080/todo-list/welcome
    // prefix + name + suffix uis what view resolver gives
    // /WEB-INF/view/welcome.jsp
    @GetMapping("welcome")
    public String welcome() {
        return "welcome"; // controller will forward request to ViewResolver to render welcome.jsp
        // viewResolver will get request for viewname welcome
    }
}
