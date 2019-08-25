package pl.sda.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.entities.RoleEntity;
import pl.sda.springmvc.services.ProductService;
import pl.sda.springmvc.services.RoleService;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringmvcApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productService.addProduct(new NewProductDTO().builder().name("bla").price(BigDecimal.valueOf(100)).build());
		productService.addProduct(new NewProductDTO().builder().name("two").price(BigDecimal.valueOf(100)).build());
		productService.addProduct(new NewProductDTO().builder().name("three").price(BigDecimal.valueOf(100)).build());

		roleService.addRole(RoleEntity.builder().name("ADMIN").build());
		roleService.addRole(RoleEntity.builder().name("USER").build());
	}
}
