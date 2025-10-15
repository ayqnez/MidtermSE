package kz.kassen.MidtermSE.repo;

import kz.kassen.MidtermSE.dto.OrderDTO;
import kz.kassen.MidtermSE.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUserId(Long userId);
}
