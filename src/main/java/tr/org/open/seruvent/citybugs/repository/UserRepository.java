package tr.org.open.seruvent.citybugs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tr.org.open.seruvent.citybugs.model.User;

/**
 * Burada extend edilen class için bilinmesi gereken en önemli özellik id değerinin type'ı dır.
 * Örn CrudRepository<User, String> extend edilirse id String olarak düşünülmektedir.
 * Ancak CrudRepository<User, int> olarak extend edilirse bu durumda da int id olarak ayarlanılacaktır.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findByEmail(String userEmail);

}
