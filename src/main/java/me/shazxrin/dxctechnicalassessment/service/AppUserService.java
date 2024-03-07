package me.shazxrin.dxctechnicalassessment.service;

import me.shazxrin.dxctechnicalassessment.exception.UserExistsException;
import me.shazxrin.dxctechnicalassessment.model.AppUserAuthority;

public interface AppUserService {
    void registerUser(String name, String username, String password, AppUserAuthority role) throws UserExistsException;
}
