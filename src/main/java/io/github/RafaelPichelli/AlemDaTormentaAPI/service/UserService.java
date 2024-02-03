package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.model.User;

public interface UserService {
    User getByNomeUsuario(String nomeUsuario);

    User save(User user);

}
