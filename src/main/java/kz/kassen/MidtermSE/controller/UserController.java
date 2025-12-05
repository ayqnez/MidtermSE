package kz.kassen.MidtermSE.controller;

import kz.kassen.MidtermSE.entity.User;
import kz.kassen.MidtermSE.service.MyUserService;
import kz.kassen.MidtermSE.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final MyUserService myUserService;
    private final ProductServiceImpl productService;

    @PostMapping("/register")
    public void register(@RequestBody User model){
        myUserService.register(model);
    }

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}
