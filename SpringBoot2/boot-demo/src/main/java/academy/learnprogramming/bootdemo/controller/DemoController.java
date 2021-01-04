package academy.learnprogramming.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// controller needs to be in same package or subpackage as BootDemoApplication
@Slf4j
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("demo")
    public String demo() {
        log.info("demo method called");
        return "Hello Spring Boot";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {
        log.info("Welcome Method called");
        model.addAttribute("message", "Welcome to Spring Boot");
        return "welcome";
    }
}
