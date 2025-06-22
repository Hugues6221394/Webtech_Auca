package rw.ac.auca.ecommerce.core.product.service;

import rw.ac.auca.ecommerce.core.product.Product;

import java.util.UUID;

public interface IProductService {
    Product createProduct(Product theProduct);
    Product updateProduct(Product theProduct);
    Product deleteProduct(Product theProduct);
    Product findProductByIdAndProductName(UUID id, String productName);
}
