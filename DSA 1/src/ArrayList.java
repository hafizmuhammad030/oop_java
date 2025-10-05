import java.util.*;

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}

class Order {
    int orderId;
    ArrayList<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String toString() {
        return "Order ID: " + orderId + ", Products: " + products;
    }
}
 class ECommerceSystem {
    ArrayList<Product> inventory = new ArrayList<Product>();
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<String> wishlist = new ArrayList<String>();

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void updateProduct(int id, String newName, double newPrice) {
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if (p.id == id) {
                p.name = newName;
                p.price = newPrice;
                return;
            }
        }
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).id == id) {
                inventory.remove(i);
                return;
            }
        }
    }

    public Product searchProduct(int id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).id == id) {
                return inventory.get(i);
            }
        }
        return null;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order searchOrder(int orderId) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).orderId == orderId) {
                return orders.get(i);
            }
        }
        return null;
    }

    public void sortProductsByPrice() {
        for (int i = 0; i < inventory.size() - 1; i++) {
            for (int j = i + 1; j < inventory.size(); j++) {
                if (inventory.get(i).price > inventory.get(j).price) {
                    Product temp = inventory.get(i);
                    inventory.set(i, inventory.get(j));
                    inventory.set(j, temp);
                }
            }
        }
    }

    public ArrayList<Product> filterProductsByPrice(double minPrice) {
        ArrayList<Product> filtered = new ArrayList<Product>();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).price > minPrice) {
                filtered.add(inventory.get(i));
            }
        }
        return filtered;
    }

    public void addToWishlist(String productName) {
        wishlist.add(productName);
    }

    public void removeFromWishlist(String productName) {
        for (int i = 0; i < wishlist.size(); i++) {
            if (wishlist.get(i).equals(productName)) {
                wishlist.remove(i);
                return;
            }
        }
    }

    public void displayWishlist() {
        System.out.println("Wishlist: " + wishlist);
    }

    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();


        system.addProduct(new Product(1, "Laptop", 1000));
        system.addProduct(new Product(2, "Smartphone", 700));


        Order order1 = new Order(101);
        order1.addProduct(new Product(1, "Laptop", 1000));
        system.addOrder(order1);


        system.sortProductsByPrice();
        System.out.println("Sorted Products " + system.inventory);


        System.out.println("Filtered Products " + system.filterProductsByPrice(800));


        system.addToWishlist("Laptop");

        system.displayWishlist();
    }
}

