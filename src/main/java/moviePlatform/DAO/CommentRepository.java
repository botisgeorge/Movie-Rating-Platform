package moviePlatform.DAO;

import moviePlatform.Entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Integer> {
    Comment findBynumeFilm(String numeFilm);
}
