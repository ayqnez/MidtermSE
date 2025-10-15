package kz.kassen.MidtermSE.controller;

import kz.kassen.MidtermSE.dto.UserDTO;
import kz.kassen.MidtermSE.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping()
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public UserDTO getById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @PostMapping()
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }

    @PutMapping("/edit/{userId}")
    private void editUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        userService.updateUser(userId, userDTO);
    }
}
