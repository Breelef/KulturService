package emil.kulturservice.Service;

import emil.kulturservice.Model.Event;
import emil.kulturservice.Repository.EventRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EventService implements EventInterfaceService{
    private EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public Set<Event> findAll() {
        Set<Event> set = new HashSet<>(eventRepo.findAll());
        return set;
    }

    @Override
    public Event save(Event object) {
        return eventRepo.save(object);
    }

    @Override
    public void delete(Event object) {
        eventRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        eventRepo.deleteById(aLong);
    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return eventRepo.findById(aLong);
    }

}
