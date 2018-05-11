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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void displayInvalidBarCodeMessage() {
        System.out.println("Invalid bar-code.");
    }

    public void displayProductNotFoundMessage() {
        System.out.println("Product not found.");
    }

    public void displayProductInfo(Product product) {
        products.add(product);
        System.out.println(product.getName());
        System.out.println(priceFormat.format(product.getPrice()));
    }

    public void displayTotalSum() {
        for (Product product : products) {
            totalSum += product.getPrice();
        }
        System.out.println("SUM: " + priceFormat.format(totalSum));
    }
}
