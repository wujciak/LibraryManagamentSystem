package edu.ib.technologiesieciowe.model;

import edu.ib.technologiesieciowe.enumType.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "auth", schema = "librarydb")
public class Auth {
    @Id
    @Column(name = "auth_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authId;

    @Basic
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Auth() {
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
