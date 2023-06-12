package homework_8.homework_filmlibrary;

import org.springframework.stereotype.Repository;
import ru.sbercourse.filmlibrary.model.Film;

@Repository
public interface FilmRepository extends GenericRepository<Film> {
}
