package SBKafkaMicro.springboot_restful_webservices.Repository;

import SBKafkaMicro.springboot_restful_webservices.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
}
