package emil.kulturservice.Controller;

import emil.kulturservice.Model.Band;
import emil.kulturservice.Model.Event;
import emil.kulturservice.Model.User;
import emil.kulturservice.Service.BandInterfaceService;
import emil.kulturservice.Service.EventInterfaceService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    private EventInterfaceService eventService;
    private BandInterfaceService bandService;

    public EventController(EventInterfaceService eventService, BandInterfaceService bandService) {
        this.eventService = eventService;
        this.bandService = bandService;
    }
    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event event, @RequestParam Long bandID){
        Optional<Band> band = bandService.findById(bandID);
        if(band.isPresent()){
            event.setBand(band.get());
            eventService.save(event);

            return new ResponseEntity<>("Event oprettet", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("band ikke fundet", HttpStatus.OK);
        }
    }
    @GetMapping("/getEventByName")
    public ResponseEntity<List<Event>> getEventByName(String name){
        return new ResponseEntity<>(eventService.findEventByName(name), HttpStatus.OK);
    }
    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents(){
        return new ResponseEntity<>(eventService.getEventsSorted(), HttpStatus.OK);
    }
}
