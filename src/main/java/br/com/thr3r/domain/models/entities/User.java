package br.com.thr3r.domain.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "thr3r_users")
@AllArgsConstructor@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column(name = "nm_user", nullable = false)
    private String name;

    @Column(name = "email_user", nullable = false)
    private String email;

    @Column(name = "pwd_user")
    private String password;
}
