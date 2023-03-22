package demo.view;

import demo.config.Config;

public class Main {
    public Main() {
        System.out.println("***************************PRODUCT MANAGE********************************");
        System.out.println("1. Show list product");
        System.out.println("2. Create product");
        System.out.println("3. Update product");
        System.out.println("4. Delete product");
        System.out.println("5. Sort product Up");
        System.out.println("6. Sort product Up");
        System.out.println("7. Sreach product By Name");
        System.out.println("8. Exit. ");
        byte chooseMenu;
        while (true) {
            try {
                chooseMenu = Byte.parseByte(Config.scanner().nextLine());
                break;
            } catch (NumberFormatException Err) {
                System.out.println(Err);
            }
        }
        switch (chooseMenu) {
            case 1:
                ProductView productView = new ProductView();
                productView.showtableProduct();
                break;
            case 2:
                ProductView createNewProduct = new ProductView();
                createNewProduct.createProduct();
                break;
            case 3:
                new ProductView().editProduct();
            case 4:
                ProductView deleteProduct = new ProductView();
                deleteProduct.deleteProduct();
                break;
            case 5:
                new ProductView().sortByPriceUp();
                break;
            case 6:
                new ProductView().sortByPriceDown();
                break;
            case 7:
                new ProductView().searchProduct();
                break;
            case 8:
                System.out.println("Đã thoát chương trình!");
                System.exit(0);
            default:
                System.out.println("Chỉ được nhập từ 1-->7");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
