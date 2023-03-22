package demo.view;

import demo.config.Config;
import demo.controller.ProductController;
import demo.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.showListProduct();

    public void showtableProduct() {
        System.out.println("*****************Mennu Product******************************");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("   " + productList.get(i).getId() + " " + productList.get(i).getProductName() + " " + productList.get(i).getPrice());
        }
        System.out.println("Mời nhập (back) để quay trở lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void createProduct() {
//        int id = productController.showListProduct().get(productController.showListProduct().size()-1).getId()+1;
        System.out.println("Nhập tên sản phẩm: ");
        String productName = Config.scanner().nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        Double price = Config.scanner().nextDouble();
        int productId;
        if (productList.isEmpty()) {
            productId = 1;
        } else {
            productId = new ProductView().findMaxId() + 1;
        }
        Product newProduct = new Product(productId, productName, price);
        productController.createProduct(newProduct);
        System.out.println("Mời nhập (back) để quay trở lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }

    }

    public void editProduct() {
        System.out.println("Nhập id sản phẩm cần sửa: ");
        int targetProductId = Integer.parseInt(Config.scanner().nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == targetProductId) {
                System.out.println(productList.get(i).toString());
            }
        }
        System.out.println("Nhập tên mới: ");
        String newName = Config.scanner().nextLine();
        System.out.println("Nhập giá mới: ");
        int newPrice = Config.scanner().nextInt();
        Product newProduct = new Product(targetProductId, newName, newPrice);
        productController.createProduct(newProduct);
        System.out.println("Mời nhập (back) để quay trở lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập id của Product muốn xóa: ");
        int productId = Integer.parseInt(Config.scanner().nextLine());
        productController.deleteProduct(productId);
        System.out.println("Mời nhập (back) để quay trở lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void sortByPriceUp() {
        Product product = new Product();
        product.setChoiseMenuSearch(1);
        Collections.sort(productList,product);
        System.out.println("Mời nhập (back) để quay trở lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }
    public void sortByPriceDown() {
        Product product = new Product();
        product.setChoiseMenuSearch(2);
        Collections.sort(productList,product);
        System.out.println("Mời nhập (back) để quay trở lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void searchProduct() {
        List<Product> searchList = new ArrayList<>();
        System.out.println("Nhập tên sản phẩm muốn tìm kiếm: ");
        String targetProductName = Config.scanner().nextLine();
        for (Product element : productList) {
            if (element.getProductName().contains(targetProductName)){
                searchList.add(element);
            }
        }
        if (searchList.size()==0){
            System.out.println("Không tìm thấy sản phẩm nào trùng tên.");
        }else {
            System.out.println("Sản phẩm tìm thấy là: \n" + searchList);
        }
        System.out.println("Mời nhập (back) để quay trở lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    // hàm thêm id cho sản phẩm mới nhập vào
    public int findMaxId() {
        int maxId = productList.get(0).getId();
        for (int i = 0; i < productList.size(); i++) {
            if (maxId < productList.get(i).getId()) {
                maxId = productList.get(i).getId();
            }
        }
        return maxId;
    }
}
