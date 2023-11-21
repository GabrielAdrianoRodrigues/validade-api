package br.com.thr3r.domain.daos;

import br.com.thr3r.domain.models.entities.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserDAO extends DAO<User, Long> {}
