package demo.service;

import demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    public static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "banh", 100));
        productList.add(new Product(2, "hoa", 20));
        productList.add(new Product(3, "qua", 50));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findByid(product.getId())!=null){
            int index = productList.indexOf(findByid(product.getId()));
            productList.set(index,product);
        }else {
            productList.add(product);
        }
    }

    @Override
    public Product findByid(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id){
                productList.remove(i);
            }
        }

    }
}
