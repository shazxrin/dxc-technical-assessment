package me.shazxrin.dxctechnicalassessment.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AppUserAuthority authority;

    public AppUser() { }

    public AppUser(UUID id, String name, String username, String password, AppUserAuthority authority) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public UUID getId() {
        return id;
    }

    public String getName() { return name; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public AppUserAuthority getAuthority() {
        return authority;
    }
}
