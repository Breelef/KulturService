
package emil.kulturservice.Service;

import emil.kulturservice.Model.Event;
import emil.kulturservice.Model.Review;
import emil.kulturservice.Repository.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReviewService implements ReviewInterfaceService {
    private ReviewRepo reviewRepo;

    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public Set<Review> findAll() {
        Set<Review> set = new HashSet<>(reviewRepo.findAll());
        return set;
    }

    @Override
    public Review save(Review object) {
        return reviewRepo.save(object);
    }

    @Override
    public void delete(Review object) {
        reviewRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        reviewRepo.deleteById(aLong);
    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return reviewRepo.findById(aLong);
    }
}