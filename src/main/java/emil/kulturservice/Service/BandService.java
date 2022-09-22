package emil.kulturservice.Service;

import emil.kulturservice.Model.Band;
import emil.kulturservice.Model.Review;
import emil.kulturservice.Repository.BandRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BandService implements BandInterfaceService{
    private BandRepo bandRepo;

    public BandService(BandRepo bandRepo) {
        this.bandRepo = bandRepo;
    }

    @Override
    public Set<Band> findAll() {
        Set<Band> set = new HashSet<>(bandRepo.findAll());
        return set;
    }

    @Override
    public Band save(Band object) {
        return bandRepo.save(object);
    }

    @Override
    public void delete(Band object) {
        bandRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        bandRepo.deleteById(aLong);
    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return bandRepo.findById(aLong);
    }

    @Override
    public List<Band> findBandByName(String name) {
        return bandRepo.findBandByName(name);
    }
}
