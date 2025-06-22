package rw.ac.auca.ecommerce.core.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rw.ac.auca.ecommerce.core.customer.Customer;
import rw.ac.auca.ecommerce.core.product.Product;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public interface IProductRepository extends JpaRepository<Product, UUID> {
    @Query("SELECT p from Product p WHERE p.id=:id and p.productName=:productName")

    Optional<Product> findProductByIdAndProductName(@Param("id") UUID id, @Param("product_name") String productName);


}
