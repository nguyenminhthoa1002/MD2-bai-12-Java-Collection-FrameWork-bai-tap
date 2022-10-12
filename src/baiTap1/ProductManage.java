package baiTap1;

import java.util.*;

public class ProductManage {
    static List<Product> listProduct = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo ID");
            System.out.println("3. Xoá sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("8. Thoát");
            System.out.println("Your choice is: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                    removeProduct(scanner);
                    break;
                case 4:
                    displayProductManage();
                    break;
                case 5:
                    searchByName(scanner);
                    break;
                case 6:
                    sortProductACS();
                    break;
                case 7:
                    sortProductDES();
                    break;
                case 8:
                    scanner.close();
                    System.exit(0);
                default:
                    System.err.println("Please choose 1-8");
            }
        } while (true);
    }

    public static void addNewProduct(Scanner scanner) {
        System.out.println("Enter the number Product you want to input: ");
        int inputNewProductNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputNewProductNumber; i++) {
            Product product = new Product();
            product.inputProduct(scanner);
            listProduct.add(product);
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Enter Product ID to Update Product: ");
        String updateProduct = scanner.nextLine();
        boolean checkUpdate = false;
        for (Product listProduct : listProduct) {
            if (listProduct.getProductID().equals(updateProduct)) {
                System.out.println("Enter Update Product Name: ");
                String updateName = scanner.nextLine();
                if (updateName != "" && updateName.trim().length() != 0) {
                    listProduct.setProductName(updateName);
                }
                System.out.println("Enter Update Product Descriptions");
                String updateDescriptions = scanner.nextLine();
                if (updateDescriptions != "" && updateDescriptions.trim().length() != 0) {
                    listProduct.setDescriptions(updateDescriptions);
                }
                System.out.println("Enter Update Quantity");
                String updateQuantity = scanner.nextLine();
                if (updateQuantity != "" && updateQuantity.trim().length() != 0) {
                    if (Integer.parseInt(updateQuantity) != listProduct.getQuantity()) {
                        listProduct.setQuantity(Integer.parseInt(updateQuantity));
                    }
                }
                System.out.println("Enter Update Import Price");
                String updateImportPrice = scanner.nextLine();
                if (updateImportPrice != "" && updateImportPrice.trim().length() != 0) {
                    if (Float.parseFloat(scanner.nextLine()) != listProduct.getImportPrice()) {
                        listProduct.setImportPrice(Float.parseFloat(updateImportPrice));
                    }
                }
                listProduct.calExportPrice();
                System.out.println("Enter Update Product Status");
                String updateStatus = scanner.nextLine();
                if (updateStatus != "" && updateStatus.trim().length() != 0) {
                    listProduct.setProductStatus(Boolean.parseBoolean(updateStatus));
                }
                checkUpdate = true;
            } else {
                checkUpdate = false;
            }
        }
        if (!checkUpdate) {
            System.err.println("This Product doesn't exist");
        }
    }

    public static void removeProduct(Scanner scanner) {
        System.out.println("Enter Product ID to Remove Product: ");
        String removeProduct = scanner.nextLine();
        int indexProduct = -1;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductID().equals(removeProduct)) {
                indexProduct = i;
            }
        }
        if (indexProduct != -1) {
            listProduct.remove(listProduct.get(indexProduct));
        }
    }

    public static void displayProductManage() {
        System.out.println("********************** Product Information**************");
        System.out.printf("%-15s%-20s%-30s%-15s%-15s%-15s%-20s\n", "Product ID", "Product Name", "Descriptions", "Quantity", "Import Price", "Export Price", "Product Status");
        for (Product listProduct : listProduct) {
            listProduct.calExportPrice();
            listProduct.displayProduct();
        }
    }

    public static void searchByName(Scanner scanner) {
        System.out.println("Enter Product Name to Search: ");
        String inputSearch = scanner.nextLine();
        System.out.println("********************** Product Information**************");
        System.out.printf("%-15s%-20s%-30s%-15s%-15s%-15s%-20s\n", "Product ID", "Product Name", "Descriptions", "Quantity", "Import Price", "Export Price", "Product Status");
        for (Product listProduct : listProduct) {
            if (listProduct.getProductName().contains(inputSearch)) {
                listProduct.displayProduct();
            }
        }
    }

    public static void sortProductACS() {
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return (int) product1.getExportPrice() - (int) product2.getExportPrice();
            }
        });
    }

    public static void sortProductDES() {
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return -((int) product1.getExportPrice() - (int) product2.getExportPrice());
            }
        });
    }
}
