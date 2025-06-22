package rw.ac.auca.ecommerce.core.product.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import rw.ac.auca.ecommerce.core.customer.Customer;
import rw.ac.auca.ecommerce.core.product.Product;
import rw.ac.auca.ecommerce.core.product.repository.IProductRepository;

import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements IProductService{

    private IProductRepository productRepository;

    @Override
    public Product createProduct(Product theProduct) {
        return productRepository.save(theProduct);
    }

    @Override
    public Product updateProduct(Product theProduct) {
        Product found =findProductByIdAndProductName(theProduct.getId(), theProduct.getProductName());
        if (Objects.nonNull(found)) {

            found.setProductName(theProduct.getProductName());
           found.setPrice(theProduct.getPrice());
           found.setDescription(theProduct.getDescription());
           return productRepository.save(found);
        }
        throw new ObjectNotFoundException(Customer.class, " Product Object Not Found");
    }

    @Override
    public Product deleteProduct(Product theProduct) {
        Product found =findProductByIdAndProductName(theProduct.getId(), theProduct.getProductName());
        if (Objects.nonNull(found)) {
            found.setActive(false);
            return productRepository.save(found);
        }
        throw new ObjectNotFoundException(Customer.class, " Product Not Found");
    }

    @Override
    public Product findProductByIdAndProductName(UUID id, String productName) {
        Product theProduct = productRepository.findProductByIdAndProductName(id, productName)
                .orElseThrow(() -> new ObjectNotFoundException(Product.class, "Product not found"));
        return theProduct;
    }

}
