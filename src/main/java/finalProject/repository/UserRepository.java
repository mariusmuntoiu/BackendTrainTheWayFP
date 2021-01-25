package finalProject.repository;

import finalProject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
//    @Query("SELECT u FROM User u WHERE u.username = :username")
//    public User getUserByUsername(@Param("username") String username);

    public User findUserByUsername(String username);


}
