package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.model.User;
import io.github.RafaelPichelli.AlemDaTormentaAPI.exception.DuplicatedTupleException;
import io.github.RafaelPichelli.AlemDaTormentaAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getByNomeUsuario(String nomeUsuario) {
        return userRepository.findByNomeUsuario(nomeUsuario);
    }

    @Override
    @Transactional
    public User save(User user) {
        var possibleUser = getByNomeUsuario(user.getNomeUsuario());

        if (possibleUser != null){
            throw new DuplicatedTupleException("Usuário já existe");
        }

        return userRepository.save(user);
    }
}
