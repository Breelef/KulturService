package emil.kulturservice.Repository;

import emil.kulturservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    List<User> findByName(String name);

}
