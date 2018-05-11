package app;


public class Product {
    private int id;
    private String name;
    private double price;

    /**
     *
     * @param id product ID
     * @param name product name
     * @param price product price
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     *
     * @return product ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return product price
     */
    public double getPrice() {
        return price;
    }
}
