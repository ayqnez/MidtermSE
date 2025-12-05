package kz.kassen.MidtermSE.controller;

import kz.kassen.MidtermSE.entity.Permission;
import kz.kassen.MidtermSE.repo.PermissionRep;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionRep permissionRep;

    @GetMapping("/all")
    public List<Permission> getAll() {
        return permissionRep.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Permission permission) {
        permissionRep.save(permission);
    }
}
