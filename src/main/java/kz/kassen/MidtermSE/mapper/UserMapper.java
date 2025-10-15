package kz.kassen.MidtermSE.mapper;

import kz.kassen.MidtermSE.dto.UserDTO;
import kz.kassen.MidtermSE.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "nameDTO", source = "name")
    UserDTO toDto(User user);

    @Mapping(target = "name", source = "nameDTO")
    User toEntity(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> users);
}
