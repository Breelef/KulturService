package emil.kulturservice.Service;

import emil.kulturservice.Model.User;
import emil.kulturservice.Model.Venue;
import emil.kulturservice.Repository.VenueRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class VenueService implements VenueInterfaceService{
    public VenueRepo venueRepo;
    @Override
    public Set<Venue> findAll() {
        return new HashSet<>(venueRepo.findAll());
    }

    @Override
    public Venue save(Venue object) {
        return venueRepo.save(object);
    }

    @Override
    public void delete(Venue object) {
        venueRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        venueRepo.deleteById(aLong);
    }

    @Override
    public Optional<Venue> findById(Long aLong) {
        return venueRepo.findById(aLong);
    }
}
