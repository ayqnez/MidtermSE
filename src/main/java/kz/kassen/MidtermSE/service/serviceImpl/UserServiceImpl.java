package kz.kassen.MidtermSE.service.serviceImpl;

import kz.kassen.MidtermSE.dto.UserDTO;
import kz.kassen.MidtermSE.entity.User;
import kz.kassen.MidtermSE.mapper.UserMapper;
import kz.kassen.MidtermSE.repo.UserRepo;
import kz.kassen.MidtermSE.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAll() {
        return userMapper.toDtoList(userRepo.findAll());
    }

    @Override
    public UserDTO getById(Long userId) {
        return userMapper.toDto(userRepo.findById(userId).orElseThrow());
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userRepo.save(userMapper.toEntity(userDTO));
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = userRepo.findById(userId).orElseThrow();
        User newUser = userMapper.toEntity(userDTO);

        user.setName(newUser.getName());
        userRepo.save(user);
        return userMapper.toDto(newUser);
    }
}
