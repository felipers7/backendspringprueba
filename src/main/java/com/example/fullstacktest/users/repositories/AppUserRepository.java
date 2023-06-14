package com.example.fullstacktest.users.repositories;


import com.example.fullstacktest.users.entities.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<Appuser,Integer> {

    Optional<Appuser> findByUsername(String username);

}
