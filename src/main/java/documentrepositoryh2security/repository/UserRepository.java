package documentrepositoryh2security.repository;

import documentrepositoryh2security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

	List<User> getAllByEnable(Boolean enable);
}
