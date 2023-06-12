package homework_12.homework_filmlibrary;

import org.springframework.stereotype.Repository;
import ru.sbercourse.filmlibrary.model.User;

@Repository
public interface UserRepository extends GenericRepository<User> {
    User findUserByLogin(String login);

    User findUserByEmail(String email);

    User getByChangePasswordToken(String uuid);
}
