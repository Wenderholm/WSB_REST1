package wsb.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@RestController
public class MyRestController {

    private final Logger log = LoggerFactory.getLogger(MyRestController.class);

    static final Map<String, String> tokens = new HashMap<>();

    @GetMapping("/languages")
    List<String> languages() {
        return new LinkedList<>(Arrays.asList("pl", "en", "de", "fr", "es", "it"));
    }

    @GetMapping("/auth")
    String authMethod() {
        return "Bearer";
    }

    @PostMapping("/auth")
    String auth(@RequestParam(defaultValue = "") String name, HttpServletResponse response) {
        if (name.equals("")) {
            response.setStatus(422);
            return "Wymagane jest podanie swoje imienia w ciele żądania! Dodaj pole o nazwie name, a w wartości podaj swoje imię (x-www-form-urlencoded)";
        }

        String token = Base64.getEncoder().encodeToString(name.getBytes());
        tokens.put(token, name);

        log.info("Użytkownik " + name + " zalogował się!");

        return token;
    }

    @GetMapping("/logged")
    List<String> logged() {
        return (List<String>) tokens.values();
    }

    @GetMapping("/restrictedAccess")
    String restrictedAccess(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader("authorization");

        if (authHeader == null) {
            response.setStatus(401);
            return "Błędne dane autoryzacyjne!";
        }

        String method = authHeader.split(" ")[0];
        String token = authHeader.split(" ")[1];

        if (!method.equals("Bearer") || !tokens.containsKey(token)) {
            response.setStatus(401);
            return "Błędne dane autoryzacyjne!";
        }

        String name = tokens.get(token);
        return "Dobra robota, " + name + "!";
    }

    @GetMapping("final")
    String finalMethod(HttpServletResponse response) {
        response.setStatus(302);
        response.setHeader("Location", "https://www.youtube.com/watch?v=WNnzw90vxrE");
        return "OK";
    }

}
