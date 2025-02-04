package spring.app.modules.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.app.modules.security.domain.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM public.users" +
            " WHERE email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
