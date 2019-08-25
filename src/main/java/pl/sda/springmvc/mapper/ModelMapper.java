package pl.sda.springmvc.mapper;

import pl.sda.springmvc.dto.OrderDTO;
import pl.sda.springmvc.dto.ProductDTO;
import pl.sda.springmvc.entities.OrderEntity;
import pl.sda.springmvc.entities.ProductEntity;

import java.util.stream.Collectors;

public class ModelMapper {

    public static ProductEntity mapToProductEntity(ProductDTO productDTO) {
        return ProductEntity.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .build();
    }

    public static ProductDTO mapToProductDTO(ProductEntity productEntity) {
        return ProductDTO.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();
    }

    public static OrderDTO mapToOrderDto(OrderEntity orderEntity) {
        return OrderDTO.builder()
                .id(orderEntity.getId())
                .creationTime(orderEntity.getCreationTime())
                .products(orderEntity.getProducts()
                        .stream()
                        .map(ModelMapper::mapToProductDTO)
                        .collect(Collectors.toList()))
                .user(orderEntity.getUser())
                .build();
    }


}
