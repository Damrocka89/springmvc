package pl.sda.springmvc.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "Order_")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime creationTime = LocalDateTime.now();

    @ManyToOne
    private UserEntity user;



    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<ProductEntity> products = new ArrayList<>();
}
