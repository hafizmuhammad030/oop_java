import java.util.*;

class Product {
    String id;
    String name;
    double price;
    double weight;
    String category;

    public Product(String id, String name, double price, double weight, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.category = category;
    }

    public String toString() {
        return "[" + id + " - " + name + ", $" + price + ", " + weight + "kg, " + category + "]";
    }
}

class Inventory {

    HashMap<String, Product> productMap = new HashMap<>();
    HashMap<String, ArrayList<Product>> categoryMap = new HashMap<>();

    public void addProduct(Product p) {
        productMap.put(p.id, p);


        if (!categoryMap.containsKey(p.category)) {
            categoryMap.put(p.category, new ArrayList<>());
        }
        categoryMap.get(p.category).add(p);
    }

    public Product findById(String id) {
        return productMap.get(id);
    }
    public List<Product> findByPriceRange(double min, double max) {
        List<Product> result = new ArrayList<>();
        for (Product p : productMap.values()) {
            if (p.price >= min && p.price <= max) {
                result.add(p);
            }
        }
        return result;
    }
    public List<Product> findByCategory(String category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public List<Product> findRelated(Product product) {
        List<Product> related = new ArrayList<>();
        for (Product p : findByCategory(product.category)) {
            if (!p.id.equals(product.id)) {
                if (Math.abs(p.price - product.price) <= product.price * 0.2) {
                    related.add(p);
                }
            }
        }
        return related;
    }
}
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product("P1", "Phone", 500, 0.4, "Electronics"));
        inventory.addProduct(new Product("P2", "Laptop", 1000, 2.0, "Electronics"));
        inventory.addProduct(new Product("P3", "T-Shirt", 20, 0.2, "Clothing"));
        inventory.addProduct(new Product("P4", "Tablet", 450, 0.7, "Electronics"));
        inventory.addProduct(new Product("P5", "Jeans", 30, 0.5, "Clothing"));

        System.out.println("Find by ID (P2):");
        System.out.println(inventory.findById("P2"));

        System.out.println("\nProducts between $100 and $600:");
        for (Product p : inventory.findByPriceRange(100, 600)) {
            System.out.println(p);
        }

        System.out.println("\nClothing Products:");
        for (Product p : inventory.findByCategory("Clothing")) {
            System.out.println(p);
        }
        System.out.println("\nRelated to Tablet:");
        Product tablet = inventory.findById("P4");
        for (Product p : inventory.findRelated(tablet)) {
            System.out.println(p);
        }
    }
}
