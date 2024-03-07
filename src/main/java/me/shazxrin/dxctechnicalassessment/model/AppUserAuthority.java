package me.shazxrin.dxctechnicalassessment.model;

public enum AppUserAuthority {
    ROLE_USER("User"), ROLE_MANAGER("Manager");

    private final String roleName;

    AppUserAuthority(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
