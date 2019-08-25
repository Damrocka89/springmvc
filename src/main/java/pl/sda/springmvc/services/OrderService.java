package pl.sda.springmvc.services;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.dto.OrderDTO;
import pl.sda.springmvc.entities.OrderEntity;
import pl.sda.springmvc.exceptions.NotFoundUserException;

import java.util.List;

@Service
public interface OrderService {

    void placeOrder(String username, List<Long> idProducts) throws NotFoundUserException;
    List<OrderDTO> findByUserLogin(String login);
}
