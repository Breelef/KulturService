package emil.kulturservice.Repository;

import emil.kulturservice.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
