package emil.kulturservice.Service;

import emil.kulturservice.Model.User;

import java.util.List;

public interface UserInterfaceService extends CrudInterfaceService<User, Long>{
    List<User> findByName(String name);
}
