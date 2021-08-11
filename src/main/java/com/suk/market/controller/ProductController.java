package com.suk.market.controller;

import com.suk.market.domain.Product;
import com.suk.market.dto.ProductDTO;
import com.suk.market.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    //returns all the products registered to the database
    @GetMapping
    public Iterable<Product> findAllProduct(){
        return productService.findAllProduct();
    }

    //returns all the products that are registered under the given category
    @GetMapping("/category/{id}")
    public List<Product> findAllProductByCategory(@PathVariable long id){
        return productService.findAllProductByCategory(id);
    }

    //returns all the products that are registered under the given category
    @GetMapping("/cart/{id}")
    public List<Product> findAllProductInCart(@PathVariable long id){
        return productService.findAllProductInCart(id);
    }

    @GetMapping("/{id}")
    public Optional<Product> findProductById(@PathVariable("id") long id){
        return productService.findProductById(id);
    }

    @PostMapping
    public void save(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductDescription(productDTO.getProductDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        productService.save(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductDescription(productDTO.getProductDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") long id){
        productService.deleteById(id);
    }
}