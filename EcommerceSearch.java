import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EcommerceSearch {
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    static Product binarySearch(Product[] products, String name){
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(name);

            if (compare == 0) {
                return products[mid];
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shirt", "Clothing"),
            new Product(104, "Shoes", "Footwear"),
            new Product(105, "Book", "Education")
        };

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter product name to search:");
            String inputName = scanner.nextLine();

            // Linear Search
            Product linearResult = linearSearch(products, inputName);
            System.out.println("\nLinear Search Result:");
            if (linearResult != null) {
                System.out.println(linearResult);
            } else {
                System.out.println("Product not found.");
            }

            // Sort for Binary Search
            Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

            // Binary Search
            Product binaryResult = binarySearch(products, inputName);
            System.out.println("\nBinary Search Result:");
            if (binaryResult != null) {
                System.out.println(binaryResult);
            } else {
                System.out.println("Product not found.");
            }
        }
    }
}
