package moviePlatform.DAO;

import moviePlatform.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends CrudRepository<User,Integer> {

    User findById(int id);
    List<User> findAll();
    User findByUsername(String username);
    void deleteById(int id);

}