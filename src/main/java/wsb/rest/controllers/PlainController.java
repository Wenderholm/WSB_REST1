package wsb.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlainController {

    @GetMapping("/hello")
    String hello() {
        return "hello";
    }

}
