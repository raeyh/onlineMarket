package com.suk.market.service.product;


import com.suk.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAllProduct();
    Optional<Product> findProductById(long id);
    void save(Product product);
    void updateProduct(Product product);
    void deleteById(long id);
    List<Product> findAllProductByCategory(long categoryId);
    List<Product> findAllProductInCart(long cartId);
}
