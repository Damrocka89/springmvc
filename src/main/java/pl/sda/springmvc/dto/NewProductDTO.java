package pl.sda.springmvc.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewProductDTO {

    private String name;
    private BigDecimal price;
}
