package me.shazxrin.dxctechnicalassessment.service;

import me.shazxrin.dxctechnicalassessment.exception.UserExistsException;
import me.shazxrin.dxctechnicalassessment.model.AppUser;
import me.shazxrin.dxctechnicalassessment.model.AppUserAuthority;
import me.shazxrin.dxctechnicalassessment.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String name, String username, String password, AppUserAuthority role) throws UserExistsException {
        String encodedPassword = passwordEncoder.encode(password);

        if (appUserRepository.existsByUsername(username)) {
            throw new UserExistsException();
        }

        appUserRepository.save(new AppUser(null, name, username, encodedPassword, role));
    }
}
