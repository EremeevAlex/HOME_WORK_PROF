package homework_9.homework_filmlibrary;

import org.springframework.stereotype.Repository;
import ru.sbercourse.filmlibrary.model.User;

@Repository
public interface UserRepository extends GenericRepository<User> {
}
