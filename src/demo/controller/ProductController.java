package demo.controller;

import demo.model.Product;
import demo.service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    ProductServiceIMPL productService = new ProductServiceIMPL();

    public List<Product> showListProduct() {
        return productService.findAll();
    }
    public void createProduct(Product product) {
        productService.save(product);
    }
    public void deleteProduct(int id){
        productService.deleteProduct(id);
    }

}
