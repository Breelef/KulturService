package emil.kulturservice.Controller;

import emil.kulturservice.Model.User;
import emil.kulturservice.Service.UserInterfaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserInterfaceService userService;

    public UserController(UserInterfaceService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String msg="";
        if(userService.save(user)!=null){
        msg = "Oprettet bruger: " + user.getName();
    }else{
        msg = "fejl i oprettelse af " + user.getName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
