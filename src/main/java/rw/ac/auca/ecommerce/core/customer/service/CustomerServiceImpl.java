package rw.ac.auca.ecommerce.core.customer.service;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import rw.ac.auca.ecommerce.core.customer.Customer;
import rw.ac.auca.ecommerce.core.customer.repository.ICustomerRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository customerRepository;

    //@Autowired
    //public CustomerServiceImpl(ICustomerRepository customerRepository) {
      //  this.customerRepository = customerRepository;
    //}



    @Override
    public Customer registerCustomer(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    @Override
    public Customer updateCustomer(Customer theCustomer) {
       Customer found =findCustomerByIdAndState(theCustomer.getId(), true);
       if (Objects.nonNull(found)) {
           found.setFirstName(theCustomer.getFirstName());
           found.setLastName(theCustomer.getLastName());
           found.setEmail(theCustomer.getEmail());
           found.setPhoneNumber(theCustomer.getPhoneNumber());
           return customerRepository.save(found);
       }
       throw new ObjectNotFoundException(Customer.class, " Customer Object Not Found");
    }

    @Override
    public Customer deleteCustomer(Customer theCustomer) {
        Customer found =findCustomerByIdAndState(theCustomer.getId(), true);
        if (Objects.nonNull(found)) {
            found.setActive(Boolean.FALSE);
            return customerRepository.save(found);
        }
        throw new ObjectNotFoundException(Customer.class, " Customer Object Not Found");
    }


    @Override
    public Customer findCustomerByIdAndState(UUID id, Boolean state) {
       Customer theCustomer = customerRepository.findByIdAndActive(id, state)
               .orElseThrow(() -> new ObjectNotFoundException(Customer.class, " Customer Not Found"));
       return theCustomer;
    }

    @Override
    public Customer findCustomerByEmailAndState(String email, Boolean state) {
        Customer theCustomer = customerRepository.findByEmailAndActive(email, state)
                .orElseThrow(() -> new ObjectNotFoundException(Customer.class, "Customer not found"));
        return theCustomer;
    }

    @Override
    public Optional<Customer> findCustomerByState(Boolean state) {
        return customerRepository.findAllByActive(state);
    }
}
