package emil.kulturservice.Service;

import emil.kulturservice.Model.Band;

import java.util.List;

public interface BandInterfaceService extends CrudInterfaceService<Band, Long>{
    List<Band> findBandByName(String name);
}
