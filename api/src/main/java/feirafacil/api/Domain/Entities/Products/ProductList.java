package feirafacil.api.Domain.Entities.Products;

import lombok.Getter;

import java.util.List;

public class ProductList {

    @Getter
    private List<Product> products;
    int quantity;

    public ProductList(List<Product> products, int quantity) {
        this.products = products;
        this.quantity = products.size();
    }

    public void AddProduct(Product product){
        products.add(product);
        quantity++;
    }


    public void AddProducts(List<Product> products){
        this.products.addAll(products);
        quantity += products.size();
    }

    public void RemoveProduct(Product product){
        products.remove(product);
        quantity--;
    }

    public void RemoveProducts(List<Product> products){
        this.products.removeAll(products);
        quantity -= products.size();
    }

}
