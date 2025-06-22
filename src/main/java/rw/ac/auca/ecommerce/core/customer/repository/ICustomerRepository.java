package rw.ac.auca.ecommerce.core.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rw.ac.auca.ecommerce.core.customer.Customer;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
    @Query("SELECT c from Customer c WHERE c.id=:id and c.active=: active")

    Optional<Customer> findCustomerByIdWithNamedQuerry(@Param("id") UUID id, @Param("active") boolean active);

    Optional<Customer> findByIdAndActive (UUID id, Boolean active);
    Optional<Customer> findCustomerByIdAndState(UUID id, Boolean state);
    Optional<Customer> findByEmailAndActive(String email, Boolean active);
    Optional<Customer> findAllByActive(Boolean active);

}
