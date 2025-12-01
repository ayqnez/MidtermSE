package kz.kassen.MidtermSE.service;

import kz.kassen.MidtermSE.entity.Permission;
import kz.kassen.MidtermSE.entity.User;
import kz.kassen.MidtermSE.repo.PermissionRep;
import kz.kassen.MidtermSE.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRep permissionRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if(Objects.nonNull(user)) {
            return user;
        }

        throw new UsernameNotFoundException("User Not Found");
    }

    public void register(User model){
        User check = userRepository.findByEmail(model.getEmail());
        if (check == null){
            model.setPassword(passwordEncoder.encode(model.getPassword()));
            List<Permission> permissions;

            if (model.getEmail().equals("admin@email.com")) {
                permissions = List.of(permissionRep.findByName("ROLE_ADMIN"));
            } else {
                permissions = List.of(permissionRep.findByName("ROLE_USER"));
            }

            model.setPermissions(permissions);
            userRepository.save(model);
        }
    }


}

