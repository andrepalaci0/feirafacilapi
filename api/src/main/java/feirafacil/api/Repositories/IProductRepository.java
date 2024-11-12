package feirafacil.api.Repositories;

import feirafacil.api.Domain.Entities.Products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
