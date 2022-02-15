package com.nocountry.grupo10.Mapper;

import com.nocountry.grupo10.DTO.UserDTO;
import com.nocountry.grupo10.model.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserEntity UserDTO2Entity(UserDTO dto){

        UserEntity user = new UserEntity();

        return user;
    }

    public UserDTO UserEntityDTO2Entity(UserEntity entities){

        UserDTO dto = new UserDTO();

        return dto;
    }

    public List<UserDTO> UserEntityList2DTOList (List<UserDTO> entities){

        List<UserDTO> dtos = new ArrayList<>();
        for (UserEntity user: entities){
            dtos.add(this.UserDTO2Entity(user);
        }
        return dtos;
    }
}
