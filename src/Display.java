import java.text.DecimalFormat;
import java.util.ArrayList;

public class Display {

    private ArrayList<Product> products;

    public Display() {
        products = new ArrayList<Product>();
    }

    public ArrayList<Product> getProducts() {
        return products;
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
        System.out.println(product.getPrice());
    }

    public void displaySum() {
        double sum = 0.0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("SUM: " + decimalFormat.format(sum));
    }
}
