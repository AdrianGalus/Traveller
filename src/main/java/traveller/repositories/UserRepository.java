package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT true FROM UserCredentials uc WHERE uc.user.login = :login AND uc.password = :password")
    Boolean loginCorrect(@Param("login") String login, @Param("password") String password);
    User findByLogin(String login);
}
