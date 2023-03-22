package demo.service;

import demo.model.Product;

import java.util.List;

public interface IProductService {
List<Product> findAll();
void save(Product product);
Product findByid(int id);
void deleteProduct(int id);
}
