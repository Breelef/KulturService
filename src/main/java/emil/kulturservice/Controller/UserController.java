package emil.kulturservice.Controller;

import emil.kulturservice.Model.User;
import emil.kulturservice.Service.UserInterfaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping("/getUserByName")
    public ResponseEntity<List<User>> getUserByName(String name){
        return new ResponseEntity<>(userService.findByName(name), HttpStatus.OK);
    }
}
