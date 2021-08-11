package com.suk.market.controller;

import com.suk.market.domain.Product;
import com.suk.market.domain.Seller;
import com.suk.market.dto.ProductDTO;
import com.suk.market.service.product.ProductService;
import com.suk.market.service.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    SellerService sellerService;
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable long id) {
        return sellerService.getSellerById(id);
    }

    @PostMapping("/{id}/products")

    public void addProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductDescription(productDTO.getProductDescription());
        product.setPrice(productDTO.getPrice());
        product.setReviews(null);
        sellerService.addProduct(product, id);
    }

    @PatchMapping("/{id}/approve")
    public Seller approve(@PathVariable long id) {
        return sellerService.approveSeller(id);
    }


    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable long id) {
        sellerService.deleteSeller(id);
    }


    @GetMapping("/{id}/products")
    public Set<Product> getProducts(@PathVariable long id) {
        return sellerService.findProducts(id);
    }

}
