package kz.kassen.MidtermSE.controller;

import kz.kassen.MidtermSE.dto.OrderDTO;
import kz.kassen.MidtermSE.service.serviceImpl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;

    @GetMapping()
    public List<OrderDTO> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/{userId}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.findOrdersByUserId(userId);
    }

    @PostMapping("/{userId}")
    public void createOrderForUser(@PathVariable Long userId) {
        orderService.createOrderForUser(userId);
    }

    @PostMapping("/{orderId}/add/{productId}")
    public void addProductToOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.addProductToOrder(orderId, productId);
    }

    @PostMapping("/{orderId}/remove/{productId}")
    public void removeProductFromOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.removeProductFromOrder(orderId, productId);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
