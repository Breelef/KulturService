package emil.kulturservice.Repository;

import emil.kulturservice.Model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandRepo extends JpaRepository<Band, Long> {
    List<Band> findBandByName(String name);

}
