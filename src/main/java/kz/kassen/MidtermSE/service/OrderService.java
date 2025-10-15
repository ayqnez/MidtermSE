package kz.kassen.MidtermSE.service;

import kz.kassen.MidtermSE.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> findAll();
    List<OrderDTO> findOrdersByUserId(Long userId);
    void createOrderForUser(Long userId);
    void addProductToOrder(Long orderId, Long productId);
    void removeProductFromOrder(Long orderId, Long productId);
    void deleteOrder(Long orderId);
}
