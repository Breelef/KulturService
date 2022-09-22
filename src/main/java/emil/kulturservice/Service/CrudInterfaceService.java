package emil.kulturservice.Service;

import java.util.Optional;
import java.util.Set;

public interface CrudInterfaceService<T,ID> {

    Set<T> findAll();
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
    Optional<T> findById(ID id);

}
