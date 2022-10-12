package baiTap1;

import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private String descriptions;
    private int quantity;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productID, String productName, String descriptions, int quantity, float importPrice, float exportPrice, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.descriptions = descriptions;
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputProduct(Scanner scanner) {
        System.out.println("Enter Product ID: ");
        do {
            String inputProductID = scanner.nextLine();
            if (inputProductID != "" && inputProductID.trim().length() != 0){
                this.productID = inputProductID;
                break;
            } else {
                System.err.println("Please try again!");
            }
        } while (true);
        System.out.println("Enter Product Name: ");
        do {
            String inputProductName = scanner.nextLine();
            if (inputProductName!="" && inputProductName.trim().length()!=0){
                this.productName = inputProductName;
                break;
            } else {
                System.err.println("Please try again");
            }
        } while (true);
        System.out.println("Enter Product Descriptions: ");
        do {
            String inputDescriptions = scanner.nextLine();
            if (inputDescriptions!="" && inputDescriptions.trim().length()!=0){
                this.descriptions = inputDescriptions;
                break;
            } else {
                System.err.println("Please try again");
            }
        } while (true);
        System.out.println("Enter Product Quantity: ");
        do {
            int productQuantity = Integer.parseInt(scanner.nextLine());
            if (productQuantity>=0) {
                this.quantity = productQuantity;
                break;
            } else {
                System.err.println("Please try again");
            }
        } while (true);
        System.out.println("Enter Product ImportPrice: ");
        do {
            float inputImportPrice = Float.parseFloat(scanner.nextLine());
            if (inputImportPrice>=0) {
                this.importPrice = inputImportPrice;
                break;
            } else {
                System.err.println("Please try again");
            }
        } while (true);
        System.out.println("Enter Product Status");
        do {
            String productStatus = scanner.nextLine();
            if (productStatus!="" && productStatus.trim().length()!=0) {
                this.productStatus = Boolean.parseBoolean(productStatus);
                break;
            } else {
                System.err.println("Please try again");
            }
        } while (true);
    }

    public void displayProduct() {
        System.out.printf("%-15s%-20s%-30s%-15d%-15f%-15f%-20b\n",this.productID,this.productName,this.descriptions,this.quantity,this.importPrice,this.exportPrice,this.productStatus);
    }

    public void calExportPrice() {
        this.exportPrice = this.importPrice*1.2F;
    }
}
