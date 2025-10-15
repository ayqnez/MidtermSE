package kz.kassen.MidtermSE.service.serviceImpl;

import jakarta.transaction.Transactional;
import kz.kassen.MidtermSE.dto.OrderDTO;
import kz.kassen.MidtermSE.entity.Order;
import kz.kassen.MidtermSE.entity.Product;
import kz.kassen.MidtermSE.entity.User;
import kz.kassen.MidtermSE.mapper.OrderMapper;
import kz.kassen.MidtermSE.repo.OrderRepo;
import kz.kassen.MidtermSE.repo.ProductRepo;
import kz.kassen.MidtermSE.repo.UserRepo;
import kz.kassen.MidtermSE.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderDTO> findAll() {
        return orderMapper.toDtoList(orderRepo.findAll());
    }

    @Override
    public List<OrderDTO> findOrdersByUserId(Long userId) {
        return orderMapper.toDtoList(orderRepo.findOrdersByUserId(userId));
    }

    @Override
    public void createOrderForUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        Order order = new Order();
        order.setUser(user);
        orderRepo.save(order);
    }

    @Override
    public void addProductToOrder(Long orderId, Long productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        Order order = orderRepo.findById(orderId).orElseThrow();

        order.getProducts().add(product);
        orderRepo.save(order);
    }

    @Override
    public void removeProductFromOrder(Long orderId, Long productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        Order order = orderRepo.findById(orderId).orElseThrow();

        order.getProducts().remove(product);
        orderRepo.save(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Long orderId) {
        orderRepo.delete(orderRepo.findById(orderId).orElseThrow());
    }
}
