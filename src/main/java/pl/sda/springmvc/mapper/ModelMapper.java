package pl.sda.springmvc.mapper;

import pl.sda.springmvc.dto.ProductDTO;
import pl.sda.springmvc.entities.ProductEntity;

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
}
