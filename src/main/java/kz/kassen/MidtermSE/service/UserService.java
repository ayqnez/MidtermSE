package kz.kassen.MidtermSE.service;

import kz.kassen.MidtermSE.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getById(Long userId);
    void createUser(UserDTO userDTO);
    UserDTO updateUser(Long userId, UserDTO userDTO);
}
