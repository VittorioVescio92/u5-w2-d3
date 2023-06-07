package VittorioVescio.u5w2d3.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import VittorioVescio.u5w2d3.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
