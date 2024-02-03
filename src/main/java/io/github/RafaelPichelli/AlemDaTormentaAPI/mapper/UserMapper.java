package io.github.RafaelPichelli.AlemDaTormentaAPI.mapper;

import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.UserDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserDto dto){
        return new User().builder()
                .nomeUsuario(dto.getNomeUsuario())
                .senha(dto.getSenha())
                .build();
    }

}
