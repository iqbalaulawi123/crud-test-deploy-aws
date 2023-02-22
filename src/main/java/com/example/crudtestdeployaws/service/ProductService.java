package com.example.crudtestdeployaws.service;

import com.example.crudtestdeployaws.entity.Product;
import com.example.crudtestdeployaws.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product, Long id) {
        Optional<Product> update_product = productRepository.findById(id);
        Product update = update_product.get();
        update.setName(product.getName());
        update.setStock(product.getStock());
        return productRepository.save(update);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
