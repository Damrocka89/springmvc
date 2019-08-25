package pl.sda.springmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Column(unique = true)
    private String login;
    private String email;
    private String password;

    @ManyToMany
    private Set<RoleEntity> roles=new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders = new ArrayList<>();
}
