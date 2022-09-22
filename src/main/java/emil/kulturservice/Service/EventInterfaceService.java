package emil.kulturservice.Service;

import emil.kulturservice.Model.Event;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public interface EventInterfaceService extends CrudInterfaceService<Event, Long>{
    List<Event> findEventByName(String name);
    List<Event> getEventsSorted();
}
