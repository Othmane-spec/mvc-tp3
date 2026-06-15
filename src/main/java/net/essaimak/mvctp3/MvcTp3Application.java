package net.essaimak.mvctp3;

import net.essaimak.mvctp3.entities.Product;
import net.essaimak.mvctp3.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class MvcTp3Application {

    public static void main(String[] args) {
        SpringApplication.run(MvcTp3Application.class, args);
    }


    @Bean
    public CommandLineRunner start (ProductRepository productRepository) {
        return (args) -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(2000.00)
                    .quantity(100.00)
                    .build());

            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1000.00)
                    .quantity(100.00)
                    .build());

            productRepository.save(Product.builder()
                    .name("Phone")
                    .price(1500.00)
                    .quantity(100.00)
                    .build());

            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });

        };
    }

}
