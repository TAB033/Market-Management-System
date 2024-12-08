package mart;

public class product extends productID{
    private String ProductId;
    private String name;
    private double price;
    private int quantity;

    public product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ProductId = s;
    }

    public product(String id, String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ProductId = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductID()
    {
        return ProductId;
    }
}
