package finalProject.controller;
import finalProject.models.AuthenticationMessage;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/")
public class AuthenticationController {


    @GetMapping(path = "/basicauth")
    public AuthenticationMessage authenticationMessage() {
        return new AuthenticationMessage(String.format("Welcome!You are authenticated!"));
    }



}

