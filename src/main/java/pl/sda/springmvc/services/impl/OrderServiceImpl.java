package pl.sda.springmvc.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import pl.sda.springmvc.dto.OrderDTO;
import pl.sda.springmvc.entities.OrderEntity;
import pl.sda.springmvc.entities.ProductEntity;
import pl.sda.springmvc.entities.UserEntity;
import pl.sda.springmvc.exceptions.NotFoundUserException;
import pl.sda.springmvc.mapper.ModelMapper;
import pl.sda.springmvc.repositories.OrderCrudRepository;
import pl.sda.springmvc.repositories.ProductCrudRepository;
import pl.sda.springmvc.repositories.UserCrudRepository;
import pl.sda.springmvc.services.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderCrudRepository orderCrudRepository;
    private final ProductCrudRepository productCrudRepository;
    private final UserCrudRepository userCrudRepository;

    public OrderServiceImpl(OrderCrudRepository orderCrudRepository, ProductCrudRepository productCrudRepository, UserCrudRepository userCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
        this.productCrudRepository = productCrudRepository;
        this.userCrudRepository = userCrudRepository;
    }

    @Transactional
    @Override
    public void placeOrder(String username, List<Long> idProducts) throws NotFoundUserException {
        System.out.println(username);
        Optional<UserEntity> userEntityOptional = userCrudRepository.findByLogin(username);
        OrderEntity orderEntity = new OrderEntity();
        List<ProductEntity> products = idProducts.stream()
                .map(productCrudRepository::getOne)
                .collect(Collectors.toList());
        for (ProductEntity product : products) {
            product.getOrders().add(orderEntity);
            orderEntity.getProducts().add(product);
        }
        orderEntity.setProducts(products);
        UserEntity userEntity = userEntityOptional.orElseThrow(() ->
                new NotFoundUserException("Not found user with login: " + username));
        userEntity.getOrders().add(orderEntity);
        orderEntity.setUser(userEntity);
        orderCrudRepository.save(orderEntity);
    }

    @Override
    public List<OrderDTO> findByUserLogin(String login) {
        return orderCrudRepository.findByUserLogin(login)
                .stream().map(ModelMapper::mapToOrderDto)
                .collect(Collectors.toList());

    }
}
