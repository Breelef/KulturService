package emil.kulturservice.Repository;

import emil.kulturservice.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findEventByName(String name);
}
