package com.example.crudtestdeployaws.controller;

import com.example.crudtestdeployaws.dto.ResponseDTO;
import com.example.crudtestdeployaws.entity.Product;
import com.example.crudtestdeployaws.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    @GetMapping
    public ResponseEntity<ResponseDTO> getAll(){
        List<Product> products = productService.getAll();
        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            ResponseDTO responseDTO = new ResponseDTO(
                    "success",
                    "all products",
                    products
            );
            return ResponseEntity.ok(responseDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable Long id){
        Optional<Product> product = productService.getById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            ResponseDTO responseDTO = new ResponseDTO(
                    "success",
                    "detail product id:"+id,
                    product
            );
            return ResponseEntity.ok(responseDTO);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody Product product){
        Product saved_product =  productService.create(product);

        ResponseDTO responseDTO = new ResponseDTO(
                "success",
                "products created",
                product
        );
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id,@RequestBody Product product){
        Product updated_product = productService.update(product,id);
        ResponseDTO responseDTO = new ResponseDTO(
                "success",
                "products updated",
                updated_product
        );
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id){
        productService.deleteById(id);
        ResponseDTO responseDTO = new ResponseDTO(
                "success",
                "products updated",
                null
        );
        return  ResponseEntity.ok(responseDTO);
    }
}
