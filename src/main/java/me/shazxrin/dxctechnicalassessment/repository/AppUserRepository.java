package me.shazxrin.dxctechnicalassessment.repository;

import me.shazxrin.dxctechnicalassessment.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AppUserRepository extends CrudRepository<AppUser, UUID> {
    AppUser getByUsername(String username);

    boolean existsByUsername(String username);
}
