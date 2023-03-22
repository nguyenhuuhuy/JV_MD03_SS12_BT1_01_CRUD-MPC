package demo.model;

import java.util.Comparator;

public class Product implements Comparator<Product> {
    private int id;
    private String productName;
    private double price;
    private int choiseMenuSearch;

    public int getChoiseMenuSearch(int i) {
        return choiseMenuSearch;
    }

    public void setChoiseMenuSearch(int choiseMenuSearch) {
        this.choiseMenuSearch = choiseMenuSearch;
    }

    public Product() {
    }

    public Product(int id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}' + "\n";
    }


    @Override
    public int compare(Product o1, Product o2) {

        switch (choiseMenuSearch) {
            case 1:
                return (int) (o1.getPrice() - o2.getPrice());
            case 2:
                return (int) (o2.getPrice() - o1.getPrice());
        }
       return 0;
    }
}
