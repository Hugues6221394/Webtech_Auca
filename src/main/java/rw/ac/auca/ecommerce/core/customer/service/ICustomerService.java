package rw.ac.auca.ecommerce.core.customer.service;

import rw.ac.auca.ecommerce.core.customer.Customer;

import java.util.Optional;
import java.util.UUID;

public interface ICustomerService {
    // method signature or definition

    Customer registerCustomer(Customer theCustomer);

    Customer updateCustomer(Customer theCustomer);

    Customer deleteCustomer(Customer theCustomer);

    Customer findCustomerByIdAndState(UUID id, Boolean state);

    Customer findCustomerByEmailAndState(String email, Boolean state);

    Optional<Customer> findCustomerByState(Boolean state);

}
