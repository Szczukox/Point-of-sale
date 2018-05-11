package app;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Display {

    private ArrayList<Product> products;
    private DecimalFormat priceFormat;
    private double totalSum;

    public Display() {
        products = new ArrayList<Product>();
        priceFormat = new DecimalFormat("0.00");
        totalSum = 0.0;
    }

    /**
     *
     * @return array of products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     *
     * @return total sum of prices in array of products
     */
    public double getTotalSum() {
        return totalSum;
    }

    /**
     * Display "Invalid bar-code." message if the code scanned is empty
     */
    public void displayInvalidBarCodeMessage() {
        System.out.println("Invalid bar-code.");
    }

    /**
     * Display "Product not found." message if the product is not found
     */
    public void displayProductNotFoundMessage() {
        System.out.println("Product not found.");
    }

    /**
     * Display name and price product if it is found in products database
     * @param product product whose scanned bar-code is correct
     */
    public void displayProductInfo(Product product) {
        products.add(product);
        System.out.println(product.getName());
        System.out.println(priceFormat.format(product.getPrice()));
    }

    public void displayTotalSum() {
        for (Product product : products) {
            totalSum += product.getPrice();
        }
        System.out.println("TOTAL SUM: " + priceFormat.format(totalSum));
    }
}
