package net.essaimak.mvctp3.repository;

import net.essaimak.mvctp3.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> id(Long id);
}
