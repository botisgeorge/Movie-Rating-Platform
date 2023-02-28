package moviePlatform.DAO;

import moviePlatform.Entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,Integer> {
    Movie findByName(String name);
}
