package emil.kulturservice.Controller;

import emil.kulturservice.Model.User;
import emil.kulturservice.Model.Venue;
import emil.kulturservice.Service.UserInterfaceService;
import emil.kulturservice.Service.VenueInterfaceService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@RestController
public class UserController {
    private UserInterfaceService userService;
    private VenueInterfaceService venueService;



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
    @PostMapping("/createLike")
    public ResponseEntity<String> createLike(@RequestParam Long userID, @RequestParam Long venueID){
        Optional<User> user_ = userService.findById(userID);
        Optional<Venue> venue_ = venueService.findById(userID);
        if(user_.isPresent() && venue_.isPresent()){
            user_.get().getVenuesLiked().add(venue_.get());
            userService.save(user_.get());
            return new ResponseEntity<>("ok at gamme user: " + userID + "med like venue" + venueID, HttpStatus.OK);
        }
        return new ResponseEntity<>("fejl at oprette like", HttpStatus.BAD_REQUEST);

    }
}
