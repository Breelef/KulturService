package emil.kulturservice.Repository;

import emil.kulturservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
