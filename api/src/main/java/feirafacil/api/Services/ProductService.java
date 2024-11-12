package feirafacil.api.Services;

import feirafacil.api.Domain.Entities.Products.Product;
import feirafacil.api.Repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    //TODO: IMPLEMENTAR NA CRIAÇÃO DO PRODUTO O ID DO DONO DA LOJA
    public Product createProduct(String name, String description, BigDecimal price) {
        Product product = new Product(name, description, price);
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
