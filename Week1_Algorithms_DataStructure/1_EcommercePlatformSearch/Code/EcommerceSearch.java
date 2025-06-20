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
            return " Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
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

    static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    static void printTimeComplexity() {
        System.out.println("\n Time Complexity Notes:");
        System.out.println("Linear Search: O(n) - Simple but slower for large data.");
        System.out.println("Binary Search: O(log n) - Fast but requires sorted data.\n");
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shirt", "Clothing"),
            new Product(104, "Shoes", "Footwear"),
            new Product(105, "Book", "Education")
        };

        Scanner scanner = new Scanner(System.in);

        printTimeComplexity();

        System.out.print(" Enter product name to search: ");
        String searchName = scanner.nextLine();

        Product foundLinear = linearSearch(products, searchName);
        System.out.println("\n Linear Search Result:");
        System.out.println(foundLinear != null ? foundLinear : " Product not found.");

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        Product foundBinary = binarySearch(products, searchName);
        System.out.println("\n Binary Search Result:");
        System.out.println(foundBinary != null ? foundBinary : " Product not found.");

        scanner.close();
    }
}