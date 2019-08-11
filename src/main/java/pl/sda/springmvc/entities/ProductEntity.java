package pl.sda.springmvc.entities;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class ProductEntity {

    private Long id;
    private String name;
    private BigDecimal price;
}
