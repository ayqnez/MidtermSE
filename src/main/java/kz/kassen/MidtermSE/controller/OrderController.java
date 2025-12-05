package kz.kassen.MidtermSE.controller;

import kz.kassen.MidtermSE.dto.OrderDTO;
import kz.kassen.MidtermSE.entity.User;
import kz.kassen.MidtermSE.service.MyUserService;
import kz.kassen.MidtermSE.service.serviceImpl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;
    private final MyUserService myUserService;

    @GetMapping()
    public List<OrderDTO> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<OrderDTO> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.findOrdersByUserId(userId);
    }

    @GetMapping("/my")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<OrderDTO> getMyOrders(Authentication authentication) {
        String email = authentication.getName();
        User user = (User) myUserService.loadUserByUsername(email);
        return orderService.findOrdersForCurrentUser(user);
    }

    @PostMapping("/{userId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void createOrderForUser(@PathVariable Long userId) {
        orderService.createOrderForUser(userId);
    }

    @PostMapping("/{orderId}/add/{productId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void addProductToOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.addProductToOrder(orderId, productId);
    }

    @PostMapping("/{orderId}/remove/{productId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void removeProductFromOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.removeProductFromOrder(orderId, productId);
    }

    @DeleteMapping("/{orderId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
