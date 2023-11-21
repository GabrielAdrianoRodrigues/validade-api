package br.com.thr3team.domain.daos;

import br.com.thr3team.domain.models.entities.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserDAO extends DAO<User, Long> {}
