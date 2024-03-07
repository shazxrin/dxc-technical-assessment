package me.shazxrin.dxctechnicalassessment.dto;

import jakarta.validation.constraints.Size;
import me.shazxrin.dxctechnicalassessment.model.AppUserAuthority;

public class RegisterAppUserDto {
    @Size(min = 3, message = "{auth.register.error-name-invalid}")
    private String name;

    @Size(min = 3, message = "{auth.register.error-username-invalid}")
    private String username;

    @Size(min = 3, message = "{auth.register.error-password-invalid}")
    private String password;

    private AppUserAuthority appUserAuthority;

    public RegisterAppUserDto() { }

    public RegisterAppUserDto(String name, String username, String password, AppUserAuthority appUserAuthority) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.appUserAuthority = appUserAuthority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserAuthority getAppUserAuthority() {
        return appUserAuthority;
    }

    public void setAppUserAuthority(AppUserAuthority appUserAuthority) {
        this.appUserAuthority = appUserAuthority;
    }
}
