package me.shazxrin.dxctechnicalassessment.service;

import me.shazxrin.dxctechnicalassessment.model.AppUserDetails;
import me.shazxrin.dxctechnicalassessment.model.AppUser;
import me.shazxrin.dxctechnicalassessment.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.getByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("Username not found!");
        }

        return new AppUserDetails(appUser);
    }
}
