package emil.kulturservice.Repository;

import emil.kulturservice.Model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepo extends JpaRepository<Venue, Long> {
}
