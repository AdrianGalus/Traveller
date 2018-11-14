package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.User;

public interface UserCredentialsRepository extends JpaRepository<User, Long> {

    @Query("SELECT CASE WHEN uc is NULL THEN false ELSE true END " +
            "FROM UserCredentials uc WHERE uc.user.login = :login AND uc.password = :password")
    Boolean loginCorrect(@Param("login") String login, @Param("password") String password);
    User findByLogin(String login);
}
