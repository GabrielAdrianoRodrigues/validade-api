package br.com.thr3team.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.thr3team.domain.daos.UserDAO;
import br.com.thr3team.domain.models.dtos.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;

@ApplicationScoped
public class UserService {
    @Inject
    private UserDAO userDAO;

    public List<UserDTO> findAll() {
        return userDAO.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO findById(long id) throws Exception {
        return new UserDTO(userDAO.findById(id).orElseThrow(EntityNotFoundException::new));
    }

}
