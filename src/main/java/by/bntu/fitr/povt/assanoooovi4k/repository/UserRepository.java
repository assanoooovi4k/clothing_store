package by.bntu.fitr.povt.assanoooovi4k.repository;

import by.bntu.fitr.povt.assanoooovi4k.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
