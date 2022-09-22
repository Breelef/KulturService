package emil.kulturservice.Service;

import emil.kulturservice.Model.Event;
import emil.kulturservice.Repository.EventRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Collections.addAll;

@Service
public class EventService implements EventInterfaceService{
    private EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public Set<Event> findAll() {
        return new HashSet<>(eventRepo.findAll());
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
    public List<Event> getEventsSorted(){
        return new ArrayList<>(eventRepo.findAll(Sort.by(Sort.Direction.ASC, "dateTime")));
    }

    @Override
    public List<Event> findEventByName(String name) {
        return eventRepo.findEventByName(name);
    }
}
