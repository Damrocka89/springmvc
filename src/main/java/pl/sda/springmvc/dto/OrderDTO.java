package pl.sda.springmvc.dto;

import lombok.Builder;
import lombok.Data;
import pl.sda.springmvc.entities.ProductEntity;
import pl.sda.springmvc.entities.UserEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
public class OrderDTO {

    private Long id;

    private LocalDateTime creationTime;

    private UserEntity user;

    private List<ProductDTO> products = new ArrayList<>();
}
