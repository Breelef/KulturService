package emil.kulturservice.Controller;

import emil.kulturservice.Model.Band;
import emil.kulturservice.Model.User;
import emil.kulturservice.Service.BandInterfaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BandController {
    private BandInterfaceService bandService;

    public BandController(BandInterfaceService bandService) {
        this.bandService = bandService;
    }
    @PostMapping("/createBand")
    public ResponseEntity<String> createBand(@RequestBody Band band){
        String msg="";
        if(bandService.save(band)!=null){
            msg = "Oprettet bruger: " + band.getName();
        }else{
            msg = "fejl i oprettelse af " + band.getName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/getBandByName")
    public ResponseEntity<List<Band>> getBandByName(String name){
        return new ResponseEntity<>(bandService.findBandByName(name), HttpStatus.OK);
    }
}
