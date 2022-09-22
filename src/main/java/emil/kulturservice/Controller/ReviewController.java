
package emil.kulturservice.Controller;

import emil.kulturservice.Model.Band;
import emil.kulturservice.Model.Event;
import emil.kulturservice.Model.Review;
import emil.kulturservice.Model.User;
import emil.kulturservice.Service.EventInterfaceService;
import emil.kulturservice.Service.ReviewInterfaceService;
import emil.kulturservice.Service.UserInterfaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReviewController {
    private ReviewInterfaceService reviewService;
    private EventInterfaceService eventService;
    private UserInterfaceService userService;

    public ReviewController(ReviewInterfaceService reviewService, EventInterfaceService eventService, UserInterfaceService userService) {
        this.reviewService = reviewService;
        this.eventService = eventService;
        this.userService = userService;
    }
    @PostMapping("/createReview")
    public ResponseEntity<String> createReview(@RequestBody Review review, @RequestParam Long eventID, @RequestParam Long userID){
        Optional<Event> event = eventService.findById(eventID);
        Optional<User> user = userService.findById(userID);

        if(event.isPresent() && user.isPresent()){
            review.setEvent(event.get());
            review.setUser(user.get());
            reviewService.save(review);

            return new ResponseEntity<>("Event oprettet", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("band ikke fundet", HttpStatus.OK);
        }
    }
}
